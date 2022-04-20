package com.fth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static Connection cx;

	private Conexion() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cx = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "oracle", "oracle");
			System.out.println("Conexion Abierta");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Connection Conectar() {
		if (cx == null) {
			new Conexion();
		}
		return cx;
	}

	public static void Desconectar() {
		try {
			if (!cx.isClosed()) {
				cx.close();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Conexion Cerrada");
		}

	}

}
