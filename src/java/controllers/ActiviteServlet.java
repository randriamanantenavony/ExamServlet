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
import models.Activite;
import models.Administrateur;

/**
 *
 * @author SAROBIDY
 */
@WebServlet(name = "ActiviteServlet", urlPatterns = {"/ActiviteServlet"})
public class ActiviteServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            
            
            if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("d")){
        
         int id = Integer.parseInt(request.getParameter("value"));
        Activite activite = new Activite(id);
         activite.delete();
          response.sendRedirect("ListActiviteServlet");
        }
        
        else if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("u")){
        
         int id = Integer.parseInt(request.getParameter("value"));
         request.setAttribute("id", id);
         
          RequestDispatcher dispatcher = request.getRequestDispatcher("updateActivite.jsp");
           dispatcher.forward(request, response);
         
        }
        
        else if(request.getParameter("action") != null && request.getParameter("action").equalsIgnoreCase("update"))
        {
         String nom = request.getParameter("nom");
         String desc = request.getParameter("desc");
         
         int id = Integer.parseInt(request.getParameter("id"));
         
          
         Activite admin = new Activite(id,nom,desc);
         
         admin.modifierActivite();
       
                 
          response.sendRedirect("ListActiviteServlet");
        }
            
            else{
              
               String nom = request.getParameter("nom");
              
               String desc = request.getParameter("desc");
               

               Activite categorie = new Activite(nom,desc);

               categorie.insererActivity();
               
               response.sendRedirect("ListActiviteServlet");

               
            }
            
           
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
            Logger.getLogger(ActiviteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActiviteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
