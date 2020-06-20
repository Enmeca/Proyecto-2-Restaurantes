/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.Plato;


import Restaurante.Logic.Categoria;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Restaurante.Logic.Model;
import Restaurante.Logic.Plato;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

/**
 *
 * @author Andres
 */
@Path("/Platillos")
public class Platillos {
   
    @GET
    @Path("{codigo}")
    @Produces({MediaType.APPLICATION_JSON})  
    public List<Plato> get(@PathParam("codigo") String codigo) {
        try {           
            return Model.instance().Platillosearch(codigo);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
     @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)  
    public void addPlato(Plato p) {
        
        try {
        Model.instance().InsertPlato(p);

        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON})  
    public List<Plato> getPlatos() {
        try {           
            return Model.instance().Platosearchall();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

}
