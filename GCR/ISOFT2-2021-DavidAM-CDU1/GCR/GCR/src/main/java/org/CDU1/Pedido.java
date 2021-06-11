package org.CDU1;

import java.time.chrono.ChronoLocalDateTime;


import java.time.LocalDate;


public class Pedido {
	private static final String [] estados = {"En Proceso","En horno","Listo para recoger","Cliente en tienda","Cancelado","No recibido","Recibido"};
	//Los estados son codificados como bytes, del 1 al 8, en el orden que aparecen
	private short _idPedido;
	private int _tiempo_prefijado = 168; //las horas que tiene una semana (lo que dura un pedido para ser atendido), el tiempo en el programa se calculara en segundos aunque en el enunciado son horas
	private byte _estado;
	private LocalDate _time_beginning; //Hora / fecha en la que una Pedido empieza 
	

	public Pedido(short _idPedido) {
		this.setIdPedido(_idPedido);
		try {
			this.setEstado((byte) 1);
		} catch (EstadoNoValidoException e) {}
	}
	public Pedido(short _idPedido, byte _estado) {
		super();
		this._idPedido = _idPedido;
		this._estado = _estado;
	}
	/*
	 * public Order[] getPedidos() { return this._pedidos; } public void
	 * setPedidos(Order[] aPedidos) { this._pedidos = aPedidos; }
	 */

	public short getIdPedido() {
		return this._idPedido;
	}
	public void setIdPedido(short aIdPedido) {
		this._idPedido = aIdPedido;
	}

	public int getTiempo_prefijado() {
		return this._tiempo_prefijado;
	}
	public void setTiempo_prefijado(int aTiempo_prefijado) {
		this._tiempo_prefijado = aTiempo_prefijado;
	}

	public String getEstado() {
		return estados[this._estado-1];
	}
	public byte getEstadoByte() {
		return this._estado;
	}
	public void setEstado(byte aEstado) throws EstadoNoValidoException{
		if(this._estado == 0 || aEstado > this._estado || (this._estado == 9 && aEstado == 1)) {
			this._estado = aEstado;
		}else {
			if(this._estado == 2) {
				this._estado = aEstado;
			}else {
				throw new EstadoNoValidoException(); //Una Pedido puede pasar de En proceso a cualquier otro estado, pero tiene que empezar por este estado
			}
		}
	}

	public LocalDate getTime_beginning() {
		return this._time_beginning;
	}
	public void setTime_beginning(LocalDate aTime_beginning) {
		this._time_beginning = aTime_beginning;
	}

	public String[] getEstados() {
		return estados;
	}
	
	public double calcularPrecio() {
	 //Se desarroya en otro apartado, es un apartado teorico
		throw new UnsupportedOperationException();
	}
}