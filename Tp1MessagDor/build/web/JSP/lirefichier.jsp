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
        <title>Lecture Message Dor</title>
    </head>
    <body>
        <div class="ml-4 mr-4 mt-3 mb-3 form group">
            <div class="row form group ">                    
                <div class="col-12 col-sm-12">
                    <div class="alert alert-primary" role="alert">
                        <h3 class="text-center">Lecture des message du livre D'or</h3><br>
                    </div>
                </div>               
            </div>                
        </div>
        
        <div class="ml-4 mr-4 mt-3 form-group">
            <div class="row form-group">
                <div class="col-12 col-sm-12">
                   <% try{
                       /**
                        * je crée une arraylist dans le quel je stock le n-uplet que j'ai recuperer dans mon Bd.java
                        * avec la methode lireMessage()
                        * je verifie s'il existe au une ligne dans ma Bd j'affiche
                        * dans le cas contraitre j'affiche une information a l'utilisateur que ma Bd est vide 
                        */
                       ArrayList <MessageDor> listeMessage=Bd.lireMessage();
                        listeMessage=Bd.lireMessage();
                        if(listeMessage.size()!=0){
                            
                        
                   %>
                   <table class="table table-bordered table-hover text-center">
                        <thead>
                            <tr>                              
                                
                                 <th scope="col">Text</th>
                                 <th scope="col">Pseudo</th>
                            </tr>
                         </thead>
                       <%  for (MessageDor m : Bd.lireMessage()) {  %>
                       <tr>
                           
                           <td><% out.println(m.getMessage());  %></td>
                           <td><% out.println(m.getPseudo());  %></td>

                       </tr>
                       
                       <% }}
                        else{ %>
                            <div class="ml-4 mr-4 mt-4 form-group">
                            <label for="Message"> <a href="index">Accueil</a></label>

            
                             </div>    
                      <%
                        }
                       %>
                       
                   </table>
                      
                  <% }catch (Exception e) {
                    /**
                     * s'il y'a une erreu pour l'acces à la Bd j'affiche l'information
                     */
                        out.println("<p class=text-center> BD.Bd.main() :"+e.getMessage()+"</p>");
                   }%>
                  
                </div>
            </div>
                
        </div>
            
            
            
            
    </body>
</html>
