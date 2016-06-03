package modelo.test;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.Patron;

public class PatronTest {
	private Patron patron1;
	private Patron patron2;
	private Patron patron3;
	
	@Before
	public void crearObjetosPrueba() {
		patron1 = new Patron();
		patron2 = new Patron("NombrePruebaPatron", new byte[1][2]);
		patron3 = new Patron(patron2);
	}
	
	@After
	public void borrarObjetosPrueba() {
		patron1 = null;
		patron2 = null;
		patron3 = null;
	}
	
	@Test
	public void testPatronConvencional() {
		assertTrue(patron2 != null);
	}
	
	@Test
	public void testPatronPorDefecto() {
		assertTrue(patron1 != null);
	}
	
	@Test
	public void testPatronCopia() {
		assertTrue(patron3 != null);
	}

	@Test
	public void testGetNombre() {
		assertEquals(patron2.getNombre(), "NombrePruebaPatron");
	}

	@Test
	public void testGetEsquema() {
		assertNotNull(patron2.getEsquema());
	}

	@Test
	public void testSetNombre() {
		patron1.setNombre("PatronNombre");
		assertEquals(patron1.getNombre(), "PatronNombre");
	}

	@Test
	public void testSetEsquema() {
		byte [][] esquema = new byte[2][2];
		patron1.setEsquema(esquema);
		assertSame(patron1.getEsquema(), esquema);
	}

	@Test
	public void testToString() {
		assertEquals(patron2.toString(), "Patron [nombre=NombrePruebaPatron, esquema="
				+ new byte [1][2] + "]"); 
	}

}
