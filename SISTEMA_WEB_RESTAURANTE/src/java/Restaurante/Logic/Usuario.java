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
public class Usuario {
    String id;
    String tipo;
    String correo;
    String clave;

    public Usuario(String id, String tipo, String correo, String clave) {
        this.id = id;
        this.tipo = tipo;
        this.correo = correo;
        this.clave = clave;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
}
