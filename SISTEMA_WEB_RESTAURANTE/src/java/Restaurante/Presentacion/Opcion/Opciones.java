/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.Opcion;


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

import java.util.List;

/**
 *
 * @author Andres
 */
@Path("/Opciones")
public class Opciones {
   
    @GET
    @Path("{codigo}")
    @Produces({MediaType.APPLICATION_JSON})  
    public List<Opcion_Adicional> get(@PathParam("codigo") String codigo) {
        try {
           List<Opcion> opciones=Model.instance().OpcionSearch(codigo);
            return Model.instance().OpcionAdicionalGet(opciones);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }

}
