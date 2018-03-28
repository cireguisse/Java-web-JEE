package org.apache.jsp.JSP;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Metier.MessageDor;
import BD.Bd;

public final class ModiferMsg_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("         <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP first page tp1</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"ml-4 mr-4 mt-3 mb-3 form group\">\n");
      out.write("            <div class=\"row form group \">                    \n");
      out.write("                <div class=\"col-12 col-sm-12\">\n");
      out.write("                    <div class=\"alert alert-primary\" role=\"alert\">\n");
      out.write("                        <h3 class=\"text-center\">Lecture des message du livre D'or</h3><br>\n");
      out.write("                    </div>\n");
      out.write("                </div>               \n");
      out.write("            </div>                \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"ml-4 mr-4 mt-3 form-group\">\n");
      out.write("            <div class=\"row form-group\">\n");
      out.write("                <div class=\"col-12 col-sm-12\">\n");
      out.write("                   ");
 try{   
      out.write("\n");
      out.write("                   <table class=\"table table-bordered table-hover text-center\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                 \n");
      out.write("                                 <th scope=\"col\">Numéro</th>\n");
      out.write("                                 <th scope=\"col\">Text</th>\n");
      out.write("                                 <th scope=\"col\">Pseudo</th>\n");
      out.write("                                 <th scope=\"col\">Choisir</th>\n");
      out.write("\n");
      out.write("                            </tr>\n");
      out.write("                         </thead>\n");
      out.write("                       ");
  for (MessageDor m : Bd.lireMessage()) {  
      out.write("\n");
      out.write("                       <tr>\n");
      out.write("                           <td> ");
 out.println(m.getId());  
      out.write("</td>\n");
      out.write("                           <td>");
 out.println(m.getMessage());  
      out.write("</td>\n");
      out.write("                           <td>");
 out.println(m.getPseudo());  
      out.write("</td>\n");
      out.write("                           <td><input type=\"radio\"  name=\"suprimer\" value=\"");
 out.println(m.getId());  
      out.write("\"></td>\n");
      out.write("\n");
      out.write("                       </tr>\n");
      out.write("                       \n");
      out.write("                       ");
 } 
      out.write("\n");
      out.write("                       \n");
      out.write("                   </table>\n");
      out.write("                      \n");
      out.write("                  ");
 }catch (Exception e) {
                       out.println("BD.Bd.main() :"+e.getMessage());
                   }
      out.write("\n");
      out.write("                  \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("                \n");
      out.write("        </div>\n");
      out.write("        <div class=\"ml-4 mr-4 mt-4 form-group\">\n");
      out.write("            <label for=\"Message\"> <a href=\"index\">Accueil</a></label>\n");
      out.write("\n");
      out.write("            \n");
      out.write("        </div>    \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
