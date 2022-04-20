package com.fth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fth.entity.Autores;

public class Implautores implements Iautores {
	
	private Connection cx;
	
	public Implautores() {
		cx = Conexion.Conectar();
	}

	@Override
	public Autores ObtenerAutor(String ID) throws Exception {
		
		Autores a = new Autores();
		
		try {
			String SQL = "SELECT * FROM AUTORES WHERE ID = ?";
			PreparedStatement ps = cx.prepareStatement(SQL);
			ps.setString(1,ID);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				a.setId(rs.getString("ID"));
				a.setNombre(rs.getString("NOMBRE"));
				a.setApellidos(rs.getString("APELLIDOS"));
				a.setFecha_nac(rs.getString("FECHA_NAC"));
				a.setLugar_nac(rs.getString("LUGAR_NAC"));
			}
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return a;
	}

}
