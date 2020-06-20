/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Logic;

import java.util.List;

/**
 *
 * @author Andres
 */
public class DetallePedido {
    Pedido_has_plato pedidoplato;
    List<OpcionAdicionalPedido> opcionesadicionales;

    public DetallePedido() {
    }

    public DetallePedido(Pedido_has_plato pedidoplato, List<OpcionAdicionalPedido> opcionesadicionales) {
        this.pedidoplato = pedidoplato;
        this.opcionesadicionales = opcionesadicionales;
    }

    public Pedido_has_plato getPedidoplato() {
        return pedidoplato;
    }

    public void setPedidoplato(Pedido_has_plato pedidoplato) {
        this.pedidoplato = pedidoplato;
    }

    public List<OpcionAdicionalPedido> getOpcionesadicionales() {
        return opcionesadicionales;
    }

    public void setOpcionesadicionales(List<OpcionAdicionalPedido> opcionesadicionales) {
        this.opcionesadicionales = opcionesadicionales;
    }
    
}
