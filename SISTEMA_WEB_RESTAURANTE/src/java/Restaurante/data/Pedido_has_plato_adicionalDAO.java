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
     
}

