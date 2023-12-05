package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			if(rsClave.next()) {
				codigoCabecera= rsClave.getInt(1);
			}
			
			ArrayList<DetallePedido> detallePedido=pedido.getDetalles();
			DetallePedido det;
			for (int i=0;i<detallePedido.size();i++) {
				det = detallePedido.get(i);
				psDet=con.prepareStatement("INSERT INTO detalle_pedido"
						+ "(cabecera_pedido, producto, cantidad_solicitada, subtotal, cantidad_recibida)"
						+ "VALUES (?, ?, ?, ?, ?)" );
				psDet.setInt(1,codigoCabecera);
				psDet.setInt(2,det.getProducto().getCodigoprod());
				psDet.setInt(3,det.getCantidadSolicitada());
				BigDecimal pv = det.getProducto().getPrecioventa();
				BigDecimal cantidad = new BigDecimal (det.getCantidadSolicitada());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subtotal);
				psDet.setInt(5,0);
				
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

}
