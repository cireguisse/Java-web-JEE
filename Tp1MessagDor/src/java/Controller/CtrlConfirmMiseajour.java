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
@WebServlet(name = "CtrlConfirmMiseajour", urlPatterns = {"/CtrlConfirmMiseajour"})
public class CtrlConfirmMiseajour extends HttpServlet {

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
        
        String msgModif,pseudmodif;
        msgModif= request.getParameter("message");
        pseudmodif=request.getParameter("pseudo");
        request.setAttribute("pseudo",pseudmodif);
        request.setAttribute("message", msgModif);
        RequestDispatcher resultdisp;
        String messageRetour;
        String Retourbien;
        if(!msgModif.isEmpty() && !pseudmodif.isEmpty()){
            try {
                HttpSession session= request.getSession(true);
                String Id= (String)session.getAttribute("indentifiant");
                int idmodif=Integer.parseInt(Id);
                MessageDor msgMAJ = new MessageDor(idmodif,pseudmodif,msgModif);
                Bd.modifierMsg(msgMAJ);
                Retourbien=" Votre message a été bien modifier merci à bientôt ";
                request.setAttribute("messagebienModif",Retourbien);            
                resultdisp =request.getRequestDispatcher("finmodifmsg");
                resultdisp.forward(request, response);
            } catch (Exception e) {
                messageRetour=" Desoler , Erreur survenue sur le serveur lors de la mise à jour";
                request.setAttribute("error_msg",messageRetour);
                resultdisp =request.getRequestDispatcher("confirmModiMsg");
                resultdisp.forward(request, response);

            }
        }
        else if(msgModif.isEmpty()&&pseudmodif.isEmpty()){
            messageRetour=" Desoler , Veuillez saisir le Message et le Pseudo";
            request.setAttribute("error_msg",messageRetour);
            resultdisp =request.getRequestDispatcher("confirmModiMsg");
            resultdisp.forward(request, response);

            
        }
        else{
            if(msgModif.isEmpty() && !pseudmodif.isEmpty()){
                messageRetour=" Desoler , veullez saisir le Message";
                request.setAttribute("error_msg",messageRetour);
                resultdisp =request.getRequestDispatcher("confirmModiMsg");
                resultdisp.forward(request, response);
            }
            else if (!msgModif.isEmpty() && pseudmodif.isEmpty()){
                messageRetour=" Desoler , veullez saisir le Pseudo";
                request.setAttribute("error_msg",messageRetour);
                resultdisp =request.getRequestDispatcher("confirmModiMsg");
                resultdisp.forward(request, response);
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
