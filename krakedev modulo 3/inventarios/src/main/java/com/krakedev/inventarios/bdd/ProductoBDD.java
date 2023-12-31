package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadDeMedida;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductoBDD {
	public ArrayList<Producto> buscarProducto(String subcadena) throws KrakeDevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_prod, prod.nombre as nombre_producto, "
					+ "prod.udm as nombre_udm, " + "udm.descripcion as descripcion_udm, "
					+ "cast(prod.precio_de_venta as decimal(6,2)), prod.tiene_iva, "
					+ "cast(prod.coste as decimal (5,4)), "
					+ "prod.categorias_cod, cat.nombre as nombre_categoria, prod.stock "
					+ "from producto prod, unidades_de_medida udm, categorias cat " + "where prod.udm = udm.codigo_udm "
					+ "and prod.categorias_cod =cat.codigo_cat " + "and upper(prod.nombre) like ?");
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigoProducto = rs.getInt("codigo_prod");
				String nombreProducto = rs.getString("nombre_producto");
				String nombreUnidadMedida = rs.getString("nombre_udm");
				String descripcionUnidadMedida = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_de_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int codigoCategoria = rs.getInt("categorias_cod");
				String nombreCategoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadDeMedida udm = new UnidadDeMedida();
				udm.setCodigoudm(nombreUnidadMedida);
				udm.setDescripcion(descripcionUnidadMedida);

				Categorias categoria = new Categorias();
				categoria.setCodigocat(codigoCategoria);
				categoria.setNombre(nombreCategoria);

				producto = new Producto();
				producto.setCodigoprod(codigoProducto);
				producto.setNombre(nombreProducto);
				producto.setUnidademedida(udm);
				producto.setPrecioventa(precioVenta);
				producto.setTieneiva(tieneIva);
				producto.setCoste(coste);
				producto.setCategoria(categoria);
				producto.setStock(stock);

				productos.add(producto);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
		return productos;
	}

	public void crearProducto(Producto producto) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"INSERT INTO producto(nombre, udm, precio_de_venta, tiene_iva, coste, categorias_cod, stock) "
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?)");

			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidademedida().getCodigoudm());
			ps.setBigDecimal(3,producto.getPrecioventa());
			ps.setBoolean(4, producto.isTieneiva());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigocat());
			ps.setInt(7, producto.getStock());
			
			ps.executeUpdate();

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
	public void actualizarProducto(Producto producto) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
				ps = con.prepareStatement("UPDATE producto"
						+ "	SET nombre=?, udm=?, precio_de_venta=?, tiene_iva=?, coste=?, categorias_cod=?"
						+ "	WHERE codigo_prod=?;");
				ps.setString(1, producto.getNombre());
				ps.setString(2, producto.getUnidademedida().getCodigoudm());
				ps.setBigDecimal(3,producto.getPrecioventa());
				ps.setBoolean(4, producto.isTieneiva());
				ps.setBigDecimal(5, producto.getCoste());
				ps.setInt(6, producto.getCategoria().getCodigocat());
				ps.setInt(7, producto.getCodigoprod());

				ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
	
	public ArrayList<Producto> buscarProductoCodigo(int subcadena) throws KrakeDevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select prod.codigo_prod, prod.nombre as nombre_producto, "
					+ "prod.udm as nombre_udm, " + "udm.descripcion as descripcion_udm, "
					+ "cast(prod.precio_de_venta as decimal(6,2)), prod.tiene_iva, "
					+ "cast(prod.coste as decimal (5,4)), "
					+ "prod.categorias_cod, cat.nombre as nombre_categoria, prod.stock "
					+ "from producto prod, unidades_de_medida udm, categorias cat " + "where codigo_prod = ? ");
			ps.setInt(1, subcadena);
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigoProducto = rs.getInt("codigo_prod");
				String nombreProducto = rs.getString("nombre_producto");
				String nombreUnidadMedida = rs.getString("nombre_udm");
				String descripcionUnidadMedida = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_de_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int codigoCategoria = rs.getInt("categorias_cod");
				String nombreCategoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");

				UnidadDeMedida udm = new UnidadDeMedida();
				udm.setCodigoudm(nombreUnidadMedida);
				udm.setDescripcion(descripcionUnidadMedida);

				Categorias categoria = new Categorias();
				categoria.setCodigocat(codigoCategoria);
				categoria.setNombre(nombreCategoria);

				producto = new Producto();
				producto.setCodigoprod(codigoProducto);
				producto.setNombre(nombreProducto);
				producto.setUnidademedida(udm);
				producto.setPrecioventa(precioVenta);
				producto.setTieneiva(tieneIva);
				producto.setCoste(coste);
				producto.setCategoria(categoria);
				producto.setStock(stock);

				productos.add(producto);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
		return productos;
	}
}
