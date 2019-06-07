package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaConsulta {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		

		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/pruebas";
		String user= "root";
		String password= "root";
		
		
		Class.forName(driver); //Carga el driver
		Connection conexion= DriverManager.getConnection(url,user,password); //Conexion con los requerimientos
		Statement stmt= conexion.createStatement(); //Crea una sentencia sql
		
		//Sentencia SQL
		String sentenciasql= "Select id,nombre,apellido,edad from alumno";
		System.out.println(sentenciasql);
		ResultSet rs= stmt.executeQuery(sentenciasql);
		boolean hayMas=rs.next();
		int id = 0;
		String nombre = null;
		String apellido = null;
		int edad = 0;
		
		while(hayMas) {
			
			id= rs.getInt(1);
			nombre=rs.getString(2);
			apellido= rs.getString(3);
			edad=rs.getInt(4);
			System.out.println("El id es " + id+" Nombre "+nombre + " Apellido " + apellido + " Edad "  + edad);
			hayMas= rs.next();
		}
		

		
		//Ejecuta la sentencia
		 rs.close();
		 
		 //Cerrar llamada
		
		stmt.close();
		
		//Cerrar conexion
		conexion.close();
		
	
		
	}

}
