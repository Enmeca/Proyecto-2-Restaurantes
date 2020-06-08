/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.Plato;


import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import Restaurante.Logic.Model;
import Restaurante.Logic.Plato;
import java.util.List;

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

}
