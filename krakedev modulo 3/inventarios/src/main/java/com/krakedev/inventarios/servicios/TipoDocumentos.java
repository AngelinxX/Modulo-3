package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentosBDD;
import com.krakedev.inventarios.entidades.tipoDocumentos;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("tiposdocumentos")
public class TipoDocumentos {
	
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarTipoDocumento(){
		TipoDocumentosBDD docBDD=new TipoDocumentosBDD();
		ArrayList<tipoDocumentos> documentos = null;
		try {
			documentos = docBDD.recuperarTiposDocumentos();
			return Response.ok(documentos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}	
	}
}
