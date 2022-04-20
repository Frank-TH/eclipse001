package com.fth.dao;

import java.util.List;

import com.fth.entity.Alumnos;

public interface Ialumnos {
	
	public Alumnos ObtenerAlumno(String CODIGO) throws Exception;
	
	public List<Alumnos> listarAlumnos() throws Exception;

}
