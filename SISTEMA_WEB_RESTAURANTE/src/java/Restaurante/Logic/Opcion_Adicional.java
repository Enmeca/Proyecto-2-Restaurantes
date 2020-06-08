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
public class Opcion_Adicional {
    Opcion opcion;
    List<Adicional> adicionales;

    public Opcion_Adicional() {
    }

    public Opcion_Adicional(Opcion opcion, List<Adicional> adicionales) {
        this.opcion = opcion;
        this.adicionales = adicionales;
    }

    public Opcion getOpcion() {
        return opcion;
    }

    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public List<Adicional> getAdicionales() {
        return adicionales;
    }

    public void setAdicionales(List<Adicional> adicionales) {
        this.adicionales = adicionales;
    }
    
}
