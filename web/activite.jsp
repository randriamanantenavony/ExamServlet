<%@page import="models.Activite"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Catégorie</title>
          <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
   
      <!-- bootstrap css -->
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
       
          
 
      <div class="contact">
         <div class="container">
            <div class="row ">
               <div class="col-md-12">
                  <div class="titlepage text_align_center">
                     <h2>Insertion <span class="blue_light"> d'activité</span></h2>
                  </div>
               </div>
               <div class="col-md-10 offset-md-1">
                   <form id="request" class="main_form" action="ActiviteServlet" method="post">
                     <div class="row">
                      
                      
                        <div class="col-md-12">
                           <input class="contactus" placeholder="activité" type="type" name="nom">                          
                        </div>
                        <div class="col-md-12">
                            <textarea class="textarea" placeholder="description" type="type" Message="Name" name="desc"></textarea>
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
     
     
     <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Liste des activites</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-responsive-xl">
						  <thead>
						    <tr>
						    	<th>idActivite</th>
						    	<th>Nom activité</th>
						      <th>Description</th>
						    
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
                                                      
                                                     <%
                                                        List<Activite> categories = (List<Activite>) request.getAttribute("liste");
                                                       
                                                    %> 

                                                  <%
                                                        for (Activite categorie : categories) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= categorie.getId() %>
						    	</td>
						      <td class="d-flex align-items-center">
						      	<div class="img" style="background-image: url(images/person_1.jpg);"></div>
						      	<div class="pl-3 email">
						      		<span><%= categorie.getNom() %></span>
						      		
						      	</div>
						      </td>
                                                      
						      <td><span><%= categorie.getDesc() %></span></td>
						     
						      <td>
						      	<button type="button" >
				            	<span aria-hidden="true"><i class="fa fa-close"></i></span>
				          	</button>
				        	</td>
                                                
                                                  <td>
                                                      <button type="button"  class="custom-button">
				            	        <a href="ActiviteServlet?mode=d&&value=<%= categorie.getId() %>"> Supprimer</a>
				          	     </button>
				        	</td>
                                                
                                                  <td>
						      	<button type="button" class="custom-button">
				            	        <a href="ActiviteServlet?mode=u&&value=<%= categorie.getId() %>">Modifier</a>
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