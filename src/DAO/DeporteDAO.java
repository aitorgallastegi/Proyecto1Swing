package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Deporte;
import olimpiadas.ConexionBD;

public class DeporteDAO {
	private ConexionBD conexion;

	public ArrayList<Object[]> read() throws SQLException{
    	ArrayList<Object[]> data = new ArrayList<>();
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("select nombre from Deporte");
		ResultSet rs = ps.executeQuery();
        if (rs.next()) {
		    Object [] fila = new Object[1];
		    for (int i=0;i<=0;i++) {
		    	fila[i]=rs.getObject(i+1);
		    }
		    data.add(fila);
		    
		    
        }
        
        rs.close();
		ps.close();
		conn.close();
        return data;

	}
	public void insert(Deporte deporte)throws SQLException {
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("insert into Deporte (id_deporte,nombre) values (" + deporte.getId() + ",'"+ deporte.getNombre() + "')");
		ps.executeUpdate();
		ps.close();
		conn.close();
			
		
	}

	public void delete(int id) throws SQLException{
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("delete from Deporte where id_deporte = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

		
	

	public void update(Deporte deporte, int id) throws SQLException{
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("UPDATE Deporte SET id_deporte=" + deporte.getId()+ ", nombre=" + "'" + deporte.getNombre() + "' WHERE id_deporte=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

	

}
