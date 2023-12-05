package com.krakedev.inventarios.entidades;

public class CategoriaUDM {
	private String codigocudm;
	private String nombre;
	
	public CategoriaUDM() {
		super();
	}
	public CategoriaUDM(String codigocudm, String nombre) {
		super();
		this.codigocudm = codigocudm;
		this.nombre = nombre;
	}
	public String getCodigocudm() {
		return codigocudm;
	}
	public void setCodigocudm(String codigocudm) {
		this.codigocudm = codigocudm;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "CategoriaUDM [codigocudm=" + codigocudm + ", nombre=" + nombre + "]";
	}
}
