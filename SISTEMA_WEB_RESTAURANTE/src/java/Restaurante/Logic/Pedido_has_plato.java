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
public class Pedido_has_plato {
    int codigo;
    Pedido pedido;
    Plato plato;
    int cantidad;

    public Pedido_has_plato() {
    }

    public Pedido_has_plato(int Codigo, Pedido pedido, Plato plato, int cantidad) {
        this.codigo = Codigo;
        this.pedido = pedido;
        this.plato = plato;
        this.cantidad = cantidad;
    }

  
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
