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
public class OpcionesPedido {
    String tipo_orden;
    String tipo_pedido;
    Double total;
    String tipo_pago;

    public OpcionesPedido() {
    }

    public OpcionesPedido(String tipo_orden, String tipo_pedido, Double total, String tipo_pago) {
        this.tipo_orden = tipo_orden;
        this.tipo_pedido = tipo_pedido;
        this.total = total;
        this.tipo_pago = tipo_pago;
    }

    public String getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(String tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public String getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(String tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }
    
}
