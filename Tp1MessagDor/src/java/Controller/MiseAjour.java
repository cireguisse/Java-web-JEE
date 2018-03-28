/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mamad
 */
@WebServlet(name = "MiseAjour", urlPatterns = {"/MiseAjour"})
public class MiseAjour extends HttpServlet {

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
        String[] messageRecuper ;
        messageRecuper= request.getParameterValues("check");
        RequestDispatcher resultdisp;
        
        if(messageRecuper==null){
            /**
             * s'il ne selection rien , on se reourne sur la même page et on affiche un message en lui disant de selectionner 
             * un élement à modofier 
             */
            String msgRetour= "Desole, veulleiz selectionner un message à modifier !";
            request.setAttribute("retourMsg",msgRetour);
            resultdisp= request.getRequestDispatcher("modifMsg");
            resultdisp.forward(request, response);
        }
        else{
            /**
             * si l'utilisateur selection un message  à modifier , dans ce cas
             * on lui redirige vers la nouvelle page 
             */
            /**
             * d'abor je crée une session
             */
            HttpSession session= request.getSession(true);
            session.setAttribute("tempAttente",messageRecuper[0]);
            resultdisp= request.getRequestDispatcher("confirmModiMsg");
            resultdisp.forward(request, response);
            
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
