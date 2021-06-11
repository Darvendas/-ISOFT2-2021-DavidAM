package org.CDU2;

import java.time.LocalDate;

/**
 * Clase Mesa en el que iremos anadiendo los distintos pedidos que hagan los clientes.
 */
public class Pedido {
	private static final String [] estados = {"En Proceso","En horno","Listo para recoger","Cliente en tienda","Cancelado","No recibido","Recibido"};
	//Los estados son codificados como bytes, del 1 al 8, en el orden que aparecen, tenemos en cuenta que tenemos dos huecos sin usar 
	private String _idPedido;
	private Order[] _pedidos; //Productos de este usuario
	private int _tiempo;
	private byte _estado;
	private LocalDate _time_beginning; //Hora y fecha del pedido

	public Pedido(String _idPedido) {
		this.setIdMesa(_idPedido);
		try {
			this.setEstado((byte) 1);
		} catch (EstadoNoValidoException e) {}
	}

	public Order[] getPedidos() {
		return this._pedidos;
	}
	public void setPedidos(Order[] aPedidos) {
		this._pedidos = aPedidos;
	}

	public String getIdPedido() {
		return this._idPedido;
	}
	public void setIdMesa(String aIdMesa) {
		this._idPedido = aIdMesa;
	}

	public int getTiempo() {
		return this._tiempo;
	}
	public void setTiempo(int aTiempo) {
		this._tiempo = aTiempo;
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
				throw new EstadoNoValidoException(); //Una mesa puede pasar de estar reservada a libre, pero solamente eso
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
}