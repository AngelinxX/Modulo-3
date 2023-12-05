package com.krakedev.inventarios.entidades;

public class EstadoPedido {
	private String codigoEstadoPedido;
	private String descripcion;
	
	public EstadoPedido() {
		super();
	}
	public EstadoPedido(String codigoEstadoPedido, String descripcion) {
		super();
		this.codigoEstadoPedido = codigoEstadoPedido;
		this.descripcion = descripcion;
	}
	public String getCodigoEstadoPedido() {
		return codigoEstadoPedido;
	}
	public void setCodigoEstadoPedido(String codigoEstadoPedido) {
		this.codigoEstadoPedido = codigoEstadoPedido;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "EstadoPedido [codigoEstadoPedido=" + codigoEstadoPedido + ", descripcion=" + descripcion + "]";
	}
}
