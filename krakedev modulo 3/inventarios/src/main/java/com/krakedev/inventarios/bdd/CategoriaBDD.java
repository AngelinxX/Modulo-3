package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categorias;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class CategoriaBDD {
	public void crearCategorias(Categorias categoria) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"INSERT INTO categorias("
					+ "	nombre, categoria_padre)"
					+ "	VALUES (?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriapadre());
			
			ps.executeUpdate();

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
	public void actualizarCategorias(Categorias categoria) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
				ps = con.prepareStatement("UPDATE categorias"
						+ "	SET nombre=?, categoria_padre=?"
						+ "	WHERE codigo_cat=?");
				ps.setString(1, categoria.getNombre());
				ps.setInt(2, categoria.getCategoriapadre());
				ps.setInt(3,categoria.getCodigocat());

				ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
	public ArrayList<Categorias> recuperarCategorias() throws KrakeDevException {
		ArrayList<Categorias> categoria = new ArrayList<Categorias>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Categorias categorias = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select codigo_cat,nombre,categoria_padre from categorias;");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigocat = rs.getInt("codigo_cat");
				String nombre = rs.getString("nombre");
				int categoriapadre = rs.getInt("categoria_padre");
				categorias = new Categorias(codigocat,nombre,categoriapadre);
				categoria.add(categorias);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
		return categoria;
	}
}
