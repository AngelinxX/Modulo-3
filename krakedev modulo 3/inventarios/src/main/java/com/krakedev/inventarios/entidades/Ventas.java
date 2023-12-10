package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;

public class Ventas {
	private int codigo;
	private Date fecha;
	private BigDecimal totalSinIva;
	private BigDecimal iva;
	private BigDecimal total;
	
	private ArrayList<DetalleVentas> detalles;

	public Ventas() {
		super();
	}

	public Ventas(int codigo, Date fecha, BigDecimal totalSinIva, BigDecimal iva, BigDecimal total) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.totalSinIva = totalSinIva;
		this.iva = iva;
		this.total = total;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotalSinIva() {
		return totalSinIva;
	}

	public void setTotalSinIva(BigDecimal totalSinIva) {
		this.totalSinIva = totalSinIva;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ArrayList<DetalleVentas> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleVentas> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Ventas [codigo=" + codigo + ", fecha=" + fecha + ", totalSinIva=" + totalSinIva + ", iva=" + iva
				+ ", total=" + total + ", detalles=" + detalles + "]";
	}
	
}