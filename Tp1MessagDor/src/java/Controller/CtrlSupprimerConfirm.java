/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import BD.Bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "CtrlSupprimerConfirm", urlPatterns = {"/CtrlSupprimerConfirm"})
public class CtrlSupprimerConfirm extends HttpServlet {

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
         HttpSession session=request.getSession(true);
            RequestDispatcher rd;
            
            try
            {
                    ArrayList<String> messageSupBd=(ArrayList<String>) session.getAttribute("message");
                    Bd.effacerMessage(messageSupBd);

                   /* for(String m: messageSupBd)
                    {
                            Bd.effacerMessage(m);
                    }
                     Iterator<String> itr = messageSupBd.iterator();
                            while (itr.hasNext())
                            {
                              String element = itr.next();
                        }*/
                    String ok="true";
                    request.setAttribute("suppression",ok);
                    rd = request.getRequestDispatcher("listSuppr");
                    rd.forward(request, response);
            }
            catch (Exception e)
            {
                    request.setAttribute("msg_erreur", e.getMessage());
                    rd = request.getRequestDispatcher("confirmSup");
                    rd.forward(request, response);
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
