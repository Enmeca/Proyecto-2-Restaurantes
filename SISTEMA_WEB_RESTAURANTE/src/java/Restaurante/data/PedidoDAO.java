/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;

import Restaurante.Logic.Categoria;
import Restaurante.Logic.Cliente;
import Restaurante.Logic.Cliente_direccion;
import Restaurante.Logic.OpcionesPedido;
import Restaurante.Logic.Plato;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andres
 */
public class PedidoDAO {
    public void InsertPedido (RelDatabase db,OpcionesPedido o,Cliente_direccion c){
       Format formatter = new SimpleDateFormat("dd-MM-yyyy");
      String sql="";
       if(!o.getTipo_orden().equals("ASP")){
            if(o.getTipo_pedido().equals("Express")){
           sql="insert into pedido (Tipo_pago,Tipo_orden,Fecha,FechaEntrega,Estado,Direccion,Total,Tipo_pedido,cliente_Codigo,cliente_Email) values('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')";
           sql=String.format(sql,o.getTipo_pago(),"Schedule order",formatter.format(new Date()),o.getTipo_orden(),"Pendiente",c.getDireccion(),o.getTotal(),o.getTipo_pedido(),c.getCodigo(),c.getCorreo());
            }
            else
            {
            sql="insert into pedido (Tipo_pago,Tipo_orden,Fecha,FechaEntrega,Estado,Total,Tipo_pedido,cliente_Codigo,cliente_Email) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
           sql=String.format(sql,o.getTipo_pago(),"Schedule order",formatter.format(new Date()),o.getTipo_orden(),"Pendiente",o.getTotal(),o.getTipo_pedido(),c.getCodigo(),c.getCorreo());
            }
       }
       else
       {
           if(o.getTipo_pedido().equals("Express"))
           {sql="insert into pedido (Tipo_pago,Tipo_orden,Fecha,Estado,Direccion,Total,Tipo_pedido,cliente_Codigo,cliente_Email) values('%s','%s','%s','%s','%s','%s','%s','%s','%s')";
       sql=String.format(sql,o.getTipo_pago(),o.getTipo_orden(),formatter.format(new Date()),"Pendiente",c.getDireccion(),o.getTotal(),o.getTipo_pedido(),c.getCodigo(),c.getCorreo());}
           else
           {
           sql="insert into pedido (Tipo_pago,Tipo_orden,Fecha,Estado,Total,Tipo_pedido,cliente_Codigo,cliente_Email) values('%s','%s','%s','%s','%s','%s','%s','%s')";
           sql=String.format(sql,o.getTipo_pago(),o.getTipo_orden(),formatter.format(new Date()),"Pendiente",o.getTotal(),o.getTipo_pedido(),c.getCodigo(),c.getCorreo());
           }
       }
        
        int count=db.executeUpdate(sql);
       
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
    public Plato plato(ResultSet rs) throws SQLException 
     {
     return new Plato(rs.getInt("Codigo"),rs.getNString("Nombre"),rs.getNString(3),rs.getDouble("Precio"),new Categoria(rs.getInt("Categoria"),rs.getNString(6)));
     }
}

