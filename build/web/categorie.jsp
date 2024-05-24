<%@page import="java.util.List"%>
<%@page import="models.Categorie"%>
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
</head>
<body>

     <%@ include file="header.html" %>
       

<div class="contact">
    <div class="container">
       <div class="row ">
          <div class="col-md-12">
             <div class="titlepage text_align_center">
                <h2>Insertion d'une <span class="blue_light">Catégorie</span></h2>
             </div>
          </div>
          <div class="col-md-10 offset-md-1">
              <form id="request" class="main_form" action="CategorieServlet">
                <div class="row">
                   <div class="col-md-12 ">
                      <input class="contactus" placeholder="catégorie" type="text" name="categorie"> 
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
					<h2 class="heading-section">Liste des catégories</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-responsive-xl">
						  <thead>
						    <tr>
						    	<th>idCategorie</th>
						    	<th>NomCategorie</th>
						      <th>Modification</th>
						      <th>Status</th>
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
                                                      
                                                     <%
                                                        List<Categorie> categories = (List<Categorie>) request.getAttribute("liste");
                                                        out.print(categories.size());
                                                    %> 

                                                  <%
                                                        for (Categorie categorie : categories) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= categorie.getId() %>
						    	</td>
						      <td class="d-flex align-items-center">
						      	<div class="img" style="background-image: url(images/person_1.jpg);"></div>
						      	<div class="pl-3 email">
						      		<span><%= categorie.getNomCategorie() %></span>
						      		<span>Added: 01/03/2020</span>
						      	</div>
						      </td>
                                                      
						      <td>Markotto89</td>
						      <td class="status"><span class="active">Active</span></td>
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

     
	<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>
  
   

</body>
</html>
