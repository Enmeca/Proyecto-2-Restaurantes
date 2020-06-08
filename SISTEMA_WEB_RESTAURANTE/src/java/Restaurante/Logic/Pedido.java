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
public class Pedido {
   int codigo;
   String Tipo_pago;
   Cliente cliente;
   String tipo_orden; //asap o ...
   String hora;
   String fecha;
   String estado;
   Address_book direccion;
   double total;
   String tipo_pedido;//delivery o pick-up

    public Pedido(int codigo, String Tipo_pago, Cliente cliente, String tipo_orden, String hora, String fecha, String estado, Address_book direccion, double total, String tipo_pedido) {
        this.codigo = codigo;
        this.Tipo_pago = Tipo_pago;
        this.cliente = cliente;
        this.tipo_orden = tipo_orden;
        this.hora = hora;
        this.fecha = fecha;
        this.estado = estado;
        this.direccion = direccion;
        this.total = total;
        this.tipo_pedido = tipo_pedido;
    }

    public Pedido() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo_pago() {
        return Tipo_pago;
    }

    public void setTipo_pago(String Tipo_pago) {
        this.Tipo_pago = Tipo_pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(String tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Address_book getDireccion() {
        return direccion;
    }

    public void setDireccion(Address_book direccion) {
        this.direccion = direccion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipo_pedido() {
        return tipo_pedido;
    }

    public void setTipo_pedido(String tipo_pedido) {
        this.tipo_pedido = tipo_pedido;
    }
   
}
