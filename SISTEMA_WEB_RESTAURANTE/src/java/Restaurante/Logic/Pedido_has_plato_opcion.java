/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Logic;

/**
 *
 * @author Andres
 */
public class Pedido_has_plato_opcion {
    Opcion opcion;
    Pedido_has_plato pedido_has_plato;

    public Pedido_has_plato_opcion(Opcion opcion, Pedido_has_plato pedido_has_plato) {
        this.opcion = opcion;
        this.pedido_has_plato = pedido_has_plato;
    }

    public Pedido_has_plato_opcion() {
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public Pedido_has_plato getPedido_has_plato() {
        return pedido_has_plato;
    }

    public void setPedido_has_plato(Pedido_has_plato pedido_has_plato) {
        this.pedido_has_plato = pedido_has_plato;
    }
    
}
