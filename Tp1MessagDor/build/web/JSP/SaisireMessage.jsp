<%-- 
    Document   : SaisireMessage
    Created on : 1 févr. 2018, 11:47:36
    Author     : 21708582
--%>

<%@page import="Metier.MessageDor"%>
<%@page import="BD.Bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page SaisirMessage</title>
    </head>
    <body>
        <%
            String m= (String) request.getAttribute("textMsg");
            String p= (String) request.getAttribute("pseudo");
         %>
        
         <%--
         si je saisir le information et je les redirige vers mon controleur Crtl.java dans le package Controller
         d'ont le nom logique est Controlleur j'e les e
         --%>
        
        <form   action="Controlleur" method="GET">
            <div class="ml-4 mr-4 mt-4 form group">
                 <div class="row form group ">                    
                    <div class="col-12 col-sm-12">
                        <div class="alert alert-primary" role="alert">
                            <h3 class="text-center">Merci de Saisir votre message</h3><br>
                        </div>
                    </div>               
                 </div>                
            </div>
            <div class="ml-4 mr-4 mt-4 form group">
                 <div class="row form group ">                    
                    <div class="col-12 col-sm-6">
                        <%--
                            je rucupere le code text ecrit dans le message et pseudo 
                            si l'un d'entre est null je conserve l'autre
                            --%>
                        <label for="Message">Message :</label>
                        <input type="text" class="form-control" name="textMsg"  id="textMsg" value="<%=m==null ?"":m %>"> </br> 
                       

                    </div>  
                    <div class="col-12 col-sm-6">
                        <label for="Message">Pseudo :</label>
                        <input type="text" class="form-control" name="Pseudo" id="Pseudo" value="<%=p==null ?"":p%>"> </br>        

                    </div> 
                    <div class="col-12 col-sm-6">
                        <input type="submit" class="form-control btn btn-outline-primary" value="Enregistrer le me message" name="EnMsg" > </br>  

                    </div>
                 </div>                
            </div>
        </form>
        <div class="ml-4 mr-4 mt-4 form-group">
            <%
                /**
                 * s'il l'un des champs est vide on affiche un message de saisir l'information
                 */
                String error= (String)request.getAttribute("champsVide");
                if(error!=null){
                    out.println("<h3>"+error+"</h3>");
                }
            %>
        </div>    
            <%--
            retour a l'acceuil
            --%>
        <div class="ml-4 mr-4 mt-4 form-group">
            <label for="Message"> <a href="index">Accueil</a></label>

            
        </div>
    </body>
</html>
