/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Address_book;
import Restaurante.Logic.Categoria;
import Restaurante.Logic.Cliente;
import Restaurante.Logic.Cliente_direccion;
import Restaurante.Logic.Plato;
import Restaurante.Logic.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class AddressBookDAO {
    public List<Address_book> Direccionessearch (RelDatabase db,Cliente c){
      
  
          List<Address_book> direcciones = new ArrayList<>();
        try {
            String sql="select  * from cliente inner join address_book on cliente.Usuario=address_book.cliente_Email where cliente.Usuario='%s' and cliente.Codigo='%s'";
         sql=String.format(sql,c.getUsuario().getCorreo(),c.getCodigo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                direcciones.add(direccion(rs));
            }
        } catch (SQLException ex) { }
        return direcciones ;
    }
      public Address_book Direccionget (RelDatabase db,Cliente c){
      
  

        try {
            String sql="select * from cliente inner join address_book on cliente.Email=address_book.cliente_Email where cliente_Codigo='%s' and cliente_Email='%s'";
         sql=String.format(sql,c.getCodigo(),c.getCorreo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return direccion(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
    public Address_book Direccionget2 (RelDatabase db,Cliente c){
        try {
            String sql="select * from cliente inner join address_book on cliente.Email=address_book.cliente_Email where cliente_Codigo='%s' and cliente_Email='%s' order by address_book.Codigo desc limit 1";
         sql=String.format(sql,c.getCodigo(),c.getCorreo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return direccion(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
     public Address_book Direcciongetbycodigo (RelDatabase db,int codigo){
      
  

        try {
            String sql="select * from cliente inner join address_book on cliente.Email=address_book.cliente_Email where address_book.Codigo='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return direccion(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
       public void Insert_direccion(RelDatabase db,Cliente user,String direccion) throws Exception
    {
       String sql="insert into address_book (Direccion,cliente_Codigo,cliente_Email) values('%s','%s','%s')";
                
        sql=String.format(sql,direccion,user.getCodigo(),user.getCorreo());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
    public Address_book direccion(ResultSet rs) throws SQLException 
     {
     return new Address_book(rs.getInt(7),new Cliente(rs.getInt(1),rs.getString(2),rs.getNString(3),rs.getNString(4),rs.getInt(5),new Usuario()),rs.getNString(8));
     }
}

