<%-- 
    Document   : updateVoyage
    Created on : 28 févr. 2024, 20:14:00
    Author     : SAROBIDY
--%>

<%@page import="models.Voyage"%>
<%@page import="models.Destination"%>
<%@page import="models.Categorie"%>
<%@page import="models.Activite"%>
<%@page import="models.ViewModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
          <style>


    .container {
      width: 90%;
      max-width: 600px;
      margin: 50px auto;
     
      padding: 20px;
      border: 2px solid 2db3ea; /* Bleu ciel */
      border-radius: 10px;
    }

    .title {
      color: #2db3ea; /* Bleu ciel */
      text-align: center;
    }

    .form-group {
      margin-bottom: 20px;
    }

    label {
      display: block;
      font-weight: bold;
      margin-bottom: 5px;
    }

    .checkboxes {
      display: flex;
      flex-wrap: wrap;
    }

    .checkboxes label {
      margin-right: 15px;
    }

    input[type="checkbox"] {
      margin-right: 5px;
    }

    select,
    textarea,
    input[type="text"],
    input[type="date"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #2db3ea; /* Bleu ciel */
      border-radius: 5px;
      box-sizing: border-box;
      margin-top: 5px;
    }

    button {
      background-color: #2db3ea; /* Bleu ciel */
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      font-size: 16px;
      width: 100%;
      margin-top: 10px;
    }

    button:hover {
      background-color: #5f9ea0; /* Autre nuance de bleu ciel */
    }
  </style>
  
  
       <%@ include file="header.html" %>
       
       
    </head>
    <body>
        
          <%
                ViewModel models = (ViewModel) request.getAttribute("liste");
                
                Integer id = (Integer) request.getAttribute("id");  
                Voyage v = new Voyage(id);
                v = v.getVoyageById();
                
        %>
       
      
        <div class="container">
  <h2 class="title">Insertion de voyage</h2>
  <form action="InsertVoyageServlet" method="POST">
      
       <input type="hidden" name="action" value="update">
       <input type="hidden" name="id" value="<%= v.getId() %>">
       
    <div class="form-group">
      <label for="activities">Activités:</label>
      <div class="checkboxes">
            <%
                for (Activite activite : models.getActivites()) {
            %>
        <input type="checkbox" id="hiking" name="activities[]" value="<%= activite.getId() %>">
        <label for="hiking"><%= activite.getNom() %></label>
        
        
      <% } %>
      </div>
    </div>
    <div class="form-group">
      <label for="category">Catégorie:</label>
             
      <select id="category" name="category">
          
          <option value="<%= v.getIdCategorie() %>"><%= v.getIdCategorie() %></option>
            <%
                for (Categorie voyage : models.getCategories()) {
            %>
        <option value="<%= voyage.getId() %>"><%= voyage.getNomCategorie() %></option>
      
          <% } %>
        
      </select>
    </div>
    <div class="form-group">
      <label for="destination">Destination:</label>
      <select id="destination" name="destination">
          
          <option value="<%= v.getIdDestination() %>"><%= v.getIdDestination() %></option>
            <%
                for (Destination destination : models.getDestination()) {
            %>
        <option value="<%= destination.getId() %>"><%= destination.getNom() %></option>
      
          <% } %>
        
      </select>
    </div>
          
    <div class="form-group">
      <label for="start_date">Date de début:</label>
      <input type="date" id="start_date" name="start_date" value="<%= v.getDebut() %>">
    </div>
          
          
    <div class="form-group">
      <label for="end_date">Date de fin:</label>
      <input type="date" id="end_date" name="end_date" value="<%= v.getFin() %>">
    </div
    
    
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea id="description" name="description" rows="4" cols="50" value="<%= v.getDescription() %>"></textarea>
    </div>
    
    
    <div class="form-group">
      <label for="price">Prix:</label>
      <input type="text" id="price" name="price" value="<%= v.getPrix() %>">
    </div>
    
    
    <button type="submit">Valider</button>
  </form>
</div>
          
          
    </body>
</html>
