package com.fth;

import com.fth.dao.Conexion;
import com.fth.dao.Ialumnos;
import com.fth.dao.Ilibros;
import com.fth.dao.Implalumnos;
import com.fth.dao.Impllibros;

public class App {

	public static void main(String[] args) throws Exception {

		Ilibros il = new Impllibros();
		Ialumnos ial = new Implalumnos();
		// Obtener Libro
		/*
		 * Libros l = il.obtenerLibro("0011223344551"); System.out.println(l.getIsbn() +
		 * "\t" + l.getTitulo()+"\t"+l.getPrecio()+"\t"+l.getAutor().getApellidos());
		 */

		// Listar libros
		/*
		 * il.listarLibro().forEach( l -> System.out.println(l.getIsbn() + "\t" +
		 * l.getAlumn().getCodigo() + "\t" + l.getAutor().getId()));
		 */
		// Obtener Alumno
		/*
		 * Alumnos al = ial.ObtenerAlumno("0011223344");
		 * System.out.println(al.getCodigo() + "\t" + al.getNombres());
		 */
		// listar alumnos
		/*
		 * ial.listarAlumnos().forEach(al -> System.out.println(al.getCodigo()));
		 */
		// Prueba
		/*
		 * List<String> codigosAl = ial.listarAlumnos().stream().map(al ->
		 * al.getCodigo()).collect(Collectors.toList());
		 * codigosAl.forEach(System.out::println);
		 */

		// Agregar Libro
		/*
		 * Autores au = new Autores(); au.setId("0004");
		 * 
		 * Alumnos al = new Alumnos(); al.setCodigo("0011223345");
		 * 
		 * Libros l = new
		 * Libros("0011223344554","Poemas","Artes Gráficas",55.8,18,au,al);
		 * il.agregarLibro(l);
		 */

		Conexion.Desconectar();
	}
}
