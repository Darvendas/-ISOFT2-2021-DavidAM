package org.CDU2;

import java.time.LocalDate;

import junit.framework.TestCase;

public class PedidoTest extends TestCase{
	
	public void testPedido1() {
		Pedido m = new Pedido("X22n12");
		assertTrue(m.getIdPedido() == "X22n12" && m.getEstadoByte() == 1);
	}
	
	
	public void testGetIdMesa() throws Exception {
		Pedido m = new Pedido("X22n12");
		assertTrue(m.getIdPedido() == "X22n12" );
	}

	public void testSetIdMesa() throws Exception {
		Pedido m = new Pedido("X22n12");
		m.setIdMesa("X22n13");
		assertTrue(m.getIdPedido() == "X22n13");
	}

	public void testTiempo() throws Exception {
		Pedido m = new Pedido("X22n12");
		m.setTiempo(10);
		assertTrue(m.getTiempo() == 10);
	}

	public void testGetEstado() throws Exception {
		Pedido m = new Pedido("X22n12");
		assertTrue(m.getEstado().equals("En Proceso"));
	}

	public void testSetEstado() throws Exception {
		boolean p1 = false, p2 = false, p3 = false;
		Pedido m = new Pedido("X22n12");
		m.setEstado((byte)2);
		p1 = (m.getEstado().equals("En horno") && m.getEstadoByte() == 2);
		if(p1) {
			m.setEstado((byte)1);
			p2 = (m.getEstado().equals("En Proceso") && m.getEstadoByte() == 1);
			if(p2) {
				m.setEstado((byte)9);
				try {
					m.setEstado((byte)2);
				}catch(EstadoNoValidoException a) {
					p3 = true;
				}
			}
		}
		assertTrue(p1 && p2 && p3);
	}
	
	public void testGetEstadoByte() throws Exception {
		Pedido m = new Pedido("X22n12");
		assertTrue(m.getEstadoByte() == 1);
	}

	

	public void testTime_beginning() throws Exception {
		Pedido m = new Pedido("X22n12");
		LocalDate d = LocalDate.now();
		m.setTime_beginning(d);
		assertTrue(m.getTime_beginning().equals(d));
	}

	public void testGetEstados() throws Exception {
		Pedido m = new Pedido("X22n12");
		String[] p1 = {"Libre","Reservada","Ocupada","Pidiendo","En espera de comida","Servidos","Esperando la cuenta","Pagando","En Preparación"};
		boolean a = true;
		String[] p2 = m.getEstados();
		if(p1.length == p2.length) {
			for (int i = 0; i < p1.length && a; i++) {
				a = (p1[i].equals(p2[i]));
			}
		}else {
			a = false;
		}
		assertTrue(a);
	}
	


}
