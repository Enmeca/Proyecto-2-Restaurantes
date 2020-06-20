/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import Restaurante.Logic.Plato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class PlatoDAO {
    public List<Plato> Platosearch (RelDatabase db,String codigo){
      
  
             List<Plato> platillos = new ArrayList<>();
        try {
            String sql="select plato.*,categoria.Descripcion from plato inner join categoria on plato.Categoria=categoria.Codigo where plato.Categoria='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                platillos.add(plato(rs));
            }
        } catch (SQLException ex) { }
        return platillos ;
    }
      public List<Plato> Platosearchall (RelDatabase db){
      
  
             List<Plato> platillos = new ArrayList<>();
        try {
            String sql="select plato.*,categoria.Descripcion from plato inner join categoria on plato.Categoria=categoria.Codigo";
         
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                platillos.add(plato(rs));
            }
        } catch (SQLException ex) { }
        return platillos ;
    }
      public Plato Platoget (RelDatabase db,int codigo){
      
  
            
        try {
            String sql="select plato.*,categoria.Descripcion from plato inner join categoria on plato.Categoria=categoria.Codigo where plato.Codigo='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return plato(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
          public void Insert_plato(RelDatabase db,Plato p) throws Exception
    {
       String sql="insert into plato (Nombre,Descripcion,Precio,Categoria) values('%s','%s','%s','%s')";
                
        sql=String.format(sql,p.getNombre(),p.getDescripcion(),p.getPrecio(),p.getCategoria().getCodigo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
    public Plato plato(ResultSet rs) throws SQLException 
     {
     return new Plato(rs.getInt("Codigo"),rs.getNString("Nombre"),rs.getNString(3),rs.getDouble("Precio"),new Categoria(rs.getInt("Categoria"),rs.getNString(6)));
     }
}

