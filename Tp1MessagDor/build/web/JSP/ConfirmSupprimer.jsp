<%-- 
    Document   : ConfirmSupprimer
    Created on : 15 févr. 2018, 12:20:20
    Author     : guisse
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div class="card mt-4 mr-4 ml-4 mb-3">
            <div class="card-header text-center">
              Confirmer la Suppression de(s) message (s)  
            </div>
            <div class="card-body mt-3 mr-3 ml-3 ">
                
                <form action="confirmSup" method="GET">
                    <%
                         ArrayList<String> messageSup=(ArrayList<String>) session.getAttribute("message");
                        out.print("<p>");
                        /**
                         * verification si la liste est vide avant la supression
                         */
                        if(!messageSup.isEmpty())
                        {
                            /**
                             * affichage des element a supprimer 
                             */
                            out.println("<p class=text-center > Voulez-vous supprimer les messages ?");
                            Iterator<String> itr = messageSup.iterator();
                            while (itr.hasNext())
                            {
                              String element = itr.next();
                              out.print("<p class=text-center> "+element+" </p>");                   }    
                        }
                        out.print("</p>");
                     %>
                     <p class="text-center">  cliquez sur  <a href="confirmSup"> oui </a> sinon cliquez sur  <a href="listSuppr">  Non </a></p>

                </form>
                     <p > <a href="index"> Retour Accueil</a></p>             
            </div>
            <div class="card-footer text-muted">
                Copyright © 2018 <a href="#" >Guisse mamadou cire</a>. Tous droits réservés.
            </div>
        </div>
        
        
    </body>
</html>
