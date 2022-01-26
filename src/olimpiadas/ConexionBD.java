package olimpiadas;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private Connection conexion;
	
	public ConexionBD() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/olimpiadas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    String username = "root";
	    String password = "";
	    conexion = DriverManager.getConnection(url, username, password);
	    conexion.setAutoCommit(true);
	}

	public Connection getConexion() {
		return conexion;
	}
	
}