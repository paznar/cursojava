<%-- 
    Document   : ExpressionLanguage
    Created on : Nov 25, 2014, 7:12:26 PM
    Author     : oracle
--%>

<%@page import="java.util.HashMap"%>
<%@page import="beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



<%
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
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplos Expression Language</title>
    </head>
    <body>
        <h1>Ejemplos Expression Language</h1>
        
        <ul>
            <li>${arrayPersonas[0].nombre} ${arrayPersonas[0].apellido}</li>
            
            
            <li>${mapaPersonas["marta.marquezdominio.com"].nombre} ${mapaPersonas["marta.marquezdominio.com"].apellido}</li>
            
            
            <li>${mapaPersonas.Elena.nombre} ${mapaPersonas.Elena.apellido}</li>
            
            <li>${variableNoExistente.nonbre.x + 1}</li>
            
        </ul>
        
    </body>
</html>
