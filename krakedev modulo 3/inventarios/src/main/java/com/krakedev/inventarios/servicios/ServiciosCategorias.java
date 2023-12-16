package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.CategoriaBDD;
import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("categorias")
public class ServiciosCategorias {
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearCategoria(Categorias categorias) {
		CategoriaBDD categoriaBDD=new CategoriaBDD();
		try {
			categoriaBDD.crearCategorias(categorias);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actCategoria(Categorias categoria) {
		CategoriaBDD categoriaBDD=new CategoriaBDD();
		try {
			categoriaBDD.actualizarCategorias(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperarCategoria(){
		CategoriaBDD categoriaBDD=new CategoriaBDD();
		ArrayList<Categorias> categoria = null;
		try {
			categoria = categoriaBDD.recuperarCategorias();
			return Response.ok(categoria).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}	
	}
}
