package com.fth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fth.entity.Alumnos;

public class Implalumnos implements Ialumnos {

	private Connection cx;

	// API SQL
	private Statement st = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	public Implalumnos() {
		cx = Conexion.Conectar();
	}

	@Override
	public Alumnos ObtenerAlumno(String CODIGO) throws Exception {

		Alumnos a = new Alumnos();

		try {
			String SQL = "SELECT * FROM ALUMNOS WHERE CODIGO = ?";
			ps = cx.prepareStatement(SQL);
			ps.setString(1, CODIGO);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setCodigo(rs.getString("CODIGO"));
				a.setNombres(rs.getString("NOMBRES"));
				a.setApellidos(rs.getString("APELLIDOS"));
				a.setTelefono(rs.getString("TELEFONO"));
				a.setEspecialidad(rs.getString("ESPECIALIDAD"));
				a.setFecha_nacimiento(rs.getString("FECHA_NACIMIENTO"));
			}
			rs.close();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	@Override
	public List<Alumnos> listarAlumnos() throws Exception {

		List<Alumnos> alumnos = new ArrayList<>();
		String SQL = "SELECT * FROM ALUMNOS";
		try {
			st = cx.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Alumnos al = new Alumnos();
				al.setCodigo(rs.getString("CODIGO"));
				al.setNombres(rs.getString("NOMBRES"));
				al.setApellidos(rs.getString("APELLIDOS"));
				al.setTelefono(rs.getString("TELEFONO"));
				al.setEspecialidad(rs.getString("ESPECIALIDAD"));
				al.setFecha_nacimiento(rs.getString("FECHA_NACIMIENTO"));
				alumnos.add(al);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (!rs.isClosed()) {
				rs.close();
				cx.close();
			}
		}
		return alumnos;
	}

}
