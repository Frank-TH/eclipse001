package com.fth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alumnos {
	
	private String codigo, nombres, apellidos, telefono, especialidad;
	private String fecha_nacimiento;


}
