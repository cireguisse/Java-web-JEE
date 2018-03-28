/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Bd;
import Metier.MessageDor;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 21708582
 */
public class Ctrl extends HttpServlet {

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
                
        String textMsg= request.getParameter("textMsg");
        String pseudo = request.getParameter("Pseudo");
        //message afficher a la sorti 
        String rester_sur_page;
        
        if(textMsg.isEmpty() && pseudo.isEmpty()){
            rester_sur_page="Desoler ,il faut remplire les champs";
           request.setAttribute("champsVide",rester_sur_page);
           RequestDispatcher r= request.getRequestDispatcher("saisir_mon_message");
           r.forward(request, response);
        }
        /**
         * si le champ de text est vide dans ,ce cas 
         */
        if(textMsg.isEmpty()){
            rester_sur_page="Desoler ,il faut remplire le Text";
            request.setAttribute("champsVide",rester_sur_page);
            RequestDispatcher r= request.getRequestDispatcher("saisir_mon_message");
            r.forward(request, response);
            
        }
        /**
         * Si le speudo est vide ,on conserve le champs du text et on dit a l'utilisateur de resaisir 
         */
        if(pseudo.isEmpty()){
            rester_sur_page="Desoler ,il faut remplire le Pseudo";
            request.setAttribute("champsVide",rester_sur_page);
            RequestDispatcher r= request.getRequestDispatcher("saisir_mon_message");
            r.forward(request, response);
        }
        try {
            MessageDor addMessageDor = new MessageDor(textMsg,pseudo);
            Bd.saisireMessage(addMessageDor);
            RequestDispatcher r= request.getRequestDispatcher("saisir_mon_message");
            r.forward(request, response);            
        } catch (Exception e) {
       
            request.setAttribute("champsVide",e.getMessage());
            RequestDispatcher r= request.getRequestDispatcher("saisir_mon_message");
            r.forward(request, response);
            
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
