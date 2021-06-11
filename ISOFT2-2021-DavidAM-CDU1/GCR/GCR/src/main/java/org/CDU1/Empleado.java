package org.CDU1;

public class Empleado extends Personal {
//ubicacion
	private String horarioTrabajo;
	private byte local;
	
	public Empleado(String horarioTrabajo, byte local) {
		this.horarioTrabajo = horarioTrabajo;
		this.local = local;
	}

	public String getHorarioTrabajo() {
		return horarioTrabajo;
	}

	public byte getlocal() {
		return local;
	}

	public void setHorarioTrabajo(String horarioTrabajo) {
		this.horarioTrabajo = horarioTrabajo;
	}

	public void setlocal(byte local) {
		this.local = local;
	}
}
