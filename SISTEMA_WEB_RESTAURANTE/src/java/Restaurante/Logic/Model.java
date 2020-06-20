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
      private Restaurante.data.UsuarioDAO usuario;
      private Restaurante.data.AdminDAO admin;
      private Restaurante.data.PedidoDAO pedido;
      private Restaurante.data.AddressBookDAO direccion;
      private Restaurante.data.Pedido_has_platoDAO pedidohasplato;
      private Restaurante.data.Pedido_has_plato_opcionDAO pedidohasplatoopcion;
      private Restaurante.data.Pedido_has_plato_adicionalDAO pedidohasplatoadicional;
      private HashMap<String,Item_Carrito> items;
      private OpcionesPedido opcionespedido;
      private String platoedit;
     
        public static Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Model();
        }
        return uniqueInstance; 
    }

    public Model() {
        db = new Restaurante.data.RelDatabase();
        admin = new Restaurante.data.AdminDAO();
        categoria = new Restaurante.data.CategoriaDAO();
        plato = new Restaurante.data.PlatoDAO();
        opcion= new Restaurante.data.OpcionDAO();
        adicional= new Restaurante.data.AdicionalDAO();
        usuario= new Restaurante.data.UsuarioDAO();
        direccion=new Restaurante.data.AddressBookDAO();
        items= new HashMap();
        opcionespedido = null;
        pedido=new Restaurante.data.PedidoDAO();
        pedidohasplato = new Restaurante.data.Pedido_has_platoDAO();
        pedidohasplatoopcion=new Restaurante.data.Pedido_has_plato_opcionDAO();
        pedidohasplatoadicional=new Restaurante.data.Pedido_has_plato_adicionalDAO();
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
    public List<Pedido_has_plato> Pedidoshasplatosearch(String codigo)
    {
    return pedidohasplato.PedidohasplatoSearch(db, codigo);
    }
    public void Insertclient(Cliente c) throws Exception
    {
    if(c.getUsuario()!=null)    
    usuario.Insert_usuario(db, c);
    
    usuario.Insert_Cliente(db, c);
   
    }
     public List<Pedido> Pedidosearch()
    {
    
    return pedido.PedidoSearch(db);
    }
    public void UpdatePedido(Pedido p) throws Exception
    {
    pedido.PedidoUpdate(p, db);
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
    public Pedido Pedidogetbycodigo(int Codigo)
    {
    return pedido.Pedidogetbycodigo(db, Codigo);
    }
    public Pedido_has_plato Pedidohasplatogetbycodigo(int c)
    {
    return pedidohasplato.Pedidohasplatogetbycodigo(db, c);
    }
    public Cliente Clientegetbycodigo(int c)
    {
    return usuario.ClienteGetbycodigo(db, c);
    }
    public Address_book Direcciongetbycodigo(int c)
    {
    return direccion.Direcciongetbycodigo(db, c);
    }
   public List<Adicional> AdicionalSearch(int codigo)
   {
       return adicional.Adicionalsearch(db, codigo);
   }
   
   public Pedido_has_plato_opcion Pedidohasplatoopcionget(Pedido_has_plato_opcion p)
   {
   return pedidohasplatoopcion.Pedidohasplatoopcionget(db, p);
   }
   public List<Pedido_has_plato_opcion> Pedidohasplatoopcionsearch(String codigo)
   {
   return pedidohasplatoopcion.PedidohasplatoopcionSearch(db, codigo);
   }
   public Adicional Adicionalget(int codigo)
   {
   return adicional.Adicionalget(db, codigo);
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
    public List<Address_book> Direccionesget(Cliente c)
    {
    return direccion.Direccionessearch(db, c);
    }
    public Cliente UserGet(Usuario u)
    {
     return usuario.Inicio_sesion(db, u);
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
    public Administrador InicioSesionAdmin(Usuario user)
    {
    return admin.Inicio_sesion(db, user);
    }
    public void FormaPagoset(String formapago)
    {
    opcionespedido.setTipo_pago(formapago);
    }
    public void restaplatillo(String item)
    {
       if(items.get(item).getCantidad()==1){
       items.remove(item);
       }else{
           this.opcionespedido.setTotal(this.opcionespedido.getTotal()-(items.get(item).getTotal()-(items.get(item).getTotal()/items.get(item).getCantidad())));
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

    public OpcionesPedido getOpcionespedido() {
        return opcionespedido;
    }
    public Cliente Clienteget(Cliente_direccion user)
    {
        return usuario.ClienteGet(db, user);
    }
    public List<Pedido> Pedidosget(String codigo)
    {
    return pedido.Pedidosget(db, codigo);
    }
    public void setOpcionespedido(OpcionesPedido opcionespedido) {
        this.opcionespedido = opcionespedido;
    }
    public void InsertDireccion(Cliente c,String Direccion) throws Exception
    {
   this.direccion.Insert_direccion(db, c, Direccion);
    }
    public Pedido InsertarPedido(Cliente_direccion c) throws Exception{
   Cliente client;
        if(c.getUsuario()==null)
    { 
        this.Insertclient(new Cliente(c.getCodigo(),c.getCorreo(),c.getNombre(),c.getApellidos(),c.getTelefono(),null));
        client=this.Clienteget(c);
        c.setCodigo(client.getCodigo());
        if(!opcionespedido.getTipo_pedido().equals("Pasan")){
        this.InsertDireccion(client, c.getDireccion());
        c.setDireccion(Integer.toString(direccion.Direccionget(db, client).getCodigo()));
        }
        pedido.InsertPedido(db, opcionespedido, c);
        Pedido pedido_1=pedido.Pedidoget(db, client);
        for(Item_Carrito item:items.values())
        {
            pedidohasplato.InsertPedidohasplato(db, new Pedido_has_plato(0,pedido_1,item.getPlato(),item.getCantidad()));
            Pedido_has_plato pedido_has_plato=pedidohasplato.Pedidohasplatoget(db, pedido_1);
            for(Adicional a:item.getAdicionales())
            {
                pedidohasplatoopcion.InsertPedidohasplato(db, new Pedido_has_plato_opcion(a.getOpcion(),pedido_has_plato));
                
                pedidohasplatoadicional.InsertPedidohasplatoadicional(db,  new Pedido_has_plato_adicional(a,new Pedido_has_plato_opcion(a.getOpcion(),pedido_has_plato)));
                
            }
        }
        limpiar();
       return pedido_1;
    }
    else
    {
         client=new Cliente(c.getCodigo(),c.getCorreo(),c.getNombre(),c.getApellidos(),c.getTelefono(),c.getUsuario());
         if(!opcionespedido.getTipo_pedido().equals("Pasan") && !c.getDireccion().matches("[-+]?\\d*\\.?\\d+")){
        this.InsertDireccion(client, c.getDireccion());
        c.setDireccion(Integer.toString(direccion.Direccionget2(db, client).getCodigo()));
        }
        pedido.InsertPedido(db, opcionespedido, c);
        

        
        Pedido pedido_1=pedido.Pedidoget(db, client);
        for(Item_Carrito item:items.values())
        {
            pedidohasplato.InsertPedidohasplato(db, new Pedido_has_plato(0,pedido_1,item.getPlato(),item.getCantidad()));
            Pedido_has_plato pedido_has_plato=pedidohasplato.Pedidohasplatoget(db, pedido_1);
            for(Adicional a:item.getAdicionales())
            {
                pedidohasplatoopcion.InsertPedidohasplato(db, new Pedido_has_plato_opcion(a.getOpcion(),pedido_has_plato));
                
                pedidohasplatoadicional.InsertPedidohasplatoadicional(db,  new Pedido_has_plato_adicional(a,new Pedido_has_plato_opcion(a.getOpcion(),pedido_has_plato)));
                
            }
        }
        limpiar();
        return pedido_1;
    }
    
    
    }
    public List<Opcion> Opcionsearchall()
    {
      return opcion.OpcionsearchAll(db);
    }
    public List<Plato> Platosearchall()
    {
      return plato.Platosearchall(db);
    }
      public void InsertOpcion(Opcion o) throws Exception
    {
       opcion.Insert_opcion(db, o);
    }
        public void InsertAdicional(Adicional a) throws Exception
    {
       adicional.Insert_adicional(db, a);
    }
      public void InsertPlato(Plato p) throws Exception
    {
    plato.Insert_plato(db, p);
    }
    public void InsertCategoria(Categoria c) throws Exception
    {
    categoria.Insert_categoria(db, c);
    }
    public void ClienteUpdate(Cliente c) throws Exception
    {
    usuario.UsuarioUpdate(c.getUsuario(), db);
    usuario.ClienteUpdate(c, db);
    }
    public void limpiar()
    {
    items.clear();
    this.opcionespedido=null;
    }
    public String getPlatoedit() {
        return platoedit;
    }
    public List<Cliente> clientesearch()
    {
    return usuario.Clientesearch(db);
    }
    public void InsertAdmin(Administrador a) throws Exception
    {
        admin.Insert_usuario(db, a.getUsuario());
        admin.Insert_admin(db, a);
    }
    public void setPlatoedit(String platoedit) {
        this.platoedit = platoedit;
    }
    public void EditPlato(Item_Carrito i)
    {
      if(KeyItem(i).equals(platoedit))
      {
         items.get(platoedit).setCantidad(i.getCantidad());
          items.get(platoedit).setTotal(i.getTotal());
      }
      else
      {
        if(opcionespedido==null)
        { items.remove(platoedit);
        this.GuardarItem(i);}
        else
        {
        opcionespedido.setTotal((opcionespedido.getTotal()- items.get(platoedit).getTotal())+i.getTotal());
        items.remove(platoedit);
        this.GuardarItem(i);
        }
        
      
      }
    }
    public List<Pedido_has_plato_adicional> Pedidohasplatoadicionalsearch(int Codigoopcion,int codigohasplato)
    {
    return pedidohasplatoadicional.PedidohasplatoadicionalSearch(db, Codigoopcion, codigohasplato);
    }
    public List<DetallePedido> Detallespedidoget(String codigo)
    {
     List<DetallePedido> detallespedido=new ArrayList();
     List<Pedido_has_plato> pedidos_has_plato= this.Pedidoshasplatosearch(codigo);
     for(Pedido_has_plato php:pedidos_has_plato)   
     {
     List<Pedido_has_plato_opcion> opcionespedido= this.Pedidohasplatoopcionsearch(Integer.toString(php.getCodigo()));
     List<OpcionAdicionalPedido> opcionadicionalpedido = new ArrayList();
        for(Pedido_has_plato_opcion phpo: opcionespedido)
        {
            List<Pedido_has_plato_adicional> adicionales = this.Pedidohasplatoadicionalsearch(phpo.getOpcion().getCodigo(),phpo.getPedido_has_plato().getCodigo());
            opcionadicionalpedido.add(new OpcionAdicionalPedido(phpo,adicionales));
        }
        detallespedido.add(new DetallePedido(php,opcionadicionalpedido));
     }
    return detallespedido;
    }
   
}
