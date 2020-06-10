/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.ItemCarrito;


import Restaurante.Logic.Item_Carrito;
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
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

/**
 *
 * @author Andres
 */
@Path("/ItemsCarrito")
public class ItemsCarrito {
   
    @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Item_Carrito> get(Item_Carrito item) {
        try {
            Model.instance().GuardarItem(item);
         
           //List<Opcion> opciones=Model.instance().OpcionSearch(codigo);
            return Model.instance().getItems();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @GET
    @Path("{codigo}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item_Carrito> Resta_item(@PathParam("codigo") String  item) {
        try {
           Model.instance().restaplatillo(item);
            return Model.instance().getItems();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Item_Carrito> get_items() {
        try {
           
            return Model.instance().getItems();
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
}
