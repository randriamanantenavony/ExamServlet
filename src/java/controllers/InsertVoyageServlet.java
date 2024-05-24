package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Activite;
import models.ActiviteVoyage;
import models.Administrateur;
import models.Categorie;
import models.Destination;
import models.ViewModel;
import models.Voyage;

/**
 *
 * @author SAROBIDY
 */
@WebServlet(urlPatterns = {"/InsertVoyageServlet"})
public class InsertVoyageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        
        
        
          if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("d")){
        
         int id = Integer.parseInt(request.getParameter("value"));
        Voyage voyage = new Voyage(id);
         voyage.supprimerVoyage(id);
         
           response.sendRedirect("VoyageServlet");
         
        }
        
        else if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("u")){
        
         int id = Integer.parseInt(request.getParameter("value"));
          List<Categorie> categories = Categorie.recupererCategories();
            List<Activite> activites = Activite.recupererActivite();
            List<Destination> destination = Destination.recupererDestination();
         
            
            ViewModel view = new ViewModel(activites,categories,destination);
            
            request.setAttribute("liste", view);
            request.setAttribute("id", id);
         
          RequestDispatcher dispatcher = request.getRequestDispatcher("updateVoyage.jsp");
           dispatcher.forward(request, response);
         
        }
        
        else if(request.getParameter("action")!= null && request.getParameter("action").equalsIgnoreCase("update"))
        {
           
          String[] activitesSelectionnees = request.getParameterValues("activities[]");
      
          System.out.println("activite");
          
          String selectedCategoryId = request.getParameter("category");
          
     
          String destination = request.getParameter("destination");
           
          
          String startDateString = request.getParameter("start_date");
          
       
          String endDateString = request.getParameter("end_date");
         
            
           String description = request.getParameter("description");
           
           
             
           String prix = request.getParameter("price");
           
           
           String idVoyage = request.getParameter("id");
           
           Voyage voyage = new Voyage(idVoyage,destination,startDateString,endDateString,description,prix,selectedCategoryId);
           
         voyage.modifierVoyage();
           
           for(String activity :activitesSelectionnees )
           {
             ActiviteVoyage activiteVoyage = new ActiviteVoyage(Integer.parseInt(idVoyage),Integer.parseInt(activity));
             activiteVoyage.modifierActiviteVoyage();
             
           }
           
             response.sendRedirect("VoyageServlet");
        }
        
        else{
            
         String[] activitesSelectionnees = request.getParameterValues("activities[]");
    
          String selectedCategoryId = request.getParameter("category");
          String destination = request.getParameter("destination");
          
          String startDateString = request.getParameter("start_date");
          
        
          String endDateString = request.getParameter("end_date");
          
           String description = request.getParameter("description");
           String prix = request.getParameter("price");
           
           Voyage voyage = new Voyage(destination,startDateString,endDateString,description,prix,selectedCategoryId);
           
           int idVoyage = voyage.insererVoyage();
           
           for(String activity :activitesSelectionnees )
           {
             ActiviteVoyage activiteVoyage = new ActiviteVoyage(idVoyage,Integer.parseInt(activity));
             activiteVoyage.insererActivity();
             
           }
           
             response.sendRedirect("VoyageServlet");
        }
           
                 
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertVoyageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertVoyageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
