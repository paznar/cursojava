<%-- 
    Document   : JspUseBean
    Created on : 24-ene-2012, 23:48:53
    Author     : Usuario
--%>

<%@page import="beans.Persona"%>
<%


    Persona persona1 = new Persona("Nombre request","Apellido request");
    request.setAttribute("persona", persona1);
    
    Persona persona2 = new Persona("Nombre sesion","Apellido sesion");
    request.getSession().setAttribute("persona", persona2);
    
    Persona persona3 = new Persona("Nombre aplicacion","Apellido aplicacion");
    request.getServletContext().setAttribute("persona", persona3);

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="persona"  scope="session"  class="beans.Persona"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejemplo de jsp:usebean</h1>
        
        <jsp:setProperty name="persona" property="*" />
        <br>
        Get property
        <br>
        <br>
        <jsp:getProperty name="persona" property="nombre" />
        <jsp:getProperty name="persona" property="apellido" />
        <br>
        <br>
        Expresiones JSP
        <br><br>
        <%= persona.getNombre() %>
        <%= persona.getApellido() %>
        <br>
        Expresion de lenguaje
        <br><br>
        ${persona.nombre}
        ${persona.apellido}
        <br><br>
        
        ${sessionScope.persona.nombre}
        ${sessionScope.apellido}
        
        <br>
        <c:get target="${persona}" property="nombre"/>
        <c:get target="${persona}" property="apellido"/>
    </body>
</html>
