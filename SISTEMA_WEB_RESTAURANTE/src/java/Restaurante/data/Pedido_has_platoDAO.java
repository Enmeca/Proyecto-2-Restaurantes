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
import Restaurante.Logic.Model;
import Restaurante.Logic.OpcionesPedido;
import Restaurante.Logic.Pedido;
import Restaurante.Logic.Pedido_has_plato;
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
public class Pedido_has_platoDAO {
    public void InsertPedidohasplato (RelDatabase db,Pedido_has_plato p){
      
      String sql="";
      sql="insert into pedido_has_plato (Pedido_Codigo,Plato_Codigo,Cantidad) values('%s','%s','%s')";
      sql=String.format(sql,p.getPedido().getCodigo(),p.getPlato().getCodigo(),p.getCantidad());
      int count=db.executeUpdate(sql);
       
    }
      public Pedido_has_plato Pedidohasplatoget (RelDatabase db,Pedido p){
      
        try {
            String sql="select * from pedido_has_plato where Pedido_Codigo='%s' order by Codigo desc limit 1";
         sql=String.format(sql,p.getCodigo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return pedidohasplato(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
     public List<Pedido_has_plato> PedidohasplatoSearch(RelDatabase db,String codigo)
     {
       List<Pedido_has_plato> pedidoshasplato = new ArrayList<>();
        try {
            String sql="select * from pedido_has_plato where Pedido_Codigo='%s'";
            sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
               pedidoshasplato.add(pedidohasplato(rs));
            }
        } catch (SQLException ex) { }
        return pedidoshasplato ;
     }
     public Pedido_has_plato Pedidohasplatogetbycodigo (RelDatabase db,int codigo){
      
        try {
            String sql="select * from pedido_has_plato where Codigo='%s'";
         sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return pedidohasplato(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }

    public Pedido_has_plato pedidohasplato(ResultSet rs) throws SQLException 
     {
     
      return new Pedido_has_plato(rs.getInt("Codigo"),Model.instance().Pedidogetbycodigo(rs.getInt("Pedido_Codigo")),Model.instance().Platoget(rs.getInt("Plato_Codigo")),rs.getInt("Cantidad"));
     }
}

