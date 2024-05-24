<%@page import="models.Offre"%>
<%@page import="java.util.List"%>
<%@page import="models.Activite"%>
<%@page import="models.Destination"%>
<%@page import="models.Categorie"%>
<%@page import="models.ViewModel"%>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulaire d'insertion d'offre spéciale</title>
    
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
    }

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
</head>
<body>

       <%@ include file="header.html" %>
       
          <%
                ViewModel models = (ViewModel) request.getAttribute("liste");
                                                       
        %>
       
       
<div class="container">
  <h2 class="title">Insertion de voyage</h2>
  <form action="ListOffreServlet" method="POST">
      
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
            <%
                for (Categorie categorie : models.getCategories()) {
            %>
        <option value="<%= categorie.getId() %>"><%= categorie.getNomCategorie() %></option>
      
          <% } %>
        
      </select>
    </div>
    <div class="form-group">
      <label for="destination">Destination:</label>
      <select id="destination" name="destination">
          

            <%
                for (Destination destination : models.getDestination()) {
            %>
        <option value="<%= destination.getId() %>"><%= destination.getNom() %></option>
      
          <% } %>
        
      </select>
    </div>
          
    <div class="form-group">
      <label for="start_date">Date de début:</label>
      <input type="date" id="start_date" name="start_date">
    </div>
          
          
    <div class="form-group">
      <label for="end_date">Date de fin:</label>
      <input type="date" id="end_date" name="end_date">
    </div
    
    
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea id="description" name="description" rows="4" cols="50"></textarea>
    </div>
    
    
    <div class="form-group">
      <label for="price">Prix:</label>
      <input type="text" id="price" name="price">
    </div>
    
    
    <button type="submit">Valider</button>
  </form>
</div>

          
             <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Liste des offres spéciales</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-responsive-xl">
						  <thead>
						    <tr>
						    	<th>Destination</th>
						    	<th>date debut</th>
						      <th>Date fin</th>
						      <th>Description</th>
                                                      <th>Prix</th>
						      <th>Categorie</th>
						    </tr>
						  </thead>
						  <tbody>
                                                      
                                                     <%
                                                        List<Offre> voyages = (List<Offre>) request.getAttribute("offre");
                                                      
                                                    %> 

                                                  <%
                                                        for (Offre voyage : voyages) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= voyage.getNomDestination() %>
						    	</td>
                                                        
                                                        
						      <td class="d-flex align-items-center">
						      	<div class="img" style="background-image: url(images/person_1.jpg);"></div>
                                                        
						      	<div class="pl-3 email">
						      		<span><%= voyage.getDebut() %></span>
						      		
						      	</div>
						      </td>
                                                      
                                                      
						  
                                                      
                                                        <td><%= voyage.getFin() %></td>
                                                      
                                                      
						      <td ><span class="active"><%= voyage.getDescription() %></span></td>
                                                      
                                                       <td ><span class="active"><%= voyage.getPrix() %></span></td>
                                                       
                                                        <td ><span class="active"><%= voyage.getNomCategorie() %></span></td>
                                                        
						      <td>
                                                          
						      	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				            	<span aria-hidden="true"><i class="fa fa-close"></i></span>
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
</body>
</html>
