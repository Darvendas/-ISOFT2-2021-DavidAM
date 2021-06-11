package org.CDU2;

public class HiloEmpleado extends Thread{
	private String Pedido;
	private int horas;
	private int horasCumulativos = 0;

	public HiloEmpleado( String Pedido, int horas) {
		this.Pedido = Pedido;
		this.horas = horas;
	}

	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(horas * 168);
				horasCumulativos += horas;
				System.out.println(" --- El pedido " + Pedido + " lleva sin ser recogido "
						+ Integer.toString(horasCumulativos) + " horas.");
			}
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

	public String getPedido() {
		return Pedido;
	}

	public int gethoras() {
		return horas;
	}

	public int gethorasCumulativos() {
		return horasCumulativos;
	}

	public void setPedido(String Pedido) {
		this.Pedido = Pedido;
	}

	public void sethoras(int horas) {
		this.horas = horas;
	}

	public void sethorasCumulativos(int horasCumulativos) {
		this.horasCumulativos = horasCumulativos;
	}

}
