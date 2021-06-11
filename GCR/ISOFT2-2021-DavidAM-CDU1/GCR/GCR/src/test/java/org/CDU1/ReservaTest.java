package org.CDU1;

import junit.framework.TestCase;

public class ReservaTest extends TestCase{

	public void testReservaPedido1() throws Exception {
		Reserva rs = new Reserva (new Pedido((short) 1),(short)1, "1", "Joel", "-", "Arthur");
		assertTrue("Reserva [Pedido=1, hora=1, dia=1, cliente=Joel]".equals(rs.toString()));
	}


	public void testReservaPedido2() throws Exception {
		Reserva rs = new Reserva (new Pedido((short) 2),(short)6, "12", "Jose");
		assertTrue("Reserva [Pedido=2, hora=6, dia=12, cliente=Jose]".equals(rs.toString()));
	}
}
