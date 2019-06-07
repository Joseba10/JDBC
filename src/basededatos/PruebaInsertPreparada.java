package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PruebaInsertPreparada {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String driver= "com.mysql.jdbc.Driver";
		String url="jdbc:mysql://localhost/pruebas";
		String user= "root";
		String password= "root";
		
		
		Class.forName(driver); //Carga el driver
		Connection conexion= DriverManager.getConnection(url,user,password); //Conexion con los requerimientos
		
		
		//Sentencia SQL
		String sentenciasql= "Insert into alumno (id,nombre,apellido,edad) values (?,?,?,?)";
		PreparedStatement pstmt= conexion.prepareStatement(sentenciasql); //Crea una sentencia sql
		
		pstmt.setInt(1, 6);
		pstmt.setString(2, "Koldo");
		pstmt.setString(3, "Benitez");
		pstmt.setInt(4, 16);

		System.out.println(sentenciasql);
		//Ejecuta la sentencia
		pstmt.executeUpdate(); 
		
		//Cerrar llamada
		
		pstmt.close();
		
		//Cerrar conexion
		conexion.close();
		
	
		
	}


	}


