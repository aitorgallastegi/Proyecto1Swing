package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Olimpiada;
import olimpiadas.ConexionBD;


public class OlimpiadaDAO {
	private ConexionBD conexion;
    
	public ArrayList<Object[]> read() throws SQLException{
    	ArrayList<Object[]> data = new ArrayList<>();
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("select nombre,anio,temporada,ciudad from Olimpiada");
		ResultSet rs = ps.executeQuery();
        if (rs.next()) {
		    Object [] fila = new Object[4];
		    for (int i=0;i<=3;i++) {
		    	fila[i]=rs.getObject(i+1);
		    }
		    data.add(fila);	    
		    
        }        
        rs.close();
		ps.close();
		conn.close();
        return data;

	}                                      


    public void insert(Olimpiada olimpiada) throws SQLException{    
    	conexion = new ConexionBD();
    	Connection conn = conexion.getConexion();
	
    	PreparedStatement ps = conn.prepareStatement("insert into Olimpiada (id_olimpiada,nombre,anio,temporada,ciudad) values (" + olimpiada.getId() + ",'" + olimpiada.getNombre() + "',"+ olimpiada.getAnio()+",'"+olimpiada.getTemporada()+"','"+olimpiada.getCiudad()+"')");
    	ps.executeUpdate();
    	ps.close();
		conn.close();	
        
    }

    public void delete(int id) throws SQLException{
    	conexion = new ConexionBD();
    	Connection conn = conexion.getConexion();
    	PreparedStatement ps = conn.prepareStatement("delete from Olimpiada where id_Olimpiada = ?");  
    	ps.setInt(1, id);
    	ps.executeUpdate();
		ps.close();
		conn.close();
        
    
    
    }

    public void update(Olimpiada olimpiada,int id) throws SQLException{
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
		PreparedStatement ps = conn.prepareStatement("UPDATE Olimpiada SET id_olimpiada="+olimpiada.getId()+", nombre="+"'"+olimpiada.getNombre()+"',anio="+olimpiada.getAnio()+",temporada='"+olimpiada.getTemporada()+"',ciudad='"+olimpiada.getCiudad()+"' WHERE id_olimpiada=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
		conn.close();
    }

	
}
