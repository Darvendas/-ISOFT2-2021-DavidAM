package org.CDU1;

import java.util.Date;
import java.util.Scanner;

public class Jefe extends Personal {

	private int idJefe;
	private int idLocal;
	
	private static Scanner teclado = new Scanner(System.in);
	
	public Jefe(int idJefe, int idLocal) {
		super();
		this.idJefe = idJefe;
		this.idLocal = idLocal;
	}

	public Pedido[] reservar_Pedido(Pedido[] Pedidos,int producto, int citación) throws EstadoNoValidoException, InterruptedException {

		teclado = new Scanner(System.in);
		boolean stock = false;
		Reserva reserva = null;
		int dia = new Date().getDay();
		String diaString = dia+"";
		String nombre = "";
		int hora;
		
		System.out.println("El pedido estara disponible alrededor de el dia " +dia);
		System.out.println("Comprobando si se podra efectuar el pedido ...");
		Thread.sleep(1000);
		
		for(int i= 0; i< Pedidos.length;i++) {
			//aqui se contactara con la bbdd para ver si tenemos ingredientes
			// como es un enunciado teorico se dara por su puesto que se tienen los ingredientes
			stock = true;
			}
		
		if (stock ==true) {
			return Pedidos;
		}else {
			System.out.println("No existen Pedido.");
			return Pedidos;
		}
		
	}



	public static int seleccionarTurno() { // existen dos turnos para recoger (mañana y tarde) 
		int turno;
		teclado = new Scanner(System.in);
		System.out.println("Selecciona el turno. seleccione primer turno(0) segundo turno(1) \n");
		turno = teclado.nextInt();
		while (turno != 0 && turno != 1 && turno > 2) {
			System.out.println("Debe de seleccionar un turno comprendido entre 0 y 1, Intentelo de nuevo.");
			turno = teclado.nextInt();
		}
		return turno;
	}

	public static int seleccionarproducto() {
		int seleccion;
		teclado = new Scanner(System.in);
		System.out.println("Quiere un pastel (0) o un batido(1)");
		seleccion = teclado.nextInt();
		while (seleccion != 1 && seleccion != 2) {
			System.out.println("Debe de seleccionar un 1 para pastel y 2 para batido. Intentelo de nuevo.");
			seleccion = teclado.nextInt();
		}

		return seleccion;

	}

	@Override
	public String toString() {
		return "Jefe [idJefe=" + idJefe + ", idLocal=" + idLocal + "]";
	}
}