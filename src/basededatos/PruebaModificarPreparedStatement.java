package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class PruebaModificarPreparedStatement {

	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/pruebas";
		String user = "root";
		String password = "root";
		// Carga driver
		Class.forName(driver);
		// Hace conexión
		Connection conexion = DriverManager.getConnection(url, user, password);
		// Ejecuta sentencia SQL
		String sentenciaSql = "update alumno set nombre=? where id=?";
		System.out.println(sentenciaSql);
		// Crea lanzador sentencias SQL preparadas
		PreparedStatement pStmt = conexion.prepareStatement(sentenciaSql);
		pStmt.setString(1, "Maria");
		pStmt.setInt(2, 3);
		// Ejecuta
		pStmt.executeUpdate();
		// Cerrar lanzador sentencias SQL
		pStmt.close();
		// Cerrar conexión
		conexion.close();

	}

}
