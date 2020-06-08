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
public class Pedido_has_plato_adicional {
    Adicional adicional;
    Pedido_has_plato pedido_has_plato;

    public Pedido_has_plato_adicional() {
    }

    public Pedido_has_plato_adicional(Adicional adicional, Pedido_has_plato pedido_has_plato) {
        this.adicional = adicional;
        this.pedido_has_plato = pedido_has_plato;
    }

    public Adicional getAdicional() {
        return adicional;
    }

    public void setAdicional(Adicional adicional) {
        this.adicional = adicional;
    }

    public Pedido_has_plato getPedido_has_plato() {
        return pedido_has_plato;
    }

    public void setPedido_has_plato(Pedido_has_plato pedido_has_plato) {
        this.pedido_has_plato = pedido_has_plato;
    }
    
}
