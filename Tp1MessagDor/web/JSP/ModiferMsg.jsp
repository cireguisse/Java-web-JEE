<%-- 
    Document   : lirefichier
    Created on : 25 janv. 2018, 12:07:32
    Author     : 21708582
--%>

<%@page import="java.util.HashSet"%>
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
        <title>Modifer Un Message D'or</title>
    </head>
    <body>
        <div class="ml-4 mr-4 mt-3 mb-3 form group">
            <div class="row form group ">                    
                <div class="col-12 col-sm-12">
                    <div class="alert alert-primary" role="alert">
                        <h3 class="text-center">Modifer un message du livre D'or</h3><br>
                    </div>
                </div>               
            </div>                
        </div>
        <form action="ctrlmodifMsg" mehtod="GET">
            
            <div class="ml-4 mr-4 mt-3 form-group">
                <div class="row form-group">
                    <div class="col-12 col-sm-12">
                        <table class="table table-bordered table-hover text-center">
                       <% try{ 
                           
                            session.removeAttribute("tempAttente");
                            MessageDor Msgdor;
                            Msgdor=(MessageDor) request.getAttribute("messageDor");
                            
                            if(Msgdor!=null){
                                if(Bd.getMessageDor(Msgdor.getId()+"").getMessage().equals(Msgdor.getMessage()) && Bd.getMessageDor(Msgdor.getId()+"").getPseudo().equals(Msgdor.getPseudo()))
                                {
                                     out.print("<div class=mr-3 ml-3 mt-3 alert alert-danger role=alert>");
                                     out.print("<h3 class=ml-3>"+Msgdor.getId()+": aucune modification effectuée"+"</h3</div>");
                                }
                                else
                                {
                                     Bd.modifierMsg(Msgdor);

                                     out.print("<div class=mr-3 ml-3 mt-3 alert alert-danger role=alert>");
                                     out.print("<h3 class=ml-3>"+Msgdor.getId()+":  modification effectuée"+"</h3</div>");
                                }
                            }
                            ArrayList<MessageDor> listMsg=Bd.lireMessage();
                            if(!listMsg.isEmpty()){
                                out.print(" <thead>"
                                +"<tr>"

                                     +"<th scope=col>Numéro</th>"
                                     +"<th scope=col>Text</th>"
                                     +"<th scope=col>Pseudo</th>"
                                     +"<th scope=col>Choisir</th>"
                                +"</tr>"
                                +"</thead>");
                                for (MessageDor m : Bd.lireMessage()) { 
                                    out.print("<tr>"
                                        +"<td>"+m.getId()+"</td>"
                                        +"<td>"+m.getMessage()+"</td>"
                                        +"<td>"+m.getPseudo()+"</td>"
                                       +" <td><input type=radio  name=check value="+m.getId()+"></td>"
                                    +"</tr>");

                                }
                                out.print("</table></div></div></div>");
                                out.print("<div class=ml-4 mr-4 mt-3 mb-3 form group>"
                                            +"<div class=row form group>"                    
                                                +"<div class=col-6 col-sm-4>"                
                                                    + "<button type=submit class=btn btn-secondary btn-lg mb-6  ml-4>Modifier</button>"
                                                +"</div>"               
                                            +"</div>"                
                                        +"</div> </fom>"
                                           +"<div class=mr-3 mb-4>"
                                             +"<a class=ml-2 ins href=index>Accueil</a>"
                                             +"</div>");
                                
                            }
                            else{
                                out.print("<div class=alert  alert-info role=alert>"                                              
                                            + "<p class=text-center >Desloer, Vous n'avez aucun message a modifer </p>"
                                            +"Retour à la page d'accueil cliquez <label for=Message> <a href=index> ici</a></label>"
                                           +"</div>");
                            }
                        }catch (Exception e) {
                         out.println("<p class=text-center> BD.Bd.main() :"+e.getMessage()+"</p>");
                       }%>
         </div>
        </div>
    </body>
    
</html>
