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

import com.krakedev.inventarios.entidades.DetalleVentas;
import com.krakedev.inventarios.entidades.Ventas;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class VentasBDD {
	public void insertarVentas(Ventas ventas) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psAct = null;
		PreparedStatement psStock = null;
		ResultSet rsClave = null;
		int codigoCabecera = 0;

		Date fechaActual = new Date();
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());

		Date fechaVentaActual = new Date();
		Timestamp fechaHoraActual = new Timestamp(fechaVentaActual.getTime());

		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"INSERT INTO cabecera_ventas(" + " fecha, total_sin_iva, iva, total)" + "	VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setDate(1, fechaSQL);
			ps.setBigDecimal(2, new BigDecimal(0));
			ps.setBigDecimal(3, new BigDecimal(0));
			ps.setBigDecimal(4, new BigDecimal(0));

			ps.executeUpdate();
			
			rsClave = ps.getGeneratedKeys();
			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			BigDecimal totalSinIva = new BigDecimal(0);
			BigDecimal total = new BigDecimal(0);
			BigDecimal iva = new BigDecimal(0);
			BigDecimal subtotal = new BigDecimal(0);
			
			ArrayList<DetalleVentas> detalleVentas = ventas.getDetalles();
			DetalleVentas det = null;
			for (int i = 0; i < detalleVentas.size(); i++) {
				det = detalleVentas.get(i);
				psDet = con.prepareStatement("INSERT INTO detalle_ventas("
						+ "	cabecera_ventas, producto, cantidad, precio, subtotal, subtotal_con_iva)"
						+ "	VALUES (?, ?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigoprod());
				psDet.setInt(3, det.getCantidad());
				psDet.setBigDecimal(4, det.getProducto().getPrecioventa());
				BigDecimal pv = det.getProducto().getPrecioventa();
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				subtotal = pv.multiply(cantidad);
				totalSinIva = subtotal.add(subtotal);
				psDet.setBigDecimal(5, subtotal);
				
				if (det.getProducto().isTieneiva() == true) {
					BigDecimal subtotalconiva = subtotal.multiply(new BigDecimal(1.12));
					psDet.setBigDecimal(6, subtotalconiva);
					total = total.add(subtotalconiva);
				} else {
					psDet.setBigDecimal(6, subtotal);
					total = total.add(subtotal);
				}
				psDet.executeUpdate();
				
			}
			psAct = con.prepareStatement(
					"UPDATE cabecera_ventas" + " SET total_sin_iva=?, iva=?, total=? where codigo_cabecera_ventas = ?");
			
			psAct.setBigDecimal(1, totalSinIva);
			iva = total.subtract(totalSinIva);
			psAct.setBigDecimal(2, iva);
			psAct.setBigDecimal(3, total);
			psAct.setInt(4, codigoCabecera);

			psAct.executeUpdate();
			
			
			psStock = con.prepareStatement("INSERT INTO historial_stock "
					+ "(fecha, referencia, producto, cantidad)	 " + "VALUES (?, ?, ?, ?)");

			psStock.setTimestamp(1, fechaHoraActual);
			psStock.setString(2, "VENTA " + codigoCabecera);
			psStock.setInt(3, det.getProducto().getCodigoprod());
			psStock.setInt(4, det.getCantidad());

			psStock.executeUpdate();;

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
	}
}
