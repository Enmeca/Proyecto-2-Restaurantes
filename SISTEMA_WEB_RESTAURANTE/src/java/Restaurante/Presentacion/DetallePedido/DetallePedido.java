/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Presentacion.DetallePedido;


import Restaurante.Presentacion.Pedido.*;
import Restaurante.Presentacion.Cliente.*;
import Restaurante.Presentacion.Logueo.*;
import Restaurante.Logic.Cliente;
import Restaurante.Logic.Cliente_direccion;
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
@Path("/DetallePedido")
public class DetallePedido {
    
    

    @GET
    @Path("{codigo}")
    @Produces({MediaType.APPLICATION_JSON}) 
    public List<Restaurante.Logic.DetallePedido> GetPedidos(@PathParam("codigo") String codigo) {
        try {
           // Model.instance().personaDelete(cedula);
          return Model.instance().Detallespedidoget(codigo);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
   

}
