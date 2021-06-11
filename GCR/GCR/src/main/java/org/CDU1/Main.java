package org.CDU1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws EstadoNoValidoException, InputMismatchException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		Pedido[] Pedidos = new Pedido[100];
		initPedidos(Pedidos);
		Jefe jefeS;
		System.out.println("Jefe logeado...");
		jefeS = new Jefe(1,1);
		int opcion = -1;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println(jefeS.toString());
		
		do {
			int producto = Jefe.seleccionarproducto();
			int turno = Jefe.seleccionarTurno();
			jefeS.reservar_Pedido(Pedidos, producto, turno);
			Thread.sleep(1000);
			System.out.println("Presiona 0 si quiere salir del programa, o cualquier otro número si quiere realizar otra consulta. ");
			opcion = teclado.nextInt();
		}while(opcion !=0);
		System.exit(0);
	}
	public static void initPedidos(Pedido[] Pedidos) { //iniciamos vector Pedido a 100
			for(int n = 1; n <Pedidos.length+1; n++) {
				Pedidos[n-1] = new Pedido((short) n,(byte) 0); //cada Futuro pedido inicializando
			}
		}
}
