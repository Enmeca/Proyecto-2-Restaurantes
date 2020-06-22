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
public class Opcion {
    int codigo;
    String nombre;
    char tipo;
    boolean requerido;
    Plato plato;

    public Opcion() {
    }

    public Opcion(int codigo, String nombre, char tipo, boolean requerido, Plato plato) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.requerido = requerido;
        this.plato = plato;
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

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public boolean isRequerido() {
        return requerido;
    }
    public boolean getRequerido() {
        return requerido;
    }
    public void setRequerido(boolean requerido) {
        this.requerido = requerido;
    }

   

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    
}
