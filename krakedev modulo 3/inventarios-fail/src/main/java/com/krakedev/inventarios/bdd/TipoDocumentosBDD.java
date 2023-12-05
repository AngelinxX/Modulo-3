package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.tipoDocumentos;
import com.krakedev.inventarios.excepciones.KrakeDevException;
import com.krakedev.inventarios.utils.ConexionBDD;

public class TipoDocumentosBDD {
	public ArrayList<tipoDocumentos> recuperarTiposDocumentos() throws KrakeDevException {
		ArrayList<tipoDocumentos> documentos = new ArrayList<tipoDocumentos>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		tipoDocumentos tipoDocumento = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select codigo_tipo_doc,descripcion from tipo_documento;");
			rs = ps.executeQuery();

			while (rs.next()) {
				String codigoTipoDocumento = rs.getString("codigo_tipo_doc");
				String descripcion = rs.getString("descripcion");
				tipoDocumento = new tipoDocumentos(codigoTipoDocumento, descripcion);
				documentos.add(tipoDocumento);
			}

		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar, detalle:" + e.getMessage());
		}
		return documentos;
	}
}
