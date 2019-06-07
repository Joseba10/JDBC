package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaBorrado {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/pruebas";
		String user= "root";
		String password= "root";
		
		
		Class.forName(driver); //Carga el driver
		Connection conexion= DriverManager.getConnection(url,user,password); //Conexion con los requerimientos
		Statement stmt= conexion.createStatement(); //Crea una sentencia sql
		
		//Sentencia SQL
		String sentenciasql= "Delete from alumno where nombre= 'Maria'";
		System.out.println(sentenciasql);
		//Ejecuta la sentencia
		stmt.executeUpdate(sentenciasql); 
		
		//Cerrar llamada
		
		stmt.close();
		
		//Cerrar conexion
		conexion.close();
		
	
		
	}

}
