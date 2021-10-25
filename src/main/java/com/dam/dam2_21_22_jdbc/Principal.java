package com.dam.dam2_21_22_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Registrar el driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String bd = "jdbc";
		
		//Obtención de la conexión
		//Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sakila", "root", "1234.Abcd");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/" + bd, "root", "1234.Abcd");

		//Generación del Statement y ejecución de la Query
		Statement sentencia = conexion.createStatement();
		//ResultSet resultados = sentencia.executeQuery("SELECT title FROM film");
		ResultSet resultados = sentencia.executeQuery("SELECT nombre,descripcion FROM departamentos");
		
		while (resultados.next()) {
			//System.out.println(resultados.getString(1));
			System.out.println("Nombre: " + resultados.getString(1) + " -> " + resultados.getString(2));
		}
		
		//Actualización
		int numAct = sentencia.executeUpdate("UPDATE departamentos SET descripcion='Pepito' WHERE codigo=2000");
		if (numAct == 1) {
			System.out.println("Se ha actualizado el registro");
		}
		
		//Borrado
		int numBorr = sentencia.executeUpdate("DELETE FROM departamentos WHERE codigo=4000");
		if (numBorr == 1) {
			System.out.println("Se ha borrado el registro");
		}
		
		
		resultados.close();
		sentencia.close();
		conexion.close();
	}

}
