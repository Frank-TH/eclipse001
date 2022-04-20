package com.fth.dao;

import java.sql.SQLException;
import java.util.List;

import com.fth.entity.Libros;

public interface Ilibros {
	
	public void agregarLibro(Libros l) throws SQLException;
	public void eliminarLibro(char isbn);
	public void actualizarLibro(Libros l);
	public List<Libros> listarLibro() throws Exception;
	public Libros obtenerLibro(String isbn) throws Exception;

}
