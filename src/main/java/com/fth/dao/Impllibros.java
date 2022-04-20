package com.fth.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fth.entity.Libros;

public class Impllibros implements Ilibros {

	private Connection cx;

	// Foreing KEYS
	private Implautores implautor;
	private Implalumnos implalumno;

	// API SQL
	private PreparedStatement ps = null;
	private Statement st = null;
	private ResultSet rs = null;

	// Constructor
	public Impllibros() {
		cx = Conexion.Conectar();
		implautor = new Implautores();
		implalumno = new Implalumnos();
	}

	// Metodos
	@Override
	public void agregarLibro(Libros l) throws SQLException {

		try {
			String SQL = "INSERT INTO LIBROS (ISBN,TITULO,EDITORIAL,PRECIO,CANTIDAD,ID_AUTOR,CODIGO_ALUMNO) VALUES (?,?,?,?,?,?,?)";

			ps = cx.prepareStatement(SQL);
			ps.setString(1, l.getIsbn());
			ps.setString(2, l.getTitulo());
			ps.setString(3, l.getEditorial());
			ps.setDouble(4, l.getPrecio());
			ps.setInt(5, l.getNumero());
			ps.setString(6, implautor.ObtenerAutor(l.getAutor().getId()).getId());
			ps.setString(7, implalumno.ObtenerAlumno(l.getAlumn().getCodigo()).getCodigo());
			ps.executeUpdate();
			ps.close();

			System.out.println("DATO INSERTADO");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cx.close();
		}
	}

	@Override
	public void eliminarLibro(char isbn) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarLibro(Libros l) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Libros> listarLibro() throws Exception {
		List<Libros> libros = new ArrayList<>();
		String SQL = "SELECT * FROM LIBROS";
		try {
			st = cx.createStatement();
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				Libros l = new Libros();
				l.setIsbn(rs.getString("ISBN"));
				l.setTitulo(rs.getString("TITULO"));
				l.setEditorial(rs.getString("EDITORIAL"));
				l.setPrecio(rs.getDouble("PRECIO"));
				l.setNumero(rs.getInt("CANTIDAD"));
				l.setAutor(implautor.ObtenerAutor(rs.getString("ID_AUTOR")));
				l.setAlumn(implalumno.ObtenerAlumno(rs.getString("CODIGO_ALUMNO")));
				libros.add(l);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (!rs.isClosed()) {
				rs.close();
				cx.close();
			}
		}

		return libros;
	}

	@Override
	public Libros obtenerLibro(String isbn) throws Exception {

		Libros l = new Libros();

		try {
			String SQL = "SELECT * FROM LIBROS WHERE ISBN = ?";
			ps = cx.prepareStatement(SQL);
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				l.setIsbn(rs.getString("ISBN"));
				l.setTitulo(rs.getString("TITULO"));
				l.setEditorial(rs.getString("EDITORIAL"));
				l.setPrecio(rs.getDouble("PRECIO"));
				l.setNumero(rs.getInt("CANTIDAD"));
				l.setAutor(implautor.ObtenerAutor(rs.getString("ID_AUTOR")));
				l.setAlumn(implalumno.ObtenerAlumno(rs.getString("CODIGO_ALUMNO")));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cx.close();
		}
		return l;

	}

}
