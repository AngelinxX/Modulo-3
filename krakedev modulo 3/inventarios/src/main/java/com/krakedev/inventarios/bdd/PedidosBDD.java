package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.entidades.Pedido;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidosBDD {
	public void insertarPedido(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;

		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido(proveedor,fecha,estado) " + "	VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");

			ps.executeUpdate();

			rsClave = ps.getGeneratedKeys();
			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallePedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallePedido.size(); i++) {
				det = detallePedido.get(i);
				psDet = con.prepareStatement("INSERT INTO detalle_pedido"
						+ "(cabecera_pedido, producto, cantidad_solicitada, subtotal, cantidad_recibida)"
						+ "VALUES (?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigoprod());
				psDet.setInt(3, det.getCantidadSolicitada());
				BigDecimal pv = det.getProducto().getPrecioventa();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subtotal);
				psDet.setInt(5, 0);

				psDet.executeUpdate();
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}

	public void recibirPedido(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psStock = null;
		
		Date fechaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaActual.getTime());

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update cabecera_pedido set estado = 'R' where numero = ?");
			ps.setInt(1, pedido.getNumero());

			ps.executeUpdate();

			ArrayList<DetallePedido> detallePedido = pedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallePedido.size(); i++) {
				det = detallePedido.get(i);
				psDet = con.prepareStatement("UPDATE detalle_pedido "
						+ "	SET subtotal=?, cantidad_recibida=? "
						+ "	WHERE codigo_detalle_pedido = ? and producto = ? ");
				psDet.setInt(2, det.getCantidadRecibida());
				BigDecimal pv = det.getProducto().getPrecioventa();
				BigDecimal cantidad = new BigDecimal(det.getCantidadRecibida());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(1, subtotal);
				psDet.setInt(3, det.getCodigo());
				psDet.setInt(4, det.getProducto().getCodigoprod());

				psDet.executeUpdate();
				
				psStock=con.prepareStatement("INSERT INTO historial_stock "
						+ "(fecha, referencia, producto, cantidad)	 "
						+ "VALUES (?, ?, ?, ?)");
				
				psStock.setTimestamp(1, fechaHoraActual);
				psStock.setString(2, "PEDIDO " + pedido.getNumero());
				psStock.setInt(3, det.getProducto().getCodigoprod());
				psStock.setInt(4, det.getCantidadRecibida());
				
				psStock.executeUpdate();
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
}
