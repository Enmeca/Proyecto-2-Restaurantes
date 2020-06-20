/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.data;


import Restaurante.Logic.Model;
import Restaurante.Logic.Opcion;
import Restaurante.Logic.Pedido_has_plato;
import Restaurante.Logic.Pedido_has_plato_adicional;
import Restaurante.Logic.Pedido_has_plato_opcion;
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
public class Pedido_has_plato_adicionalDAO {
    public void InsertPedidohasplatoadicional (RelDatabase db,Pedido_has_plato_adicional p){
      
      String sql="";
      sql="insert into Pedido_has_plato_adicional (Adicional,Pedido_opcion,Pedido_has_plato) values('%s','%s','%s')";
      sql=String.format(sql,p.getAdicional().getCodigo(),p.getPedido_has_plato().getOpcion().getCodigo(),p.getPedido_has_plato().getPedido_has_plato().getCodigo());
      int count=db.executeUpdate(sql);
       
    }
     
      public List<Pedido_has_plato_adicional> PedidohasplatoadicionalSearch(RelDatabase db,int pedidoopcion,int pedidohasplato)
     {
       List<Pedido_has_plato_adicional> pedidoshasplatoadicional = new ArrayList<>();
        try {
            String sql="select * from pedido_has_plato_adicional where Pedido_opcion='%s' and Pedido_has_plato='%s'";
            sql=String.format(sql,pedidoopcion,pedidohasplato);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
             pedidoshasplatoadicional.add(pedidohasplatoadicional(rs));
            }
        } catch (SQLException ex) { }
        return pedidoshasplatoadicional ;
     }
     public Pedido_has_plato_adicional pedidohasplatoadicional(ResultSet rs) throws SQLException 
     {
      Opcion op=new Opcion();
      op.setCodigo(rs.getInt("Pedido_opcion"));
      Pedido_has_plato pedido=new Pedido_has_plato();
      pedido.setCodigo(rs.getInt("Pedido_has_plato"));
      return new Pedido_has_plato_adicional(Model.instance().Adicionalget(rs.getInt("Adicional")),Model.instance().Pedidohasplatoopcionget(new Pedido_has_plato_opcion(op,pedido)));
     }
}

