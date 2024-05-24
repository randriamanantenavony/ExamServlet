<%-- 
    Document   : updateActivitevoyage
    Created on : 28 févr. 2024, 22:30:13
    Author     : SAROBIDY
--%>

<%@page import="models.ActiviteVoyage"%>
<%@page import="java.util.List"%>
<%@page import="models.Voyage"%>
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
                List<Activite> activites = Activite.recupererActivite();
                List<Voyage> v = Voyage.recupererVoyage();
                ActiviteVoyage  av = new ActiviteVoyage(id);
                av = av.getById();
        %>
           
        <div class="container">
  <h2 class="title">Insertion d'activites de voyage</h2>
  
  
  <form action="InsertActiviteVoyageServlet" method="POST">
      
       <input type="hidden" name="action" value="update">
       <input type="hidden" name="id" value="<%= av.getId() %>">
       
       
    <div class="form-group">
      <label for="activities">Activités:</label>
      <div class="checkboxes">
            <%
                for (Activite activite  : activites) {
            %>
        <input type="checkbox" id="hiking" name="activities[]" value="<%= activite.getId() %>">
        <label for="hiking"><%= activite.getNom() %></label>
        
        
      <% } %>
      </div>
    </div>
    <div class="form-group">
        
        
      <label for="category">IdVoyage:</label>
             
      <select id="category" name="idV">
           <option value="<%= av.getId() %>"><%= av.getId() %></option>
           
            <%
                for (Voyage v1  : v) {
            %>
        <option value="<%= v1.getId() %>"><%= v1.getId() %></option>
      
          <% } %>
        
      </select>
    </div>
          
          
   
    
    <button type="submit">Valider</button>
  </form>
</div>
          
        
    </body>
</html>
