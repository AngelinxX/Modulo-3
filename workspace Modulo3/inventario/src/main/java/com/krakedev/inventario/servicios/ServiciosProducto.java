package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;

@Path("productos")
public class ServiciosProducto {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insertar(Producto producto) {
		System.out.println(">>>>>>>" + producto);
	}
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("Actualizando cliente>>>>>>>"+producto);
	}
	@Path("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> listaProductos = new ArrayList<Producto>();

        Producto producto1 = new Producto("001","Papel bond",new Categoria(1,"oficina"),19.99,12);
        Producto producto2 = new Producto("002","Coca Cola",new Categoria(2,"Gaseosa"),9.99,25);
        Producto producto3 = new Producto("003","Chocolate",new Categoria(3,"Golosina"),1.99,50);
        
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        listaProductos.add(producto3);

        return listaProductos;
	}
}
