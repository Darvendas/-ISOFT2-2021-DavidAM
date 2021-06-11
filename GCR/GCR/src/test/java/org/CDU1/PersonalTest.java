package org.CDU1;

import junit.framework.TestCase;

public class PersonalTest extends TestCase{

	public void testGetReserva() throws Exception {
		boolean apto = false;
		Personal p = new Personal("Pablo","00000000A",true,"000000000");
		try {
			p.getReserva();
		}catch(UnsupportedOperationException ex) {
			apto = true;
		}
		assertTrue(apto);
	}

	public void testSetReserva() throws Exception {
		boolean apto = false;
		Personal p = new Personal();
		try {
			Reserva[] res = new Reserva[1];
			p.setReserva(res);
		}catch(UnsupportedOperationException ex) {
			apto = true;
		}
		assertTrue(apto);
	}

}
