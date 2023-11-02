package com.backend.app.DepartamentoAbanicos.models;

public class Departamento {

	private Abanico fan;
	
	private Integer cantidad;
	
	public Departamento() {
		
	}

	public Departamento(Abanico fan, Integer cantidad) {
		super();
		this.fan = fan;
		this.cantidad = cantidad;
	}

	public Abanico getFan() {
		return fan;
	}

	public void setFan(Abanico fan) {
		this.fan = fan;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}
