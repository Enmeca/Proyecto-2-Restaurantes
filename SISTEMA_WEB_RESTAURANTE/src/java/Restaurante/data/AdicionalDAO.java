/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Adicional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class AdicionalDAO {
    public List<Adicional> Adicionalsearch (RelDatabase db,int codigo){
      
  
             List<Adicional> adicionales = new ArrayList<>();
        try {
            String sql="select * from adicional where Opcion='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                adicionales.add(adicional(rs));
            }
        } catch (SQLException ex) { }
        return adicionales ;
    }
        public Adicional Adicionalget (RelDatabase db,int codigo){
      
        try {
            String sql="select * from adicional where Codigo='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return adicional(rs);
            }
        } catch (SQLException ex) { }
        return null;
    }
       public void Insert_adicional(RelDatabase db,Adicional a) throws Exception
    {
       String sql="insert into adicional (Nombre,Precio,Opcion) values('%s','%s','%s')";
                
        sql=String.format(sql,a.getNombre(),a.getPrecio(),a.getOpcion().getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
    public Adicional adicional(ResultSet rs) throws SQLException 
     {
     return new Adicional(rs.getInt("Codigo"),rs.getNString("Nombre"),rs.getDouble("Precio"),Restaurante.Logic.Model.instance().OpcionGet(rs.getInt("Opcion")));
     }
}

