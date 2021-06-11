package org.CDU1;

public class Personal {

	private String nombre;
	private String DNI;
	private boolean trabajando;
	private String telefono;

	public Personal(String nombre, String dNI, boolean trabajando, String telefono) {
		this.nombre = nombre;
		DNI = dNI;
		this.trabajando = trabajando;
		this.telefono = telefono;
	}
	
	public Personal() {}

	
	public Reserva[] getReserva() {
		// TODO - implement Personal.getReserva
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reserva
	 */
	public void setReserva(Reserva[] reserva) {
		// TODO - implement Personal.setReserva
		throw new UnsupportedOperationException();
	}

}
