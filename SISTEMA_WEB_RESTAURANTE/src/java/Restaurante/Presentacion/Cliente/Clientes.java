/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.Cliente;


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
@Path("/Clientes")
public class Clientes {
    @Context
    HttpServletRequest request;
    
    @POST
    @Produces({MediaType.APPLICATION_JSON})  
    @Consumes(MediaType.APPLICATION_JSON)  
    public void addCliente(Cliente c) {
        
        try {
        Model.instance().Insertclient(c);

        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
   
    @GET
    @Produces({MediaType.APPLICATION_JSON})  
    public Cliente getUser() {
       
        try {
         
           return (Cliente) request.getSession(true).getAttribute("Usuario"); 
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @DELETE
    public void Logout()
    {
    HttpSession session = request.getSession(true);
    session.removeAttribute("usuario");
    session.invalidate();
    }

}
