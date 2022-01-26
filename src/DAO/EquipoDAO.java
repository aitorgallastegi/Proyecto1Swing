package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Equipo;
import olimpiadas.ConexionBD;

public class EquipoDAO {
	private ConexionBD conexion;

	public ArrayList<Object[]> read() throws SQLException{
    	ArrayList<Object[]> data = new ArrayList<>();
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("select nombre,iniciales from Equipo");
		ResultSet rs = ps.executeQuery();
        if (rs.next()) {
		    Object [] fila = new Object[2];
		    for (int i=0;i<=1;i++) {
		    	fila[i]=rs.getObject(i+1);
		    }
		    data.add(fila);
		    
		    
        }
        
        rs.close();
		ps.close();
		conn.close();
        return data;

	}

	
	public void insert(Equipo equipo) throws SQLException {
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("insert into Equipo (id_equipo,nombre,iniciales) values ("
				+ equipo.getId() + ",'" + equipo.getNombre() + "','" + equipo.getIniciales() + "')");
		ps.executeUpdate();
		ps.close();
		conn.close();

	}

	public void delete(int id) throws SQLException {
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("delete from Equipo where id_equipo = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();

	}

	public void update(Equipo equipo, int id) throws SQLException {
		conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("UPDATE Equipo SET id_equipo=" + equipo.getId() + ", nombre=" + "'"
				+ equipo.getNombre() + "',iniciales=" + "'" + equipo.getIniciales() + "' WHERE id_equipo=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}

}
