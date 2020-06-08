/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Restaurante.Logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Model {
    private static Model uniqueInstance;
    private  Restaurante.data.RelDatabase db;
    private Restaurante.data.CategoriaDAO categoria;
     private Restaurante.data.PlatoDAO plato;
     private Restaurante.data.OpcionDAO opcion;
      private Restaurante.data.AdicionalDAO adicional;
      private HashMap<String,Item_Carrito> items;
     
        public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    public Model() {
        db = new Restaurante.data.RelDatabase();
        categoria = new Restaurante.data.CategoriaDAO();
        plato = new Restaurante.data.PlatoDAO();
        opcion= new Restaurante.data.OpcionDAO();
        adicional= new Restaurante.data.AdicionalDAO();
        items= new HashMap();
    }

    public List<Item_Carrito> getItems() {
        Collection<Item_Carrito> values = items.values(); 
 return new ArrayList(values);
    }

    public void setItems(HashMap<String, Item_Carrito> items) {
        this.items = items;
    }

    public List<Categoria> categoriasearch()
    {
    
    return categoria.Categoriasearch(db);
    }
    public List<Plato> Platillosearch(String codigo)
    {
    
    return plato.Platosearch(db, codigo);
    }
    public Plato Platoget(int codigo)
    {
    return plato.Platoget(db, codigo);
    }
    public List<Opcion> OpcionSearch(String codigo)
    {
    return opcion.Opcionsearch(db, codigo);
    }
    public Opcion OpcionGet(int codigo)
    {
    return opcion.Opcionget(db, codigo);
    }
    
   public List<Adicional> AdicionalSearch(int codigo)
   {
       return adicional.Adicionalsearch(db, codigo);
   }
    public List<Opcion_Adicional> OpcionAdicionalGet(List<Opcion> opciones)
    {
    List<Opcion_Adicional> opcionadicionales = new ArrayList();
    for(Opcion o:opciones)
    {
    opcionadicionales.add(new Opcion_Adicional(o,this.AdicionalSearch(o.getCodigo())));
    
    }
    return opcionadicionales;
    
    
    
    }
    
    public void GuardarItem(Item_Carrito item)
    {
        String key = KeyItem(item);
        if(items.get(key)==null)
        {
        items.put(key,item);
        }
        else
        {
        items.get(key).setCantidad(items.get(key).getCantidad()+item.getCantidad());
         items.get(key).setTotal(items.get(key).getTotal()+item.getTotal());
        }
    
    
    }
    public void restaplatillo(String item)
    {
       if(items.get(item).getCantidad()==1){
       items.remove(item);
       }else{
            items.get(item).setTotal(items.get(item).getTotal()-(items.get(item).getTotal()/items.get(item).getCantidad()));
        items.get(item).setCantidad(items.get(item).getCantidad()-1);
         
       
       }
    
    }
    private String KeyItem(Item_Carrito item)
    {
    String key=Integer.toString(item.getPlato().getCodigo());
    for(Adicional a:item.getAdicionales())
    {
        key+=Integer.toString(a.getCodigo());
    }
     for(Opcion o:item.getOpciones())
    {
        key+=o.getCodigo();
    }
     return key;
    }
}
