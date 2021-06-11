package org.CDU1;

public class Reserva {
	private Pedido mesa;
	private short hora;
	private String dia;
	private String cliente;
	private String realizacion_reserva;
	private String atencion;
	private Pedido pedido;
	
	
	public Reserva(Pedido pedido, short hora, String dia, String cliente, String realizacion_reserva,
			String personal_atencion) {
		super();
		this.pedido = pedido;
		this.hora = hora;
		this.dia = dia;
		this.cliente = cliente;
		this.realizacion_reserva = realizacion_reserva;
		atencion = personal_atencion; //nombre de usuario almacenado en el pedido
	}


	public Reserva(Pedido pedido, short hora, String dia, String cliente) {
		super();
		this.pedido = pedido;
		this.hora = hora;
		this.dia = dia;
		this.cliente = cliente;
	}


	@Override //clase abstracta
	public String toString() {
		return "Reserva [mesa=" + mesa.getIdPedido() + ", hora=" + hora + ", dia=" + dia + ", cliente=" + cliente + "]";
	}





}

