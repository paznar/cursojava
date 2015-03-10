package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.HashMap;
import beans.Persona;

public final class ExpressionLanguage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    Persona[] arrayPersonas = new Persona[3];
    
    arrayPersonas[0]= new Persona("Jorge","Gimenez");
    arrayPersonas[1]= new Persona("Marta","Marquez");
    arrayPersonas[2]= new Persona("Elena","Gomez");
    
    request.setAttribute("arrayPersonas", arrayPersonas);
    
    HashMap mapaPersonas = new HashMap();
    mapaPersonas.put("jorge.gimenez@dominio.com", arrayPersonas[0]);
    mapaPersonas.put("marta.marquezdominio.com", arrayPersonas[1]);
    mapaPersonas.put("Elena", arrayPersonas[2]);
    
    request.setAttribute("mapaPersonas", mapaPersonas);

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Ejemplos Expression Language</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Ejemplos Expression Language</h1>\n");
      out.write("        \n");
      out.write("        <ul>\n");
      out.write("            <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${arrayPersonas[0].nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${arrayPersonas[0].apellido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mapaPersonas[\"marta.marquezdominio.com\"].nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mapaPersonas[\"marta.marquezdominio.com\"].apellido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mapaPersonas.Elena.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mapaPersonas.Elena.apellido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("            \n");
      out.write("            <li>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${variableNoExistente.nonbre.x + 1}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</li>\n");
      out.write("            \n");
      out.write("        </ul>\n");
      out.write("        \n");
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
