package modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Contraseña;
import modelo.Correo;
import modelo.Direccion;
import modelo.Nif;
import modelo.Usuario;
import modelo.Usuario.RolUsuario;
import util.Fecha;

public class UsuarioTest {
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	
	@Before
	public void crearObjetosPrueba() {
		usuario1 = new Usuario();
		usuario2 = new Usuario(new Nif("12345678A"), "Pepe", "López Pérez",
				new Direccion("30012", "Alta", "10", "Murcia", "España"), 
				new Correo("pepe@gmail.com"), new Fecha(2010, 4, 27),
				new Fecha(2016, 5, 15), new Contraseña("Contraseña#2"), RolUsuario.NORMAL);
		usuario3 = new Usuario(usuario2);
	}
	
	@After
	public void borrarObjetosPrueba() {
		usuario1 = null;
		usuario2 = null;
		usuario3 = null;
	}
	
	@Test
	public void testUsuarioConvencional() {
		assertTrue(usuario2 != null);
	}
	
	@Test
	public void testUsuarioPorDefecto() {
		assertTrue(usuario1 != null);
	}
	
	@Test
	public void testUsuarioCopia() {
		assertTrue(usuario3 != null);
	}

	@Test
	public void testGetIdUsr() {
		assertEquals(usuario2.getIdUsr(), "PLP8A");
	}

	@Test
	public void testGetClaveAcceso() {
		assertNotNull(usuario2.getClaveAcceso());	
	}

	@Test
	public void testGetFechaAlta() {
		assertNotNull(usuario2.getFechaAlta());	
	}

	@Test
	public void testGetRol() {
		assertNotNull(usuario2.getRol());
	}

	@Test
	public void testGenerarIdUsr() {
		// falta implementar, no estoy seguro de como se hace.
	}

	@Test
	public void testSetClaveAcceso() {
		Contraseña contraseña = new Contraseña("Contraseña#5");
		usuario1.setClaveAcceso(contraseña);
		assertSame(usuario1.getClaveAcceso(), contraseña);
	}

	@Test
	public void testSetFechaAlta() {
		Fecha fecha = new Fecha(2016, 5, 17);
		usuario1.setFechaAlta(fecha);
		assertSame(usuario1.getFechaAlta(), fecha);
	}

	@Test
	public void testSetRol() {
		RolUsuario rol = RolUsuario.ADMINISTRADOR;
		usuario1.setRol(rol);
		assertSame(usuario1.getRol(), rol);
	}

	@Test
	public void testToString() {
		assertEquals(usuario2.toString(), " nif: \t\t12345678A," +
				 "\n nombre: \tPepe," +
				 "\n apellidos: \tLópez Pérez," +
				 "\n idUsr: \tPLP8A," +
				 "\n domicilio: \t30012, Alta, 10, Murcia, España," +
				 "\n correo: \tpepe@gmail.com," +
				 "\n fechaNacimiento: \t2010.4.27," +
				 "\n fechaAlta: \t2016.5.15," +
				 "\n claveAcceso: \tGsqyvexired!," +
				 "\n rol: \t\tNORMAL"); 
	}

}
