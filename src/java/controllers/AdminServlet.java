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
import models.Administrateur;

/**
 *
 * @author itu
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

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
         Administrateur admin = new Administrateur(id);
         
           admin.delete(); 
           System.out.println("Mode delete");
        
         
          response.sendRedirect("ListAdminServlet"); 
        }
        
        else if(request.getParameter("mode") != null && request.getParameter("mode").equalsIgnoreCase("u")){
        
            System.out.println("Mode update");
         int id = Integer.parseInt(request.getParameter("value"));
         request.setAttribute("id", id);
         
          RequestDispatcher dispatcher = request.getRequestDispatcher("updateAdmin.jsp");
           dispatcher.forward(request, response);
         
        }
        
       else if(request.getParameter("action").equalsIgnoreCase("update"))
        {
         String nom = request.getParameter("nom");
         String mail = request.getParameter("email");
         String mdp = request.getParameter("mdp");
         int id = Integer.parseInt(request.getParameter("id"));
         
         Administrateur admin = new Administrateur(id,nom,mail,mdp);
         
         admin.update();
         
            response.sendRedirect("ListAdminServlet"); 
        } 
        
        else{
          

         String nom = request.getParameter("nom");
         String mail = request.getParameter("email");
         String mdp = request.getParameter("mdp");
         
         Administrateur admin = new Administrateur(nom,mail,mdp);
         
         admin.save();
         
            response.sendRedirect("ListAdminServlet"); 
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminServlet.class.getName()).log(Level.SEVERE, null, ex);
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
