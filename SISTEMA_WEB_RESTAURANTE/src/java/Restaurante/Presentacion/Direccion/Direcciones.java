/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.Direccion;

import Restaurante.Logic.Address_book;
import Restaurante.Presentacion.Categoria.*;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import Restaurante.Logic.Categoria;
import Restaurante.Logic.Cliente;
import Restaurante.Logic.Cliente_direccion;
import Restaurante.Logic.Model;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;

/**
 *
 * @author Andres
 */
@Path("/Direcciones")
public class Direcciones {
   
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Address_book> get(Cliente  cliente) {
        try {
          
            return Model.instance().Direccionesget(cliente);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void InsertDireccion(Cliente_direccion  cliente) {
        try {
          Cliente client= new Cliente();
          client.setCodigo(cliente.getCodigo());
          client.setCorreo(cliente.getCorreo());
            Model.instance().InsertDireccion(client, cliente.getDireccion());
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    

}
