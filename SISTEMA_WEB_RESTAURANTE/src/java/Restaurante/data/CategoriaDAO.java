/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class CategoriaDAO {
    public List<Categoria> Categoriasearch (RelDatabase db){
      
  
             List<Categoria> categorias = new ArrayList<>();
        try {
            String sql="select * from Categoria";
         
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                categorias.add(categoria(rs));
            }
        } catch (SQLException ex) { }
        return categorias ;
    }
    
    public Categoria categoria(ResultSet rs) throws SQLException 
     {
     return new Categoria(rs.getInt("Codigo"),rs.getNString("Descripcion"));
     }
}

