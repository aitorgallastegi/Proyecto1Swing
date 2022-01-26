package DAO;

import java.sql.SQLException;

import model.*;

public class Manager {
    public static void main(String[] args) throws SQLException {
        DeporteDAO deporte = new DeporteDAO(); //DONE
        
        // obtener el deporte con ID
        //Deporte p = deporte.read(2);
        //System.out.println(p);
        
        //Deporte a = new Deporte(5,"100m");
        //deporte.insert(a);
        
        //deporte.delete(5);
        
        //Deporte upd = new Deporte(5,"Skate");
        //deporte.update(upd, 111);
        
      DeportistaDAO deportista = new DeportistaDAO();//DONE
      
      
      //Deportista r = deportista.read();
      //System.out.println(r);
      
      //Deportista i = new Deportista(3,"Aitor","M",80,180);
      //deportista.insert(i);
      
      //deportista.delete(3);
      
      //Deportista u = new Deportista(3,"Yefri","F",90,190);
      //deportista.update(u, 3);
      
      EquipoDAO equipo = new EquipoDAO();//DONE
      
      //Equipo r = equipo.read(2);
      //System.out.println(r);
      
      //Equipo i = new Equipo(7,"Portugal","POR");
      //equipo.insert(i);
      
      //equipo.delete(5);
      
      //Equipo u = new Equipo(5,"fdfdfdfd","FyA");
      //equipo.update(u, 5);
      
      OlimpiadaDAO olimpiada = new OlimpiadaDAO();//DONE
      
      //Olimpiada r = olimpiada.read(2);
      //System.out.println(r);
      
      //Olimpiada i = new Olimpiada(4,"a",1,"Summer","c");
      //olimpiada.insert(i);
      
      //olimpiada.delete(4);
      
      //Olimpiada u = new Olimpiada(4,"x",99,"Summer","espana");
      //olimpiada.update(u,4);
        
    }
}