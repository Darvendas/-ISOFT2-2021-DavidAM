package org.CDU1;

import java.time.LocalDate;

import junit.framework.TestCase;

public class PedidoTest extends TestCase{
	
	public void testPedido1() {
		Pedido m = new Pedido((short)1);
		assertTrue(m.getIdPedido() == 1 && m.getEstadoByte() == 1);
	}
	
	public void testGetIdPedido() throws Exception {
		Pedido m = new Pedido((short)1);
		assertTrue(m.getIdPedido() == 1 );
	}

	public void testSetIdPedido() throws Exception {
		Pedido m = new Pedido((short)1);
		m.setIdPedido((short)2);
		assertTrue(m.getIdPedido() == 2);
	}

	public void testGetTiempo_prefijado() throws Exception {
		Pedido m = new Pedido((short)1);
		assertTrue(m.getTiempo_prefijado() == 30);
	}

	public void testSetTiempo_prefijado() throws Exception {
		Pedido m = new Pedido((short)1);
		m.setTiempo_prefijado(10);
		assertTrue(m.getTiempo_prefijado() == 10);
	}


	public void testGetEstado() throws Exception {
		Pedido m = new Pedido((short)1);
		assertTrue(m.getEstado().equals("En Proceso"));
	}

	public void testSetEstado() throws Exception {
		boolean p1 = false, p2 = false, p3 = false;
		Pedido m = new Pedido((short)1);
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
		Pedido m = new Pedido((short)1);
		assertTrue(m.getEstadoByte() == 1);
	}


	public void testTime_beginning() throws Exception {
		Pedido m = new Pedido((short)1);
		LocalDate d = LocalDate.now();
		m.setTime_beginning(d);
		assertTrue(m.getTime_beginning().equals(d));
	}

	public void testGetEstados() throws Exception {
		Pedido m = new Pedido((short)1);
		String[] p1 = {"En Proceso","En horno","Listo para recoger","Cliente en tienda","Cancelado","No recibido","Recibido"};
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
	
	public void testCalcularPrecio() throws Exception {
		Pedido m = new Pedido((short)1);
		boolean p = false;
		try {
			m.calcularPrecio();
		}catch(UnsupportedOperationException a){
			p = true;
		}catch(Exception ex) {
			//error
		}finally {
			assertTrue(p);
		}
	}

}
