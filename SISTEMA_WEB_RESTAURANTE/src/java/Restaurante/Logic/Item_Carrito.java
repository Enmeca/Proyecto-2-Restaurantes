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
public class Item_Carrito {
    Plato plato;
    List<Adicional> adicionales;
    int cantidad;
    double total;
    List<Opcion> opciones;

    public Item_Carrito(Plato plato, List<Adicional> adicionales, int cantidad, double total, List<Opcion> opciones) {
        this.plato = plato;
        this.adicionales = adicionales;
        this.cantidad = cantidad;
        this.total = total;
        this.opciones = opciones;
    }

    public Item_Carrito() {
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public List<Adicional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<Adicional> adicionales) {
        this.adicionales = adicionales;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }
    
    

  
}
