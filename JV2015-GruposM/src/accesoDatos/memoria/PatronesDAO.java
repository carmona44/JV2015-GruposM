package accesoDatos.memoria;
/** 
 * Proyecto: Juego de la vida.
 *  Resuelve todos los aspectos del almacenamiento del
 *  DTO Patron utilizando un ArrayList persistente en fichero.
 *  Colabora en el patron Fachada.
 *  @since: prototipo2
 *  @source: PatronesDAO.java 
 *  @version: 1.0 - 2016/05/23 
 *  @author: ajp
 */
import java.util.ArrayList;

import accesoDatos.DatosException;
import accesoDatos.OperacionesDAO;
import modelo.Patron;

public class PatronesDAO implements OperacionesDAO {

	// Requerido por el Singleton 
	private static PatronesDAO instancia = null;
	
	// Elemento de almacenamiento. 
	private ArrayList<Patron> datosPatrones;
	
	/**
	 * Constructor por defecto de uso interno.
	 * Sólo se ejecutará una vez.
	 */
	private PatronesDAO() {
		datosPatrones = new ArrayList<Patron>();
	}

	/**
	 *  Método estático de acceso a la instancia única.
	 *  Si no existe la crea invocando al constructor interno.
	 *  Utiliza inicialización diferida.
	 *  Sólo se crea una vez; instancia única -patrón singleton-
	 *  @return instancia
	 */
	public static PatronesDAO getInstancia() {
		if (instancia == null) {
			instancia = new PatronesDAO();
		}
		return instancia;
	}
		
	//OPERACIONES DAO
	/**
	 * Búsqueda binaria de un Patron dado su nombre.
	 * @param nombre - el nombre del Patron a buscar.
	 * @return - el Patron encontrado; null si no existe.
	 */	
	@Override
	public Patron obtener(String nombre) {
		int inicio = 0;
		int fin = datosPatrones.size() - 1;
		int medio;
		int comparacion;					// auxiliar para la comparación de String
		while (inicio <= fin) {
			medio = (inicio + fin) / 2;
			comparacion = datosPatrones.get(medio).getNombre().compareToIgnoreCase(nombre);
			if (comparacion == 0) {
				return datosPatrones.get(medio);
			}
			if (comparacion < 0) { 
				inicio = medio + 1;
			}
			else {
				fin = medio - 1;
			}
		}
		return null;
	}
	
	/**
	 * Búsqueda de Patron dado un objeto, reenvía al método que utiliza nombre.
	 * @param obj - el Patron a buscar.
	 * @return - el Patron encontrado; null si no existe.
	 */
	@Override
	public Patron obtener(Object obj)  {
		return this.obtener(((Patron) obj).getNombre());
	}
	
	/**
	 *  Alta de un nuevo Patron en orden y sin repeticiones según el campo nombre. 
	 *  Busca previamente la posición que le corresponde por búsqueda binaria.
	 * @param obj - Patron a almacenar.
	 * @throws DatosException - si ya existe.
	 */
	@Override
	public void alta(Object obj) throws DatosException {
		assert obj != null;
		Patron patron = (Patron) obj;
		int inicio = 0;
		int fin = datosPatrones.size()-1;
		int medio;
		int comparacion;					// auxiliar para la comparación de String
		while (inicio <= fin) {
			medio = (inicio + fin) / 2;     // calcula posición central
			// compara los dos id. Obtiene < 0 si id va después que medio
			comparacion = datosPatrones.get(medio).getNombre().compareTo(patron.getNombre());
			if (comparacion == 0) {			// id coincide con el comparado
				throw new DatosException("El Patron ya existe...");
			}
			if (comparacion < 0) {			// id va después alfabéticamente 
				inicio = medio + 1;
			}
			else {				 			// id va antes alfabéticamente
				fin = medio - 1;
			}
		}
	}
	
	/*
	 * Baja de un patr�n ya existente.
	 * Lanza una excepci�n si la id pasada por par�metro es null o si al obtener el objeto correspondiente a la id
	 * tambi�n es nulo.
	 */
	@Override
	public Object baja(String id) throws DatosException {
		
		assert id == null;
		assert obtener(id) == null;
		datosPatrones.remove(obtener(id));
		
		return null;
	}

	@Override
	public void actualizar(Object obj) throws DatosException {
		
		
	}

	/*
	 * Lista los datos de los Patrones existentes.
	 * Muestra mensaje de error si no se han podido listar.
	 */
	@Override
	public String listarDatos() {
		try{
			for (Patron p : datosPatrones){
				System.out.println(p);
			}
		}
		catch(Exception e){
			System.out.println("No se ha podido listar los datos de los Patrones.");
		}
		return null;
	} 
	
} //class
