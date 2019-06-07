package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PruebaInsertarPreparedStatement {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/pruebas";
		String user = "root";
		String password = "admin";
		// Carga driver
		Class.forName(driver);
		// Hace conexión
		Connection conexion = DriverManager.getConnection(url, user, password);
		// Ejecuta sentencia SQL
		String sentenciaSql = "insert into alumno (id,nombre,apellido,edad) values (?,?,?,?)";
		System.out.println(sentenciaSql);
		// Crea lanzador sentencias SQL preparadas
		PreparedStatement pStmt = conexion.prepareStatement(sentenciaSql);
		pStmt.setInt(1, 21);
		pStmt.setString(2, "Koldo");
		pStmt.setString(3, "Foncea");
		pStmt.setInt(4, 24);		
		//Ejecuta
		pStmt.executeUpdate();
		// Cerrar lanzador sentencias SQL
		pStmt.close();
		// Cerrar conexión
		conexion.close();

	}

}
