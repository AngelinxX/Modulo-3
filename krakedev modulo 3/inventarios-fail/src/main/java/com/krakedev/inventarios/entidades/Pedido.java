package com.krakedev.inventarios.entidades;

import java.sql.Date;

public class Pedido {
	private int numero;
	private Proveedor proveedor;
	private Date fecha;
	private EstadoPedido estado;
	
	public Pedido() {
		super();
	}
	public Pedido(int numero, Proveedor proveedor, Date fecha, EstadoPedido estado) {
		super();
		this.numero = numero;
		this.proveedor = proveedor;
		this.fecha = fecha;
		this.estado = estado;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public EstadoPedido getEstado() {
		return estado;
	}
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "Pedido [numero=" + numero + ", proveedor=" + proveedor + ", fecha=" + fecha + ", estado=" + estado
				+ "]";
	}
}
