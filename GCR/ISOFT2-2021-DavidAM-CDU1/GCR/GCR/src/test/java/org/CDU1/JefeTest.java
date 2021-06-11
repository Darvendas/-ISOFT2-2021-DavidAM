package org.CDU1;

import java.util.InputMismatchException;

import junit.framework.Assert;
import junit.framework.TestCase;

public class JefeTest extends TestCase{
	
	public void testJefe_sala() throws Exception {
		Jefe j = new Jefe(1,1);
		assertTrue("Jefe [idJefe=1, idSala=1]".equals(j.toString()));
	}

	public void testSeleccionarTurno() throws Exception {
		try {
			int i = Jefe.seleccionarTurno();
			assertTrue(i == 0 || i == 1 || i == 2); //Las unicas opciones disponibles son 0 y 1
		}catch (InputMismatchException x) {
			Assert.fail();
		}
	}

	public void testSeleccionarComidaCena() throws Exception {
		try {
			int i = Jefe.seleccionarproducto();
			assertTrue(i == 1 || i == 2); //Las unicas opciones disponibles son 0 y 1
		}catch (InputMismatchException x) {
			Assert.fail();
		}
	}

	public void testToString() throws Exception {
		Jefe j = new Jefe(1,1);
		assertTrue("Jefe_sala [idJefe=1, idSala=1]".equals(j.toString()));
	}

}
