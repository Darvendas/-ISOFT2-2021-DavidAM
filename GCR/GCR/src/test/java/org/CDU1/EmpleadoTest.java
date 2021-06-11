package org.CDU1;

import java.time.LocalDate;
import junit.framework.TestCase;


public class EmpleadoTest extends TestCase{

	public void testEmpleado() throws Exception {
		Empleado c = new Empleado("", (byte) 2);
		assertTrue((c.getHorarioTrabajo().equals("")) && (c.getlocal() == 2));
	}


	public void testGetHorarioTrabajo() throws Exception {
		Empleado c = new Empleado("", (byte) 2);
		assertTrue(c.getHorarioTrabajo().equals(""));
	}


	public void testGetlocal() throws Exception {
		Empleado c = new Empleado("", (byte) 2);
		assertTrue(c.getlocal() == 2);
	}


	public void testSetHorarioTrabajo() throws Exception {
		Empleado c = new Empleado("", (byte) 2);
		c.setHorarioTrabajo("2");
		assertTrue(c.getHorarioTrabajo().equals("2"));
	}


	public void testSetlocal() throws Exception {
		Empleado c = new Empleado("", (byte) 2);
		c.setlocal((byte) 3);
		assertTrue(c.getlocal() == 3);
	}

}
