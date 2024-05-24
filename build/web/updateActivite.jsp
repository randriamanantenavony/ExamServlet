<%-- 
    Document   : updateActivite
    Created on : 28 févr. 2024, 19:57:39
    Author     : SAROBIDY
--%>

<%@page import="models.Activite"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
             <%@ include file="header.html" %>
       
    <%
               Integer id = (Integer) request.getAttribute("id");
               Activite activite = new Activite(id);
               activite = activite.getActiviteById();
              
                                                       
        %>         
 
      <div class="contact">
         <div class="container">
            <div class="row ">
               <div class="col-md-12">
                  <div class="titlepage text_align_center">
                     <h2>Modification <span class="blue_light"> d'activité</span></h2>
                  </div>
               </div>
               <div class="col-md-10 offset-md-1">
                   <form id="request" class="main_form" action="ActiviteServlet">
                     <div class="row">
                      
                          <input type="hidden" name="action" value="update">
                      
                          <input type="hidden" name="id" value="<%= activite.getId() %>">
                          
                        <div class="col-md-12">
                           <input class="contactus" placeholder="activité" type="type" name="nom" value="<%= activite.getNom() %>">                          
                        </div>
                        <div class="col-md-12">
                            <textarea class="textarea" placeholder="description" type="type" Message="Name" name="desc" > <%= activite.getDesc() %></textarea>
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Valider</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
             
    </body>
</html>
