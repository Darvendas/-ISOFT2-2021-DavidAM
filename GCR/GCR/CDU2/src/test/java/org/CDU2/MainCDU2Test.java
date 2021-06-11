package org.CDU2;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MainCDU2Test {
	private String dBUrl = "jdbc:mysql://172.20.48.70:3306/B02dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String group = "1";
	private String pwd = "@ISoft2.2020#";
	private MainCDU2 mainCDU2;

	@Test
	public void testComputarCuenta() throws Exception {
		Order[] ords = new Order[2];
		ords[0] = new Order("Agua", (short)1);
		ords[1] = new Order("Gaseosa", (short)2);
		double p = mainCDU2.computarCuenta(ords);
		assertTrue(p == 11);
	}

	@SuppressWarnings("static-access")
	@Test
	public void testGenerarHiloAndKill() throws Exception {
		mainCDU2 = new MainCDU2();
		mainCDU2.generarNuevoHilo("X3321N", 2,2);
		mainCDU2.matarHilos();
		assertTrue(true);
	}


	@Test
	public void testCargarMenu() throws Exception {
		boolean p1 = false, p2 = false;
		Connection con = DriverManager.getConnection(dBUrl,group,pwd);
		String[] s1 = mainCDU2.cargarMenu(con, "BEBERAGE");
		p1 = (s1.length > 0);
		if(p1) {
			try {
				String[] s2 = mainCDU2.cargarMenu(con, "");
				p2 = (s2.length == 0);
			}catch(SQLException good){
				p2 = true;
			}
		}
		assertTrue(p1 && p2);
	}

	@Test
	public void testImprimirRecibo() throws Exception {
		boolean p1 = false, p2 = false;
		Order[] ords = new Order[5];
		ords[0] = new Order("Pastel Rosa",(short)22);
		ords[1] = new Order("Pastel Azul",(short)1);
		ords[2] = new Order("Pastel Azul",(short)1);
		ords[3] = new Order("Pastel Azul",(short)1);
		ords[4] = new Order("Pastel Azul",(short)1);
		mainCDU2.imprimirRecibo(1, ords);
		p1 = true;
		ords = new Order[0];
		try {
			mainCDU2.imprimirRecibo(-1, ords);
		}catch(ArrayIndexOutOfBoundsException e) {
			p2 = true;
		}
		assertTrue(p1 && p2);
	}

}
