package com.krakedev.inventarios.entidades;

public class UnidadDeMedida {
	private String codigoudm;
	private String descripcion;
	private CategoriaUDM categoriacudm;
	
	public UnidadDeMedida() {
		super();
	}
	public UnidadDeMedida(String codigoudm, String descripcion, CategoriaUDM categoriacudm) {
		super();
		this.codigoudm = codigoudm;
		this.descripcion = descripcion;
		this.categoriacudm = categoriacudm;
	}
	
	public String getCodigoudm() {
		return codigoudm;
	}
	public void setCodigoudm(String codigoudm) {
		this.codigoudm = codigoudm;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriaUDM getCategoriacudm() {
		return categoriacudm;
	}
	public void setCategoriacudm(CategoriaUDM categoriacudm) {
		this.categoriacudm = categoriacudm;
	}
	
	@Override
	public String toString() {
		return "UnidadDeMedida [codigoudm=" + codigoudm + ", descripcion=" + descripcion + ", categoriacudm="
				+ categoriacudm + "]";
	}
}
