package org.CDU2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCDU2 {
	static int nEspera = 5;
	static Thread [] hilos = new Thread[nEspera]; //Solo podra haber un numero de hilos para avisar a los empleados igual al numero de pedidos al mismo tiempo en la pasteleria;
	static String DBUrl = "jdbc:mysql://172.20.48.70:3306/B02dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static String pwd = "@ISoft2.2020#";
	static String[] parMenu = {"Desayuno","Tarta","Batido","Cafe"};

	public static void main(String[] args) {
		Pedido pedidos [] = new Pedido[nEspera];
		progEmpleados(pedidos);
		matarHilos();
		System.out.println("Apagando programa...");
	}
	
	private static void progEmpleados(Pedido[] pedidos) {
		boolean a = true;
		Scanner k = new Scanner(System.in);
		while(a) {
			try {
				DBUrl = "jdbc:mysql://172.20.48.70:3306/B02dbservice?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
				Class.forName("com.mysql.cj.jdbc.Driver"); //Importante para establecer conexion con BD
				System.out.println("Presione:\n 1.-Elegir mesa ocupada para atenderla\n 2.-Atender pedido \n 3.-Cambiar estado de una Pedido\n 4. Calcular importe y imprimir recibo\n 0.-Apagar sistema");
				int opt = k.nextInt();
				switch(opt) {
				case 0:
					a = false;
					break;
				case 1:
					elegirPedido(pedidos, k);
					break;
				case 2:
					modificarPedido(pedidos,k);
					break;
				case 3: 
					recibo(pedidos,k);
					break;
				default:
					System.out.println("Opción no reconocida: "+Integer.toString(opt));
					break;
				}
			}catch(InputMismatchException e) {
				System.out.println("Error, opción no válida");
				k.next();
			}catch (EstadoNoValidoException e) {
				System.out.println("Una Pedido no puede seguir el flujo");
			}catch (SQLException e) {
				System.out.println("Error al conectar con la BD");
				e.printStackTrace();
			}catch (ClassNotFoundException e ) {
				System.out.println("Error al ejecutar conexión a la BD \n");
				e.printStackTrace();
				a = false;
			}catch(ArrayIndexOutOfBoundsException arr) {
				System.out.println("Indice no valido");
			}
		}
		k.close();
	}

	public static void recibo(Pedido[] pedidos, Scanner k) throws SQLException, ArrayIndexOutOfBoundsException {
		double cant = 0;
		System.out.println("Seleccione el Pedido que deseé calcular cuenta:");
		for(int i = 0; i < pedidos.length; i++) {
			System.out.println("Pedido "+Integer.toString(i+1)+": "+pedidos[i].getIdPedido());
		}
		int pos = k.nextInt() - 1;
		cant = computarCuenta(pedidos[pos].getPedidos());
		System.out.println("La cuenta asciende a "+ Double.toString(cant) + " euros.");
		imprimirRecibo(pos,pedidos[pos].getPedidos());
	}
	
	
	public static double computarCuenta(Order[] pedidosPedido) throws SQLException {
		double cant = 0;
		String sql = "";
		ResultSet res = null;
		double precio = 0;
		Connection con = DriverManager.getConnection(DBUrl,"1",pwd);
		Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		for (int i = 0;i < pedidosPedido.length;i++) {
			sql = "SELECT PRICE FROM DISH WHERE NAME= '"+pedidosPedido[i].getDishID()+"'";
			res = s.executeQuery(sql);
			while(res.next()) {
				precio = res.getDouble(1);
				cant = cant + precio * ((double) pedidosPedido[i].getAmount());
			}
		}
		res.close(); s.close(); con.close();
		return cant;
	}

	private static void modificarPedido(Pedido[] pedidos, Scanner k) throws InputMismatchException, EstadoNoValidoException, ArrayIndexOutOfBoundsException{
		System.out.println("Seleccione Pedido para modificar:");
		for(int i = 1; i < pedidos.length+1; i++) {
			System.out.println("Pedido "+Integer.toString(i)+": "+pedidos[i-1].getEstado());
		}
		int pos = k.nextInt() - 1;
		System.out.println("¿Que estado desea asignar?");
		String [] estados = pedidos[0].getEstados();
		for(int i = 0; i < estados.length; i++) {
			System.out.println(Integer.toString(i+1)+" - "+estados[i]);
		}
		int estado = k.nextInt();
		if(pedidos[pos].getEstadoByte() == 4 && estado >= 4) { //Se atiende el Pedido, terminamos el hilo llamando al Empleado que esperaba
			hilos[pos].interrupt();
		}
		pedidos[pos].setEstado((byte) estado);
		if(estado == 7 ) { //Cuando el pedido se ha terminado de atender se genera un nuevo hilo
			generarNuevoHilo(pedidos[0].getIdPedido(),pos, pedidos[0].getTiempo());
		}
		System.out.println("Pedido "+Integer.toString(pos+1)+" se encuentra ahora en el estado: "+estados[estado-1]);
	}


	private static void elegirPedido(Pedido[] pedidos, Scanner k) throws InputMismatchException, EstadoNoValidoException, ArrayIndexOutOfBoundsException{
		System.out.println("¿Que Pedido ha empezado a atender?");
		for(int i = 1; i < pedidos.length+1; i++) {
			System.out.println(Integer.toString(i)+ " - Pedido "+Integer.toString(i));
		}
		int pos = k.nextInt() - 1;
		pedidos[pos].setEstado((byte) 4);
		System.out.println("Se esta atendiendo ahora a la Pedido "+Integer.toString(pos+1));
		if(hilos[pos] != null) {
			hilos[pos].interrupt();
		}
	}

	public static void generarNuevoHilo(String id,int pos, int h) {
		hilos[pos] = new Thread((Runnable) new HiloEmpleado(id, h));
		hilos[pos].start();
	}
	
	public static void matarHilos() {
		for(int i = 0; i < hilos.length; i++) {
			if(hilos[i] != null) {
				if(hilos[i].isAlive()) {
					hilos[i].interrupt();
				}
			}
		}
	}
	
	public static String[] cargarMenu(Connection con, String type) throws SQLException {
		Statement s = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		String sql = "SELECT * FROM DISH WHERE TYPE = '"+type+"';";
		ResultSet res = s.executeQuery(sql);
		res.last();
		String[] opciones = new String[res.getRow()];
		res.beforeFirst();
		int n = 0;
		while(res.next()) {
			opciones[n] = res.getString(1);
			n++;
		}
		s.close(); res.close();
		return opciones;
	}
	
	public static void imprimirRecibo(int pos, Order[] orden) throws ArrayIndexOutOfBoundsException{
		for(int i = 0; i < orden.length; i++) {
			System.out.println(orden[i].getDishID());
		}
	}
	
}
