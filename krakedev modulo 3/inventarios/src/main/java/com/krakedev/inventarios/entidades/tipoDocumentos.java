package com.krakedev.inventarios.entidades;

public class tipoDocumentos {
	private String codigoTipoDocumento;
	private String descripcion;
	
	public tipoDocumentos(String codigoTipoDocumento, String descripcion) {
		super();
		this.codigoTipoDocumento = codigoTipoDocumento;
		this.descripcion = descripcion;
	}

	public tipoDocumentos() {
		
	}

	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "tipoDocumentos [codigoTipoDocumento=" + codigoTipoDocumento + ", descripcion=" + descripcion + "]";
	}
}
