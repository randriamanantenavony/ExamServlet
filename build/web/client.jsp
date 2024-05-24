<%@page import="models.Voyage"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <!-- basic -->
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <!-- mobile metas -->
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <meta name="viewport" content="initial-scale=1, maximum-scale=1">
      <!-- site metas -->
      <title>4uhost</title>
      <meta name="keywords" content="">
      <meta name="description" content="">
      <meta name="author" content="">
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
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
      
        <style>
        .send_btn {
            display: block; /* Pour s'assurer que le bouton prend toute la largeur */
            width: 100%; /* Remplir toute la largeur de la page */
            padding: 10px; /* Pour un peu de remplissage intérieur */
            margin: 100px 0 0 0; /* 100 pixels de marge supérieure pour la distance par rapport au dernier input */
            border: 2px solid #43eee4; /* Bordure de couleur bleu-vert foncé */
            background-color: #43eee4; /* Couleur de remplissage bleu-vert */
            color: white; /* Couleur du texte */
            font-size: 16px; /* Taille de la police */
            text-align: center; /* Centrer le texte */
            cursor: pointer; /* Changer le curseur à pointer */
            border-radius: 50px;
        }
    </style>
      
   </head>
   <!-- body -->
   <body class="main-layout">
      <!-- loader  -->
      <div class="loader_bg">
         <div class="loader"><img src="images/loading.gif" alt="#"/></div>
      </div>
      <!-- end loader -->
      <!-- header -->
      <div class="header">
         <div class="container">
            <div class="row d_flex">
               <div class=" col-md-2 col-sm-3 col logo_section">
                  <div class="full">
                     <div class="center-desk">
                        <div class="logo">
                           <a href="index.html"><img src="images/logo.png" alt="#" /></a>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="col-md-8 col-sm-12">
                  <nav class="navigation navbar navbar-expand-md navbar-dark ">
                     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                     <span class="navbar-toggler-icon"></span>
                     </button>
                     <div class="collapse navbar-collapse" id="navbarsExample04">
                        <ul class="navbar-nav mr-auto">
                           <li class="nav-item active">
                              <a class="nav-link" href="index.html">Home</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="about.html">About</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="hosting.html">Hosting</a>
                           </li>
                           <li class="nav-item">
                              <a class="nav-link" href="domain.html">Domain</a>
                           </li>
                          
                           <li class="nav-item">
                              <a class="nav-link" href="contact.html">Contact Us</a>
                           </li>
                        </ul>
                     </div>
                  </nav>
               </div>
               <div class="col-md-2  d_none">
                  <ul class="email text_align_right">
                     <li><a href="Javascript:void(0)"> <i class="fa fa-shopping-bag" aria-hidden="true"> <span>0</span></i>
                        </a>
                     </li>
                     <li><a href="Javascript:void(0)">Sign In
                        </a>
                     </li>
                  </ul>
               </div>
            </div>
         </div>
      </div>
      <!-- end header inner -->
      <!-- top -->
      
      <div class="full_bg">
         <div class="slider_main">
            <div class="container">
               <div class="row">
                  <div class="col-md-12">
                     <!-- carousel code -->
                     <div id="banner1" class="carousel slide">
                        <ol class="carousel-indicators">
                           <li data-target="#banner1" data-slide-to="0" class="active"></li>
                           <li data-target="#banner1" data-slide-to="1"></li>
                           <li data-target="#banner1" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                           <!-- first slide -->
                           <div class="carousel-item active">
                              <div class="carousel-caption relative">
                                 <div class="row">
                                    <div class="col-md-6">
                                       <div class="dream">
                                          <h1>
                                             Welcome <br>to our <br>travel <br>website
                                          </h1>
                                          <a class="read_more" href="login.html">Log in</a>    
                                          <a class="read_more" href="client.jsp">Explore</a>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       <div class="dream_img">
                                          <figure><img src="images/fond.jpg" alt="#"/></figure>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <!-- second slide -->
                           <div class="carousel-item">
                              <div class="carousel-caption relative">
                                 <div class="row">
                                    <div class="col-md-6">
                                       <div class="dream">
                                          <h1>
                                             PowerFul <br>HOSTING <br>Your dream <br>destination
                                          </h1>
                                          <a class="read_more" href="login.html">Log in</a>    
                                          <a class="read_more" href="client.html">Explore</a>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       <div class="dream_img">
                                          <figure><img src="images/plage.jpg" alt="#"/></figure>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <!-- third slide-->
                           <div class="carousel-item">
                              <div class="carousel-caption relative">
                                 <div class="row">
                                    <div class="col-md-6">
                                       <div class="dream">
                                          <h1>
                                             Realize <br>and enjoy <br>Your dream <br>travel
                                          </h1>
                                   
                                          <a class="read_more" href="login.html">Log in</a>    
                                          <a class="read_more" href="client.html">Explore</a>
                                       </div>
                                    </div>
                                    <div class="col-md-6">
                                       <div class="dream_img">
                                          <figure><img src="images/fly.jpg" alt="#"/></figure>
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                        </div>
                        <!-- controls -->
                        <a class="carousel-control-prev" href="#banner1" role="button" data-slide="prev">
                        <i class="fa fa-arrow-left" aria-hidden="true"></i>
                        <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#banner1" role="button" data-slide="next">
                        <i class="fa fa-arrow-right" aria-hidden="true"></i>
                        <span class="sr-only">Next</span>
                        </a>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
      <!-- end banner -->
      <!-- domain -->
      
      
      
      <form action="ClientInterfaceServlet" method="post">
   <div class="domain">
   <div class="container">
      <div class="row">
         <div class="col-md-12">
            <div class="titlepage text_align_center">
               <h2>Let's starts with  <span class="blue_light">search</span></h2>
            </div>
         </div>
      </div>
   </div>
   
   <div class="container">
      <div class="row">
         <div class="col-md-10 offset-md-1">
            <div class="form">
               <div class="searchbar">
                  <input class="search_input" type="date" name="debut" placeholder="">
                
               </div>
            </div>
         </div>
      </div>
   </div>
   
          <div class="container mt-3">
      <!-- Votre contenu ici -->
   </div>

       
   <div class="container">
      <div class="row">
         <div class="col-md-10 offset-md-1">
            <div class="form">
               <div class="searchbar">
                  <input class="search_input" type="date" name="fin" placeholder="Search end date">
                
               </div>
            </div>
         </div>
      </div>
   </div>
       
          <div class="container mt-3">
      <!-- Votre contenu ici -->
   </div>

   
   <div class="container">
      <div class="row">
         <div class="col-md-10 offset-md-1">
            <div class="form">
               <div class="searchbar">
                  <input class="search_input" type="text" name="prix" placeholder="Search price">
                  <a href="#" class="search_icon"><i class="fa fa-search" aria-hidden="true"></i></a>
               </div>
            </div>
         </div>
      </div>
       
       
          <div class="col-md-12">
                      <button class="send_btn">Valider</button>
                   </div>
   </div>
