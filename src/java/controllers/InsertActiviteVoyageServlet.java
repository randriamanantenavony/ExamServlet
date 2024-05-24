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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.ActiviteVoyage;

/**
 *
 * @author SAROBIDY
 */
@WebServlet(name = "InsertActiviteVoyageServlet", urlPatterns = {"/InsertActiviteVoyageServlet"})
public class InsertActiviteVoyageServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
             
         if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("d")){
        
         int id = Integer.parseInt(request.getParameter("value"));
         ActiviteVoyage a = new ActiviteVoyage(id);
         a.supprimerActiviteVoyage();
         
         
          response.sendRedirect("ActiviteVoyageServlet");  
         
        }
        
        else if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("u")){
        
         int id = Integer.parseInt(request.getParameter("value"));
         request.setAttribute("id", id);
         
          RequestDispatcher dispatcher = request.getRequestDispatcher("updateActivitevoyage.jsp");
           dispatcher.forward(request, response);
         
        }
        
        else if(request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("update"))
        {
         int id = Integer.parseInt(request.getParameter("id"));
      
         
         String[] voyageSelectionnees = request.getParameterValues("activities[]");
         String idV  = request.getParameter("id");
         
         System.out.println(idV);
         for(String s: voyageSelectionnees)
         {
           
               ActiviteVoyage activite = new ActiviteVoyage(id,Integer.parseInt(idV),Integer.parseInt(s));
               
               activite.modifierActiviteVoyage();
         }
       
         response.sendRedirect("ActiviteVoyageServlet");
       
        }
        
        else{
          

        String[] voyageSelectionnees = request.getParameterValues("activities[]");
         String idV  = (String) request.getParameter("idV");
         
         for(String s: voyageSelectionnees)
         {
               ActiviteVoyage activite = new ActiviteVoyage(Integer.parseInt(idV),Integer.parseInt(s));
               
               activite.insererActivity();
         }
       
         
          response.sendRedirect("ActiviteVoyageServlet");  
    }
        
            
        } catch (Exception ex) {
            Logger.getLogger(InsertActiviteVoyageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
