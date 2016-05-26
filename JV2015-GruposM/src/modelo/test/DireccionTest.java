package modelo.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Direccion;

public class DireccionTest {
	private Direccion direccion1;
	private Direccion direccion2;
	private Direccion direccion3;
	
	@Before
	public void crearObjetosPrueba() {
		direccion1 = new Direccion();
		direccion2 = new Direccion("30011", "Pio", "15", "Murcia", "España");
		direccion3 = new Direccion(direccion2);
	}
	
	@After
	public void borrarObjetosPrueba() {
		direccion1 = null;
		direccion2 = null;
		direccion3 = null;
	}
	
	@Test
	public void testDireccionConvencional() {
		assertTrue(direccion2 != null);
	}
	
	@Test
	public void testDireccionPorDefecto() {
		assertTrue(direccion1 != null);
	}
	
	@Test
	public void testDireccionCopia() {
		assertTrue(direccion3 != null);
	}

	@Test
	public void testGetCodigoPostal() {
		assertEquals(direccion2.getCodigoPostal(), "30011");
	}

	@Test
	public void testGetVia() {
		assertEquals(direccion2.getVia(), "Pio");
	}
	
	@Test
	public void testGetNumero() {
		assertEquals(direccion2.getNumero(), "15");
	}
	
	@Test
	public void testGetPoblacion() {
		assertEquals(direccion2.getPoblacion(), "Murcia");
	}
	
	@Test
	public void testGetPais() {
		assertEquals(direccion2.getPais(), "España");
	}

	@Test
	public void testSetCodigoPostal() {
		direccion1.setCodigoPostal("30009");
		assertEquals(direccion1.getCodigoPostal(), "30009");
	}

	@Test
	public void testSetVia() {
		direccion1.setVia("Baroja");
		assertEquals(direccion1.getVia(), "Baroja");
	}
	
	@Test
	public void testSetNumero() {
		direccion1.setNumero("20");
		assertEquals(direccion1.getNumero(), "20");
	}
	
	@Test
	public void testSetPoblacion() {
		direccion1.setPoblacion("Alicante");
		assertEquals(direccion1.getPoblacion(), "Alicante");
	}
	
	@Test
	public void testSetPais() {
		direccion1.setPais("Francia");
		assertEquals(direccion1.getPais(), "Francia");
	}

	@Test
	public void testToString() {
		assertEquals(direccion2.toString(), "30011" + ", " + "Pio" + ", " + "15"
				+ ", " + "Murcia" + ", " + "España"); 
	}

}
