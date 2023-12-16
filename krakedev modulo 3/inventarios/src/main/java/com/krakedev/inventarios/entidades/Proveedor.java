package com.krakedev.inventarios.entidades;

public class Proveedor {
	private String identificador;
	private tipoDocumentos tipoDocumentos;
	private String nombre;
	private int telefono;
	private String correo;
	private String direccion;
	
	public Proveedor(String identificador) {
		super();
		this.identificador = identificador;
	}
	public Proveedor() {
		super();
	}
	public Proveedor(String identificador, com.krakedev.inventarios.entidades.tipoDocumentos tipoDocumentos,
			String nombre, int telefono, String correo, String direccion) {
		super();
		this.identificador = identificador;
		this.tipoDocumentos = tipoDocumentos;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.direccion = direccion;
	}
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public tipoDocumentos getTipoDocumentos() {
		return tipoDocumentos;
	}
	public void setTipoDocumentos(tipoDocumentos tipoDocumentos) {
		this.tipoDocumentos = tipoDocumentos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Proveedor [identificador=" + identificador + ", tipoDocumentos=" + tipoDocumentos + ", nombre=" + nombre
				+ ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + "]";
	}
	
	
}