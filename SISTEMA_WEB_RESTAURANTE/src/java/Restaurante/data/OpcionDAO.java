/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import Restaurante.Logic.Opcion;
import Restaurante.Logic.Plato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class OpcionDAO {
    public List<Opcion> Opcionsearch (RelDatabase db,String codigo){
      
  
             List<Opcion> opciones = new ArrayList<>();
        try {
            String sql="select * from Opcion where Plato='%s' order by tipo desc";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                opciones.add(opcion(rs));
            }
        } catch (SQLException ex) { }
        return opciones;
    }
    public List<Opcion> OpcionsearchAll (RelDatabase db){
      
  
             List<Opcion> opciones = new ArrayList<>();
        try {
            String sql="select * from Opcion";
        
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                opciones.add(opcion(rs));
            }
        } catch (SQLException ex) { }
        return opciones;
    }
   public void Insert_opcion(RelDatabase db,Opcion o) throws Exception
    {
       String sql="insert into Opcion (Nombre,Tipo,Requerida,Plato) values('%s','%s','%s','%s')";
                
        sql=String.format(sql,o.getNombre(),o.getTipo(),o.isRequerido() ? 1 : 0 ,o.getPlato().getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
    
    public Opcion Opcionget (RelDatabase db,int codigo){
      
        try {
            String sql="select * from Opcion where Codigo='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return opcion(rs);
            }
        } catch (SQLException ex) { }
        return null;
    }
    
    
    public Opcion opcion(ResultSet rs) throws SQLException 
     {
     return new Opcion(rs.getInt("Codigo"),rs.getNString("Nombre"), rs.getNString("Tipo").charAt(0),rs.getBoolean("Requerida"),Restaurante.Logic.Model.instance().Platoget(rs.getInt("plato")));
     }
}

