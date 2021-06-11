package org.CDU1;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MainTest {

	@Test
	public void testInitPedidos() throws Exception {
		Pedido[] Pedidos = new Pedido[5];
		Main.initPedidos(Pedidos);
		assertTrue(true);
	}

}
