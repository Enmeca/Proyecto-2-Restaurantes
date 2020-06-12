/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.OpcionesPedido;


import Restaurante.Presentacion.Url.*;
import Restaurante.Presentacion.Logueo.*;
import Restaurante.Logic.Cliente;
import Restaurante.Presentacion.Opcion.*;
import Restaurante.Presentacion.Plato.*;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Restaurante.Logic.Model;
import Restaurante.Logic.Opcion;
import Restaurante.Logic.Opcion_Adicional;
import Restaurante.Logic.Usuario;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Context;

/**
 *
 * @author Andres
 */
@Path("/OpcionesPedido")
public class OpcionesPedido {
    @Context
    HttpServletRequest request;
    
   
    @POST
    @Produces({MediaType.APPLICATION_JSON}) 
     @Consumes(MediaType.APPLICATION_JSON)
    public void AddOpciones(Restaurante.Logic.OpcionesPedido opciones) {
        try {
             Model.instance().setOpcionespedido(opciones);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON}) 
    public Restaurante.Logic.OpcionesPedido get() {
        try {
            return Model.instance().getOpcionespedido();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @PUT
    @Path("{Pago}")
   @Produces({MediaType.APPLICATION_JSON}) 
    public void update(@PathParam("Pago") String p) {  
        try {
            Model.instance().FormaPagoset(p);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

}
