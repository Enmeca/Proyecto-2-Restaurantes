/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Administrador;
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
public class AdminDAO {
    public Administrador Inicio_sesion (RelDatabase db,Usuario user){
      
        try {
            String sql="select * from administrador inner join usuario on administrador.Usuario=usuario.Correo where usuario.Correo='%s' and usuario.clave='%s'";
           sql=String.format(sql,user.getCorreo(),user.getClave());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return administrador(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
     public void Insert_usuario(RelDatabase db,Usuario user) throws Exception
    {
       String sql="insert into usuario(Correo,Tipo,clave) values('%s','%s','%s') ";
                
        sql=String.format(sql,user.getCorreo(),"administrador",user.getClave());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    }
       public void Insert_admin(RelDatabase db,Administrador a) throws Exception
    {
       String sql="insert into administrador (Usuario,Nombre,Apellidos,Telefono) values('%s','%s','%s','%s')";
                
        sql=String.format(sql,a.getUsuario().getCorreo(),a.getNombre(),a.getApellidos(),a.getTelefono());
        int count=db.executeUpdate(sql);
        if (count==0){
            throw new Exception("Ya existe");
        }
    } 
    public Administrador administrador(ResultSet rs) throws SQLException 
     {
     return new Administrador(new Usuario(rs.getNString("Correo"),rs.getNString("Tipo"),rs.getNString("clave")),rs.getNString("Nombre"), rs.getNString("Apellidos"),rs.getInt("Telefono"));
     }

}

