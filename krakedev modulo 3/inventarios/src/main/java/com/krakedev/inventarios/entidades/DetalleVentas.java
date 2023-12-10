package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVentas {
	private int codigo;
	private Ventas cabecera;
	private Producto producto;
	private int cantidad;
	private BigDecimal precio;
	private BigDecimal subTotal;
	private BigDecimal subTotalConIva;
		
	public DetalleVentas() {
		super();
	}
	public DetalleVentas(int codigo, Ventas cabecera, Producto producto, int cantidad, BigDecimal precio,
			BigDecimal subTotal, BigDecimal subTotalConIva) {
		super();
		this.codigo = codigo;
		this.cabecera = cabecera;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.subTotal = subTotal;
		this.subTotalConIva = subTotalConIva;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Ventas getCabecera() {
		return cabecera;
	}
	public void setCabecera(Ventas cabecera) {
		this.cabecera = cabecera;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	public BigDecimal getSubTotalConIva() {
		return subTotalConIva;
	}
	public void setSubTotalConIva(BigDecimal subTotalConIva) {
		this.subTotalConIva = subTotalConIva;
	}
	
	@Override
	public String toString() {
		return "DetalleVentas [codigo=" + codigo + ", cabecera=" + cabecera + ", producto=" + producto + ", cantidad="
				+ cantidad + ", precio=" + precio + ", subTotal=" + subTotal + ", subTotalConIva=" + subTotalConIva
				+ "]";
	}
}
