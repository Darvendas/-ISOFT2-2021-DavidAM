package org.CDU2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class HiloEmpleadoTest {

	@Test
	public void testRun() throws Exception {
		Thread t = new Thread(new HiloEmpleado("XA13512N41", 29));
		t.start();
		Thread.sleep(3000);
		t.interrupt();
		Thread.sleep(2000);
		assertTrue(!t.isAlive());
	}

	@Test
	public void testHiloCamarero() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		assertTrue(c.getPedido() == "XA13512N41" && c.gethoras() == 60);
	}

	@Test
	public void testGetPedido() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		assertTrue(c.getPedido() == "XA13512N41");
	}

	@Test
	public void testGethoras() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		assertTrue(c.gethoras() == 60);
	}

	@Test
	public void testGethorasCumulativos() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		c.sethorasCumulativos(0);
		assertTrue(c.gethorasCumulativos() == 0);
	}

	@Test
	public void testSetPedido() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		c.setPedido("XA13512N41");
		assertTrue(c.getPedido() == "XA13512N41");
	}

	@Test
	public void testSethoras() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		c.sethoras(2);
		assertTrue(c.gethoras() == 2);
	}

	@Test
	public void testSethorasCumulativos() throws Exception {
		HiloEmpleado c = new HiloEmpleado("XA13512N41", 60);
		c.sethorasCumulativos(0);
		assertTrue(c.gethorasCumulativos() == 0);
	}
}
