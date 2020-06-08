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
public class Adicional {
    int codigo;
    String nombre;
    double precio;
    Opcion opcion;


    public Adicional() {
    }

    public Adicional(int codigo, String nombre, double precion, Opcion opcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precion;
        this.opcion = opcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precion) {
        this.precio = precion;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

  
    
}
