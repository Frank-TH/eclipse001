package com.fth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libros {

	private String isbn;
	private String titulo;
	private String editorial;
	private double precio;
	private int numero;
	
	//Foreign key
	private Autores autor;
	private Alumnos alumn;

}
