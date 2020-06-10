/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import Restaurante.Logic.Cliente;
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
    
    public Cliente cliente(ResultSet rs) throws SQLException 
     {
     return new Cliente(rs.getInt("Codigo"), rs.getNString("Email"),rs.getNString("Nombre"),rs.getNString("Apellidos"),rs.getInt("Telefono"),new Usuario(rs.getNString("Correo"),rs.getNString("Tipo"),rs.getNString("clave")));
     }
}

