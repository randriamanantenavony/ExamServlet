<%@page import="models.Administrateur"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <style>
 
        
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
    
        select,
    textarea,
    input[type="text"],
    input[type="date"],
    input[type="email"],
    input[type="password"]
    {
      width: 100%;
      padding: 10px;
      border: 3px solid  #43eee4; /* Bleu ciel */
      border-radius: 50px;
      box-sizing: border-box;
      margin-top: 5px;
    }

    </style>
    
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
       <br><br><br><br>
       
    <div class="container">
         <br><br><br><br>
        <h2 style="text-align: center;">Inscription</h2>
        <form action="AdminServlet" method="post">
            <div class="form-group">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" required>
            </div>
            <div class="form-group">
                <label for="email">E-mail :</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Mot de passe :</label>
                <input type="password" id="password" name="mdp" required>
            </div>
            <input type="submit" class ="submit" value="S'inscrire">
        </form>
    </div>
       
       
       
        <section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Liste des administrateurs</h2>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="table-wrap">
						<table class="table table-responsive-xl">
						  <thead>
						    <tr>
						    	<th>Nom</th>
						    	<th>Mail</th>
						        <th>Mot de passe</th>
						    
						      <th>&nbsp;</th>
						    </tr>
						  </thead>
						  <tbody>
                                                      
                                                     <%
                                                        List<Administrateur> admins = (List<Administrateur>) request.getAttribute("liste");
                                                       
                                                    %> 

                                                  <%
                                                        for (Administrateur admin : admins) {
                                                   %>
						    <tr class="alert" role="alert">
						    	<td>
						        <%= admin.getNom() %>
						    	</td>
						      <td class="d-flex align-items-center">
						      	<div class="img" style="background-image: url(images/person_1.jpg);"></div>
						      	<div class="pl-3 email">
						      		<span><%= admin.getMail() %></span>
						      		
						      	</div>
						      </td>
                                                      
						      <td><span><%= admin.getMdp() %></span></td>
						     
						      <td>
						      	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				            	<span aria-hidden="true"><i class="fa fa-close"></i></span>
				          	</button>
				        	</td>
                                                
                                                <td>
						      	<button type="button" class="custom-button">
				            	        <a href="AdminServlet?mode=d&&value=<%= admin.getId() %>"> Supprimer</a>
				          	     </button>
				        	</td>
                                                
                                                  <td>
						      	<button type="button" class="custom-button">
				            	        <a href="AdminServlet?mode=u&&value=<%= admin.getId() %>">Modifier</a>
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
