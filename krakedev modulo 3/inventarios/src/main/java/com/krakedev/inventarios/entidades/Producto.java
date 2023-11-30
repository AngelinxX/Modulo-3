package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class Producto {
	private int codigoprod;
	private String nombre;
	private UnidadDeMedida unidademedida;
	private BigDecimal precioventa;
	private boolean tieneiva;
	private BigDecimal coste;
	private Categorias categoria;
	private int stock;
	
	public Producto() {
		super();
	}
	public Producto(int codigoprod, String nombre, UnidadDeMedida unidademedida, BigDecimal precioventa,
			boolean tieneiva, BigDecimal coste, Categorias categoria, int stock) {
		super();
		this.codigoprod = codigoprod;
		this.nombre = nombre;
		this.unidademedida = unidademedida;
		this.precioventa = precioventa;
		this.tieneiva = tieneiva;
		this.coste = coste;
		this.categoria = categoria;
		this.stock = stock;
	}
	public int getCodigoprod() {
		return codigoprod;
	}
	public void setCodigoprod(int codigoprod) {
		this.codigoprod = codigoprod;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public UnidadDeMedida getUnidademedida() {
		return unidademedida;
	}
	public void setUnidademedida(UnidadDeMedida unidademedida) {
		this.unidademedida = unidademedida;
	}
	public BigDecimal getPrecioventa() {
		return precioventa;
	}
	public void setPrecioventa(BigDecimal precioventa) {
		this.precioventa = precioventa;
	}
	public boolean isTieneiva() {
		return tieneiva;
	}
	public void setTieneiva(boolean tieneiva) {
		this.tieneiva = tieneiva;
	}
	public BigDecimal getCoste() {
		return coste;
	}
	public void setCoste(BigDecimal coste) {
		this.coste = coste;
	}
	public Categorias getCategoria() {
		return categoria;
	}
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	@Override
	public String toString() {
		return "Producto [codigoprod=" + codigoprod + ", nombre=" + nombre + ", unidademedida=" + unidademedida
				+ ", precioventa=" + precioventa + ", tieneiva=" + tieneiva + ", coste=" + coste + ", categoria="
				+ categoria + ", stock=" + stock + "]";
	}
}
