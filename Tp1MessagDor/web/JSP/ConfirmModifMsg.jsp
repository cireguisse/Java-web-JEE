<%-- 
    Document   : ConfirmModifMsg
    Created on : 10 mars 2018, 14:44:57
    Author     : mamad
--%>

<%@page import="BD.Bd"%>
<%@page import="Metier.MessageDor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>modification confirmer</title>
    </head>
    <body>
        <div class="mr-3 ml-3 mt-3 alert alert-info" role="alert">
            <h3 class="text-center">Modifier un ou plusieurs message(s)</h3>
        </div>
        
        <form action="confirmMAJ" method="Get">
            <div class="ml-4 mr-4 mt-3 form-group">    
                 <div class="row form-group">
                    <div class="col-12 col-sm-12">
                        <table class="table table-bordered table-hover text-center">    
                            <%        String m;

                               m=(String)session.getAttribute("tempAttente");
                                try
                                {



                                    if(m !=null && request.getAttribute("error_msg") ==null )
                                    {
                                        MessageDor message=Bd.getMessageDor(m);
                                        out.print("<thead ><tr>"
                                                    +"<th scope=col>Numéro</th>"
                                                    + "<th scope=col>Texte</th>"
                                                    +"<th scope=col>Pseudo</th></tr>"
                                                +"</thead><tbody>"
                                                +"<tr>"
                                                    +"<td scope=col>"
                                                        +"<input disabled type=text class=text-center name=id value=\""+message.getId()+"\"/>"
                                                    +"</td>"
                                                    +"<td scope=col>"
                                                        +"<input type=text class=text-center name=message  value=\""+message.getMessage()+"\" /> "
                                                    +"</td>"
                                                    +"<td scope=col>"
                                                        +"<input type=text name=pseudo class=text-center  value=\""+message.getPseudo()+"\" /> "
                                                    +"</td>"
                                                +" </tr>"
                                                +"</tbody></table>");

                                          out.print("<button type=submit class= btn btn-success>Modifier le Message </button></form>");
                                    }
                                    if(request.getAttribute("error_msg") !=null)
                                    {

                                        String msg=(String)request.getAttribute("message");
                                        String pseudo=(String) request.getAttribute("pseudo");
                                        out.print("<thead>"
                                                    +"<tr>"
                                                        +"<th scope=col>Numéro</th>"
                                                        + "<th scope=col>Texte</th>"
                                                        +"<th scope=col>Pseudo</th>"
                                                    + "</tr>"
                                                    +"</thead><tbody>"
                                                    +"<tr class=>"
                                                    +"<td scope=col ><input disabled type=text name=id value=\""+m+"\"/></td>"

                                                    +"<td scope=col><input type=text name=message  value=\""+msg+"\" /> </td>"                           

                                                    +"<td scope=col><input type=text name=pseudo   value=\""+pseudo+"\" /> </td>"                  
                                                 +"/tr>");
                                        out.print("</tbody></table>");
                                          out.print("</div></div>"
                                                  +"<div class=ml-4 mr-4 mt-3 mb-3 form group>"
                                                    +"<div class=row form group>"                    
                                                        +"<div class=col-6 col-sm-4>"                
                                                            + "<button type=submit class=btn btn-secondary btn-lg mb-6  ml-4>Modifier le message</button>"
                                                        +"</div>"               
                                                    +"</div>"                
                                         +"</div> </fom>"
                                           +"<div class=mr-3>"
                                             +"<a class=ml-2 ins href=index>Accueil</a>"
                                             +"</div>");
                                    }



                                }
                                catch (Exception e)
                                {
                                        out.print("<div class=mr-3 ml-3 mt-3 alert alert-danger role=alert>");
                                        out.print("<h3 class=text-center>"+e.getMessage()+"</h3</div>");

                                }

                           %>
        <br>
         <%
            
              if((String)request.getAttribute("error_msg") !=null)
              {                 
                        out.println("<p class=message_erreur text-center>"+(String)request.getAttribute("error_msg")+"</p>");
                
              }
                
                String error_msg=(String)request.getAttribute("m");
                        
                if(error_msg !=null)
                {
                        out.println("<p class=message_erreur text-center>"+error_msg+"</p>");
                }
         %>  
        
    </body>
</html>
