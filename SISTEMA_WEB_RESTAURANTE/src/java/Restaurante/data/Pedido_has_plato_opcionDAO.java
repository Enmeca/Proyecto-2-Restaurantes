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
public class Pedido_has_plato_opcionDAO {
    public void InsertPedidohasplato (RelDatabase db,Pedido_has_plato_opcion p){
      
      String sql="";
      sql="insert into Pedido_has_plato_opcion (Opcion_Codigo,pedido_has_plato_Codigo) values('%s','%s')";
      sql=String.format(sql,p.getOpcion().getCodigo(),p.getPedido_has_plato().getCodigo());
      int count=db.executeUpdate(sql);
       
    }
      public Pedido_has_plato_opcion Pedidohasplatoopcionget (RelDatabase db,Pedido_has_plato_opcion p){
      
        try {
            String sql="select * from Pedido_has_plato_opcion where pedido_has_plato_Codigo='%s' and Opcion_Codigo='%s' order by pedido_has_plato_Codigo desc limit 1";
         sql=String.format(sql,p.getPedido_has_plato().getCodigo(),p.getOpcion().getCodigo());
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
                return pedidohasplatoopcion(rs);
            }
        } catch (SQLException ex) { }
        return null ;
    }
       public List<Pedido_has_plato_opcion> PedidohasplatoopcionSearch(RelDatabase db,String codigo)
     {
       List<Pedido_has_plato_opcion> pedidoshasplatoopcion = new ArrayList<>();
        try {
            String sql="select * from Pedido_has_plato_opcion where pedido_has_plato_Codigo='%s'";
            sql=String.format(sql,codigo);
            ResultSet rs =  db.executeQuery(sql);
            while (rs.next()) {
               pedidoshasplatoopcion.add(pedidohasplatoopcion(rs));
            }
        } catch (SQLException ex) { }
        return pedidoshasplatoopcion ;
     }

    public Pedido_has_plato_opcion pedidohasplatoopcion(ResultSet rs) throws SQLException 
     {
     
      return new Pedido_has_plato_opcion(Model.instance().OpcionGet(rs.getInt("Opcion_Codigo")),Model.instance().Pedidohasplatogetbycodigo(rs.getInt("pedido_has_plato_Codigo")));
     }
}

