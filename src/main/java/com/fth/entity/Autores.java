package com.fth.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autores {

	private String id, nombre, apellidos, lugar_nac;
	private String fecha_nac;
	

}
