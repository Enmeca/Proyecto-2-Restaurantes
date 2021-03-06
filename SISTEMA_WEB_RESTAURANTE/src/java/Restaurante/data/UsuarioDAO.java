/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import Restaurante.Logic.Cliente;
import Restaurante.Logic.Cliente_direccion;
import Restaurante.Logic.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres
 */
public class UsuarioDAO {
    public Cliente Inicio_sesion (RelDatabase db,Usuario user){
      
        try {
            String sql="select * from cliente inner join usuario on cliente.Usuario=usuario.Correo where usuario.Correo='%s' and usuario.clave='%s'";
           sql=String.format(sql,user.getCorreo(),user.getClave());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return cliente(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
        public Cliente ClienteGet (RelDatabase db,Cliente_direccion user){
      
        try {
            
            String sql="select * from cliente where Email='%s' and Usuario is null order by Codigo desc limit 1";
           sql=String.format(sql,user.getCorreo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return cliente1(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
     public Cliente ClienteGetbycodigo (RelDatabase db,int c){
      
        try {
            
            String sql="select * from cliente where Codigo='%s'";
           sql=String.format(sql,c);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return cliente1(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
    public void Insert_usuario(RelDatabase db,Cliente user) throws Exception
    {
       String sql="insert into usuario(Correo,Tipo,clave) values('%s','%s','%s') ";
                
        sql=String.format(sql,user.getCorreo(),"usuario",user.getUsuario().getClave());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
    public void ClienteUpdate(Cliente c,RelDatabase db ) throws Exception{
        String sql="update cliente set Email='%s',Nombre='%s', Apellidos='%s', Telefono='%s' "+ 
                "where Codigo='%s'";
        sql=String.format(sql,c.getCorreo(),c.getNombre(),c.getApellidos(),c.getTelefono(),c.getCodigo());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Cliente no existe");
        }
    }
     public void UsuarioUpdate(Usuario u,RelDatabase db ) throws Exception{
        String sql="update usuario set clave='%s' "+ 
                "where Correo='%s'";
        sql=String.format(sql,u.getClave(),u.getCorreo());
        
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Usuario no existe");
        }
    }
     
      public void Insert_Cliente(RelDatabase db,Cliente user) throws Exception
    {
         String sql="";
        if(user.getUsuario()!=null){
         sql="insert into cliente(Email,Nombre,Apellidos,Telefono,Usuario) values('%s','%s','%s','%s','%s')";
          sql=String.format(sql,user.getCorreo(),user.getNombre(),user.getApellidos(),user.getTelefono(),user.getCorreo());
        }
      else
        {
        sql="insert into cliente(Email,Nombre,Apellidos,Telefono) values('%s','%s','%s','%s')";
         sql=String.format(sql,user.getCorreo(),user.getNombre(),user.getApellidos(),user.getTelefono());
        }
                
       
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
     public List<Cliente> Clientesearch (RelDatabase db){
      
  
             List<Cliente> clientes = new ArrayList<>();
        try {
            String sql="select * from cliente where usuario is not null";
         
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                clientes.add(cliente1(rs));
            }
        } catch (SQLException ex) { }
        return clientes ;
    }
    
    public Cliente cliente(ResultSet rs) throws SQLException 
     {
     return new Cliente(rs.getInt("Codigo"), rs.getNString("Email"),rs.getNString("Nombre"),rs.getNString("Apellidos"),rs.getInt("Telefono"),new Usuario(rs.getNString("Correo"),rs.getNString("Tipo"),rs.getNString("clave")));
     }
        public Cliente cliente1(ResultSet rs) throws SQLException 
     {
     return new Cliente(rs.getInt("Codigo"), rs.getNString("Email"),rs.getNString("Nombre"),rs.getNString("Apellidos"),rs.getInt("Telefono"),new Usuario());
     }
}

