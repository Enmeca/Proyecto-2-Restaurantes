/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

          function load(){
    $.ajax({type: "GET", url:"/SISTEMA_WEB_RESTAURANTE/api/Platillos/", contentType: "application/json"})
    .then( (Platillos)=>{list(Platillos);},
           (error)=>{ alert(errorMessage(error.status));});    
  }
$(load);
  function list(menus){
    var listado=$("#listado");
    listado.html("");
    menus.forEach( (m)=>{row(listado,m);});	
  }
  
  function row(listado,menu){
	var tr =$("<tr />");
  tr.html("<td>"+"</td>"+
                "<td>"+menu.codigo+"</td>"+
                "<td>"+menu.nombre+"</td>"+
                "<td>"+menu.descripcion+"</td>"+
                "<td>"+menu.precio+"</td>"+
                "<td>"+menu.categoria.descripcion+"</td>");
        // tr.find("#edit").on("click",()=>{edit(menu.cedula);});
        // tr.find("#delete").on("click",()=>{del(menu.cedula);});
	listado.append(tr);           
  }