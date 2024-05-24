<%-- 
    Document   : activiteVoyage
    Created on : 28 févr. 2024, 22:09:17
    Author     : SAROBIDY
--%>

<%@page import="models.Activite"%>
<%@page import="models.Voyage"%>
<%@page import="models.ActiviteVoyage"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
           <link rel="stylesheet" href="css/bootstrap.min.css">
      <!-- style css -->
      <link rel="stylesheet" href="css/style.css">
      <!-- Responsive-->
      <link rel="stylesheet" href="css/responsive.css">
      <!-- fevicon -->
      <link rel="icon" href="images/fevicon.png" type="image/gif" />
      <!-- Tweaks for older IEs-->
      <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
     
      <link rel="stylesheet" href="css/style1.css">
      
      
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
      border: 3px solid  #43eee4; /* Bleu ciel */
      border-radius: 50px;
      box-sizing: border-box;
      margin-top: 5px;
    }

.submit {
      background-color:  #43eee4; /* Bleu ciel */
      color: #fff;
      padding: 10px 20px;
      border: none;
      border-radius: 50px;
      cursor: pointer;
      font-size: 16px;
      width: 100%;
      margin-top: 10px;
    }

    button:hover {
      background-color: #5f9ea0; /* Autre nuance de bleu ciel */
    }
  </style>
  
     <style>
     .custom-button {
            background-color: #43eee4; /* Background color of the button */
            border: 2px solid #43eee4; /* Sky blue border */
            border-radius: 12px; /* Rounded corners */
            padding: 10px 20px; /* Padding for the button */
            cursor: pointer; /* Cursor changes to pointer on hover */
            transition: background-color 0.3s, border-color 0.3s; /* Smooth transition for hover effects */
        }

    .custom-button a {
        text-decoration: none; /* Remove underline from the link */
        color: black; /* Text color of the link */
        font-size: 16px; /* Font size of the link */
    }

    .custom-button:hover {
        background-color: skyblue; /* Change background color on hover */
        border-color: deepskyblue; /* Change border color on hover */
    }

    .custom-button a:hover {
        color: white; /* Change text color on hover */
    }
</style>
  
    </head>
    <body>
       
           <%@ include file="header.html" %>
           
           
       
          <%
                List<Voyage> models = Voyage.recupererVoyage();
                List<Activite> activites = Activite.recupererActivite();
                                                       
        %>
           
        <div class="container">
    <div class="titlepage text_align_center">
                <h2>Insertion  <span class="blue_light">d'activités</span></h2>
             </div>
  
  <form action="InsertActiviteVoyageServlet" method="POST">
      
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
            <%
                for (Voyage v  : models) {
            %>
        <option value="<%= v.getId() %>"><%= v.getId() %></option>
      
          <% } %>
        
      </select>
    </div>
          
          
   
    
          <button type="submit" class="submit">Valider</button>
  </form>
</div>
          
          
             <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Liste des catégories</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-responsive-xl">
						  <thead>
						    <tr>
                                                        <th>id</th>
						    	<th>idVoyage</th>
						    	<th>Idactivité</th>
						      <th>nom</th>
						    
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
                                                      
                                                     <%
                                                        List<ActiviteVoyage> categories = (List<ActiviteVoyage>) request.getAttribute("liste");
                                                       
                                                    %> 

                                                  <%
                                                        for (ActiviteVoyage categorie : categories) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= categorie.getId() %>
						    	</td>
                                                        
                                                        
						      <td class="d-flex align-items-center">
						      	<div class="img" style="background-image: url(images/person_1.jpg);"></div>
						      	<div class="pl-3 email">
						      		<span><%= categorie.getIdVoyage() %></span>
						      		
						      	</div>
						      </td>
                                                      
						      <td><span><%= categorie.getIdActiviteVoyage() %></span></td>
						     
						      <td>
						      <span><%= categorie.getNomActivite() %></span>
				        	     </td>
                                                
                                                  <td>
                                                      <button type="button" class="custom-button">
				            	        <a href="UpdateVoyageServlet?mode=d&&value=<%= categorie.getId() %>"> Supprimer</a>
				          	     </button>
				        	</td>
                                                
                                                  <td>
						      	<button type="button" class="custom-button">
				            	        <a href="UpdateVoyageServlet?mode=u&&value=<%= categorie.getId() %>">Modifier</a>
				          	     </button>
				        	</td>
						    </tr>
                                                <% } %>
                                                    
                                                
                                                    
                                                
                                                    
						 
						  </tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>

    	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
    </body>
</html>
