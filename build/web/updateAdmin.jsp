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
           <%
               Integer id = (Integer) request.getAttribute("id");
               Administrateur admin = new Administrateur(id);
               admin = admin.getAdminById();
                                                       
        %>
       
  <div class="container">
         <br><br><br><br>
        <div class="titlepage text_align_center">
                     <h2>Modification <span class="blue_light"> d'un administrateur</span></h2>
                  </div>
        <form action="AdminServlet" method="post">
             <input type="hidden" name="action" value="update">
             
              <input type="hidden" name="id" value="<%= admin.getId() %>">
            <div class="form-group">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom" value="<%= admin.getNom() %>" >
            </div>
            <div class="form-group">
                <label for="email">E-mail :</label>
                <input type="email" id="email" name="email" value="<%= admin.getMail() %>">
            </div>
            <div class="form-group">
                <label for="password">Mot de passe :</label>
                <input type="password" id="password" name="mdp" value="<%= admin.getMdp() %>">
            </div>
            <input type="submit" class ="submit" value="Modifier">
        </form>
    </div>
       
       
           <script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/main.js"></script>  
       