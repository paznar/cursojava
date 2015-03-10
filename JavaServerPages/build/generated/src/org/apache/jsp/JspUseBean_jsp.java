package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import beans.Persona;

public final class JspUseBean_jsp extends org.apache.jasper.runtime.HttpJspBase
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



    Persona persona1 = new Persona("Nombre request","Apellido request");
    request.setAttribute("persona", persona1);
    
    Persona persona2 = new Persona("Nombre sesion","Apellido sesion");
    request.getSession().setAttribute("persona", persona2);
    
    Persona persona3 = new Persona("Nombre aplicacion","Apellido aplicacion");
    request.getServletContext().setAttribute("persona", persona3);


      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      beans.Persona persona = null;
      synchronized (session) {
        persona = (beans.Persona) _jspx_page_context.getAttribute("persona", PageContext.SESSION_SCOPE);
        if (persona == null){
          persona = new beans.Persona();
          _jspx_page_context.setAttribute("persona", persona, PageContext.SESSION_SCOPE);
        }
      }
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Ejemplo de jsp:usebean</h1>\n");
      out.write("        \n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.introspect(_jspx_page_context.findAttribute("persona"), request);
      out.write("\n");
      out.write("        <br>\n");
      out.write("        Get property\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.Persona)_jspx_page_context.findAttribute("persona")).getNombre())));
      out.write("\n");
      out.write("        ");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((beans.Persona)_jspx_page_context.findAttribute("persona")).getApellido())));
      out.write("\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        Expresiones JSP\n");
      out.write("        <br><br>\n");
      out.write("        ");
      out.print( persona.getNombre() );
      out.write("\n");
      out.write("        ");
      out.print( persona.getApellido() );
      out.write("\n");
      out.write("        <br>\n");
      out.write("        Expresion de lenguaje\n");
      out.write("        <br><br>\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${persona.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${persona.apellido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        <br><br>\n");
      out.write("        \n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.persona.nombre}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.apellido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        <c:get target=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${persona}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" property=\"nombre\"/>\n");
      out.write("        <c:get target=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${persona}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" property=\"apellido\"/>\n");
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
