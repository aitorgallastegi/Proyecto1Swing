package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.Deportista;
import olimpiadas.ConexionBD;

public class DeportistaDAO {
	private ConexionBD conexion;

    public ArrayList<Object[]> read() throws SQLException{
    	ArrayList<Object[]> data = new ArrayList<>();
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
        PreparedStatement ps = conn.prepareStatement("select nombre,sexo,peso,altura from Deportista ");//where id_deportista = ?
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
    public void insert(Deportista deportista) throws SQLException {
    	conexion = new ConexionBD();
    	Connection conn = conexion.getConexion();
    	PreparedStatement ps = conn.prepareStatement("insert into Deportista (id_deportista,nombre,sexo,peso,altura) values (" + deportista.getId() + ",'" + deportista.getNombre() + "','"+ deportista.getSexo()+"',"+deportista.getPeso()+","+deportista.getAltura()+")");
    	ps.executeUpdate();
    	ps.close();
		conn.close();
    }
    
        
    public void delete(int id) throws SQLException{
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
    	PreparedStatement ps = conn.prepareStatement("delete from Deportista where id_deportista = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
		ps.close();
		conn.close();
		
    }
    
    
    public void update(Deportista deportista,int id)throws SQLException {
    	conexion = new ConexionBD();
		Connection conn = conexion.getConexion();
    	PreparedStatement ps = conn.prepareStatement("UPDATE Deportista SET id_deportista="+deportista.getId()+", nombre="+"'"+deportista.getNombre()+"',sexo="+"'"+deportista.getSexo()+"',peso="+deportista.getPeso()+",altura="+deportista.getAltura()+" WHERE id_deportista=?");
        ps.setInt(1, id);
        ps.executeUpdate();
		ps.close();
		conn.close();
        
    }

}
