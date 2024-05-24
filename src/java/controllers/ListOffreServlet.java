/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.OffreVoyage;
import models.Offre;
import models.Voyage;

/**
 *
 * @author SAROBIDY
 */
@WebServlet(name = "ListOffreServlet", urlPatterns = {"/ListOffreServlet"})
public class ListOffreServlet extends HttpServlet {

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
      
           String[] activitesSelectionnees = request.getParameterValues("activities[]");
    
          String selectedCategoryId = request.getParameter("category");
          String destination = request.getParameter("destination");
          
          String startDateString = request.getParameter("start_date");
          
        
          String endDateString = request.getParameter("end_date");
          
           String description = request.getParameter("description");
           String prix = request.getParameter("price");
           
           Offre offre = new Offre(destination,startDateString,endDateString,description,prix,selectedCategoryId);
           
           int idVoyage = offre.insererOffre();
           
           
          for(String activity :activitesSelectionnees )
           {
             OffreVoyage activiteVoyage = new OffreVoyage(String.valueOf(idVoyage),activity);
             activiteVoyage.insererOffre();
             
           }
          
            
           
             response.sendRedirect("OffreServlet");
        
    
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
            Logger.getLogger(ListOffreServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ListOffreServlet.class.getName()).log(Level.SEVERE, null, ex);
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
