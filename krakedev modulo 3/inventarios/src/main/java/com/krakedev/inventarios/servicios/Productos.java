package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProductoBDD;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.excepciones.KrakeDevException;

@Path("productos")
public class Productos {
	@Path("buscar/{sub}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProducto(@PathParam("sub") String subcadena) {
		ProductoBDD prodBDD = new ProductoBDD();
		ArrayList<Producto> productos = null;
		try {
			productos = prodBDD.buscarProducto(subcadena);
			return Response.ok(productos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crearProducto(Producto producto) {
		ProductoBDD prodBDD=new ProductoBDD();
		try {
			prodBDD.crearProducto(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actProducto(Producto producto) {
		ProductoBDD prodBDD=new ProductoBDD();
		try {
			prodBDD.actualizarProducto(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	@Path("buscarporcodigo/{sub}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProductoPorCodigo(@PathParam("sub") String subcadena) {
		ProductoBDD prodBDD = new ProductoBDD();
		ArrayList<Producto> productos = null;
		try {
			int auxsubcadena = Integer.valueOf(subcadena);
			productos = prodBDD.buscarProductoCodigo(auxsubcadena);
			return Response.ok(productos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
