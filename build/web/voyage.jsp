<%@page import="models.Voyage"%>
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
  <title>Formulaire d'insertion de voyage</title>
  
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

    
</style>
  

</head>
<body>

       <%@ include file="header.html" %>
       
          <%
                ViewModel models = (ViewModel) request.getAttribute("liste");
                                                       
        %>
       
       
<div class="container">
   <div class="titlepage text_align_center">
                <h2>Insertion  <span class="blue_light">d'activit�s</span></h2>
             </div>
  <form action="InsertVoyageServlet" method="POST">
      
    <div class="form-group">
      <label for="activities">Activit�s:</label>
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
      <label for="category">Cat�gorie:</label>
             
      <select id="category" name="category">
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
          

            <%
                for (Destination destination : models.getDestination()) {
            %>
        <option value="<%= destination.getId() %>"><%= destination.getNom() %></option>
      
          <% } %>
        
      </select>
    </div>
          
    <div class="form-group">
      <label for="start_date">Date de d�but:</label>
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
    
    
    <button type="submit" class="submit">Valider</button>
  </form>
</div>
          
          
     <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Liste des voyages</h2>
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
                                                        List<Voyage> voyages = (List<Voyage>) request.getAttribute("voyage");
                                                      
                                                    %> 

                                                  <%
                                                        for (Voyage voyage : voyages) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= voyage.getNomDestination() %>
						    	</td>
                                                        
                                                        
						    
                                                      
						      <td><%= voyage.getDebut() %></td>
                                                      
                                                        <td><%= voyage.getFin() %></td>
                                                      
                                                      
						      <td ><span class="active"><%= voyage.getDescription() %></span></td>
                                                      
                                                       <td ><span class="active"><%= voyage.getPrix() %></span></td>
                                                       
                                                        <td ><span class="active"><%= voyage.getNomCategorie() %></span></td>
                                                        
						       <td>
						      	<button type="button" class="custom-button">
				            	        <a href="InsertVoyageServlet?mode=d&&value=<%=  voyage.getId() %>"> Supprimer</a>
				          	     </button>
				        	</td>
                                                
                                                  <td>
						      	<button type="button" class="custom-button">
				            	        <a href="InsertVoyageServlet?mode=u&&value=<%= voyage.getId() %>">Modifier</a>
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
