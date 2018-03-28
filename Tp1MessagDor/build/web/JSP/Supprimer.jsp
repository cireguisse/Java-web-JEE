<%-- 
    Document   : lirefichier
    Created on : 25 janv. 2018, 12:07:32
    Author     : 21708582
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Metier.MessageDor"%>
<%@page import="BD.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP first page tp1</title>
    </head>
    <body>
        <div class="ml-4 mr-4 mt-4 form group">
            <div class="row form group ">                    
                <div class="col-12 col-sm-12">
                    <div class="alert alert-primary" role="alert">
                        <h3 class="text-center">Selectionner les Message à Supprimer</h3><br>
                    </div>
                </div>               
            </div>                
        </div>
    <form  action="ctrlsup" method="GET">
                
        <table class="table table-bordered ml-3 mr-4 mt-4 form group">
            
                <%
                    /*
                        On affiche les numéros des messages supprimés
                    */
                   ArrayList<String> message=(ArrayList<String>) session.getAttribute("message");
                   if (message !=null)
                   {
                         String ok=(String) request.getAttribute("listSuppr");
                         if(ok=="true")
                         {
                             for(String m: message)
                             {
                                 out.println("<h5>"+m+" : suppression réussie </h5>");
                             }
                             out.print("<br>");
                             session.setAttribute("message",null);
                         }
                         
                   }
                    try
                    {
                        /**
                         * l'affichage des message ,on peut selectionner plusieur message 
                         * a supprimer
                         */
                        ArrayList <MessageDor> listeMessage=Bd.lireMessage();
                        listeMessage=Bd.lireMessage();
                        if(listeMessage.size()!=0)
                        {
                            /*
                                On affiche l'entête du tableau lorsqu'il y a au moins un message dans la base de données
                            */
                            out.print("<thead><tr><th scope=col>Choisir</th>");
                            out.print("<th scope=col>Numéro</th><th scope=col>Texte</th>");
                            out.print("<th scope=col>Pseudo</th></tr>");
                            out.print("</thead><tbody>");
                        }
                        for(MessageDor m: listeMessage)
                        {
                            
                            out.print("<tr>");
                            out.print("<td scope=col>");
                            int numerocase=m.getId();
                            String val=""+numerocase;
                            if(message !=null)
                            {
                                if(message.contains(val))
                                {
                                    /*
                                        On garde cochée la case que l'utilisateur avait déjà saisie
                                    */
                                    out.print("<input class=ml-5 form-check-input type=checkbox  name=check value=\""+numerocase+"\" checked/>");
                                    session.setAttribute("message",null);
                                }
                                else
                                {
                                     out.print("<input class=ml-5 form-check-input type=checkbox  name=check value=\""+numerocase+"\"/>");
                                     session.setAttribute("message",null);
                                }
                            }
                            else
                            {
                                 out.print("<input class=ml-5 form-check-input type=checkbox  name=check value=\""+numerocase+"\"/>");
                            }
                           
                            
                            out.print("</td>");
                            out.print("<td scope=col>");
                            out.print(numerocase);
                            out.print("</td>");
                            out.print("<td scope=col>");
                            out.print(m.getMessage());
                            out.print("</td>");
                            out.print("<td scope=col>");
                            out.print(m.getPseudo());
                            out.println("</td> </tr>");
                            
                        }
                        if(listeMessage.size()!=0)
                        {
                               out.print("</tbody></table>"
                                            + "<button type=submit class=btn btn-secondary btn-lg mb-6  ml-4>Supprimer</button>"
                                       + "</form>");
                        }
                        else
                        {
                %>
                            <div class="card text-center mt-3 ml-3 mr-3">
                                <div class="card-header">
                                  
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title"></h5>
                                  <p class="card-text">Pas de Message à supprimer </p>
                                </div>
                                <div class="card-footer text-muted">
                                    Copyright © 2018 <a href="#" >Guisse mamadou cire</a>. Tous droits réservés.
                                </div>
                            </div>
                            
                <%
                        }
                    }
                    catch (Exception e)
                    {
                        out.println("<p class=text-center> BD.Bd.main() :"+e.getMessage()+"</p>");

                    }
               %>         
        </div>
        <br>       
         <%
             /**
              * affichage d'un message Erreur si l'utilisateur ne saisir rien 
              */
                String message_erreur=(String)request.getAttribute("m");
                if(message_erreur !=null)
                {
                    out.println("<p class= text-center>"+message_erreur+"</p>");
                }
         %>  
        </div>
        <div class="mr-3">
            <a class="ml-2 ins" href="index">Accueil</a>
        </div>
               
    </body>
</html>
