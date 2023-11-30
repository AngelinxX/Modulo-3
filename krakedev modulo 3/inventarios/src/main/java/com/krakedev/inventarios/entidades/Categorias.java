package com.krakedev.inventarios.entidades;

public class Categorias {
	private int codigocat;
	private String nombre;
	private Categorias categoriapadre;
	
	public Categorias() {
		super();
	}
	public Categorias(int codigocat, String nombre, Categorias categoriapadre) {
		super();
		this.codigocat = codigocat;
		this.nombre = nombre;
		this.categoriapadre = categoriapadre;
	}
	public int getCodigocat() {
		return codigocat;
	}
	public void setCodigocat(int codigocat) {
		this.codigocat = codigocat;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categorias getCategoriapadre() {
		return categoriapadre;
	}
	public void setCategoriapadre(Categorias categoriapadre) {
		this.categoriapadre = categoriapadre;
	}
	@Override
	public String toString() {
		return "Categorias [codigocat=" + codigocat + ", nombre=" + nombre + ", categoriapadre=" + categoriapadre + "]";
	}
}
