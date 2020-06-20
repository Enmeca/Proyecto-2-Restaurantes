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
public class OpcionAdicionalPedido {
    Pedido_has_plato_opcion opcion;
    List<Pedido_has_plato_adicional> adicionales;

    public OpcionAdicionalPedido(Pedido_has_plato_opcion opcion, List<Pedido_has_plato_adicional> adicionales) {
        this.opcion = opcion;
        this.adicionales = adicionales;
    }

    public OpcionAdicionalPedido() {
    }

    public Pedido_has_plato_opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Pedido_has_plato_opcion opcion) {
        this.opcion = opcion;
    }

    public List<Pedido_has_plato_adicional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<Pedido_has_plato_adicional> adicionales) {
        this.adicionales = adicionales;
    }
    
}