</div>

    </form> 
      
      
   
      
      <!-- end guarantee -->
      <!-- order -->
      <div class="order">
         <div class="container">
            <div class="row">
               <div class="col-md-8 offset-md-2">
                  <div class="titlepage text_align_center">
                     <h2>Nos offres  <br> <span class="blue_light">Spéciale</span></h2>
                     <p>Venez découvrir nos offres spéciales du jour à une date très limitée
                     </p>
                  </div>
               </div>
            </div>
             
            <div class="row">
               <div class="col-md-4">
                  <div id="ho_co" class="order-box_main">
                     <div class="order-box text_align_center">
                        <h3>Voyage à Bali</h3>
                        <p>STARTING  <span>$900</span> PER PERSON</p>
                      
                        <ul class="supp">
                           <li>Projets illimtés</li>
                           <li>Exploration d Tanaht</li>
                           <li>Plongée à Nusa</li>
                       
                           <li>24/7 de support</li>
                        </ul>
                     </div>
                     <a class="read_more" href="Javascript:void(0)">Order Now</a>
                  </div>
               </div>
                
                
               <div class="col-md-4">
                  <div id="ho_co" class="order-box_main">
                     <div class="order-box text_align_center">
                        <h3>Santorin</h3>
                        <p>STARTING  <span>$850</span> PER PERSON</p>
                      
                        <ul class="supp">
                           <li>Projets illimités</li>
                           <li>24/7 de support</li>
                           <li>Couchers de solieil à Oia</li>
                           <li>Visites des ruines d'Akrotiri</li>
                        
                        </ul>
                     </div>
                     <a class="read_more" href="Javascript:void(0)">Order Now</a>
                  </div>
               </div>
                
                
               <div class="col-md-4">
                  <div id="ho_co" class="order-box_main">
                     <div class="order-box text_align_center">
                        <h3>Maldives</h3>
                        <p>STARTING  <span>$1000</span> PER PERSON</p>
                       
                        <ul class="supp">
                           <li>Bungalows sur pilotis</li>
                           <li>24/7 de support</li>
                           <li>Plongée sous-marine</li>
                           <li>Croisière au coucher du soleil</li>
                          
                        </ul>
                     </div>
                     <a class="read_more" href="Javascript:void(0)">Order Now</a>
                  </div>
               </div>
                
                
            </div>
         </div>
      </div>
      <!-- end order -->
     
      
      
      <!-- end about -->
      <!-- contact -->
      <div class="contact">
         <div class="container">
            <div class="row ">
               <div class="col-md-12">
                  <div class="titlepage text_align_center">
                     <h2>Contact <span class="blue_light">Us</span></h2>
                  </div>
               </div>
               <div class="col-md-10 offset-md-1">
                  <form id="request" class="main_form">
                     <div class="row">
                        <div class="col-md-12 ">
                           <input class="contactus" placeholder="Name" type="type" name=" Name"> 
                        </div>
                        <div class="col-md-12">
                           <input class="contactus" placeholder="Phone number" type="type" name="Phone Number">                          
                        </div>
                        <div class="col-md-12">
                           <input class="contactus" placeholder="Your Email" type="type" name="Email">                          
                        </div>
                        <div class="col-md-12">
                           <textarea class="textarea" placeholder="Message" type="type" Message="Name"></textarea>
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn">Submit Now</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
      
      
      <!-- contact -->
      <!--  footer -->
      <footer>
         <div class="footer">
            <div class="container">
               <div class="row">
                  <div class="col-lg-3 col-md-6 col-sm-6">
                     <div class="infoma text_align_left">
                        <h3>Choose.</h3>
                        <ul class="commodo">
                           <li>Commodo</li>
                           <li>consequat. Duis a</li>
                           <li>ute irure dolor</li>
                           <li>in reprehenderit </li>
                           <li>in voluptate </li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-4 col-md-6 col-sm-6">
                     <div class="infoma">
                        <h3>Get Support.</h3>
                        <ul class="conta">
                           <li><i class="fa fa-map-marker" aria-hidden="true"></i>Address : Loram Ipusm 
                           </li>
                           <li><i class="fa fa-phone" aria-hidden="true"></i>Call : +01 1234567890</li>
                           <li> <i class="fa fa-envelope" aria-hidden="true"></i><a href="Javascript:void(0)"> Email : demo@gmail.com</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-3 col-md-6 col-sm-6">
                     <div class="infoma">
                        <h3>Company.</h3>
                        <ul class="menu_footer">
                           <li><a href="index.html">Home</a></li>
                           <li><a href="about.html">About </a></li>
                           <li><a href="domain.html">Domain</a></li>
                           <li><a href="hosting.html">Hosting</a></li>
                           <li><a href="contact.html">Contact</a></li>
                        </ul>
                     </div>
                  </div>
                  <div class="col-lg-2 col-md-6 col-sm-6">
                     <div class="infoma text_align_left">
                        <h3>Services.</h3>
                        <ul class="commodo">
                           <li>Commodo</li>
                           <li>consequat. Duis a</li>
                           <li>ute irure dolor</li>
                           <li>in reprehenderit </li>
                           <li>in voluptate </li>
                        </ul>
                     </div>
                  </div>
               </div>
            </div>
            <div class="copyright">
               <div class="container">
                  <div class="row">
                     <div class="col-md-12">
                        <p>© 2020 All Rights Reserved. <a href="https://html.design/"> Free html Templates</a></p>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </footer>
      <!-- end footer -->
      <!-- Javascript files-->
      <script src="js/jquery.min.js"></script>
      <script src="js/bootstrap.bundle.min.js"></script>
      <!-- sidebar -->
      <script src="js/custom.js"></script>
   </body>
</html>