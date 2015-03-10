<%-- 
    Document   : CustomTags
    Created on : Nov 25, 2014, 8:33:23 PM
    Author     : oracle
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="beans.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>






<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<%
    Persona persona = new Persona();
    
    request.setAttribute("persona", persona);

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
        <title>Ejemplo etiquetas JSP</title>
    </head>
    <body>
        <h1>Ejemplo etiquetas JSP</h1>
    
        <h2>Ejemplo de c:if</h2>
    <ul>
        <c:if test="${not empty arrayPersonas}" var="resultadoIf" scope="request">
            <h3>Procesando arrayList con c:forEach</h3>
            <c:forEach var="persona" items="${arrayPersonas}">
                <li>${persona.nombre} ${persona.apellido}</li>
            </c:forEach>
        </c:if>
            <h3>Leyendo el valor devuelto por c:if (almacenado en request)</h3>
            ${requestScope.resultadoIf}
    </ul>
    
    
    
   
            <h2>Ejemplos de bucle for c:forEach</h2>
    <ul>
        
            <c:forEach varStatus="status"
                       begin="0" end="3" step="1">
                <li>
                    valor <c:out value="${status.count}" />
                    <c:if test="${status.first}">(Este es el primer valor)</c:if>
                    <c:if test="${status.last}">(Este es el ultimo valor)</c:if>
                 
                    
                 </li>
            </c:forEach>
    </ul>
             <h2>Ejemplos de procesamiento de arrayList con c:forEach</h2>
    <ul>
        
            <c:forEach var="persona" items="${arrayPersonas}" varStatus="status"
                       begin="0" end="3" step="1">
                <li>
                    valor <c:out value="${status.count}" />
                    <c:if test="${status.first}">(Este es el primer valor)</c:if>
                    <c:if test="${status.last}">(Este es el ultimo valor)</c:if>
                 
                    <ul><li>${persona.nombre} ${persona.apellido}</li></ul>
                 </li>
            </c:forEach>
    </ul>
    
    
     
    <h2>Ejemplos de c:set</h2>
    <ul>
        <li>Creación de variables</li>
        <c:set var="variable" value="valor de la variable escrita con c:set en ambito por defecto (Page)"/> 
        <ul><li>${pageScope.variable}</li></ul>
    
        
        <c:set var="variable2" scope="request"> 
            valor de la variable2 escrita con c:set en request 
        </c:set>
        <ul><li>${variable2}</li></ul>
        
        <li>Escritura de valores en java beans</li>
        <c:set target="${persona}" property="nombre" value="Nuevo nombre cambiado con c:set"/> 
        <ul><li>${persona.nombre}</li></ul>
        
        <li>Escritura de valores en arrays</li>
        <c:set target="${arrayPersonas[0]}" property="nombre" value="Nuevo nombre cambiado en arrayPersonas con c:set"/> 
        <ul><li>${arrayPersonas[0].nombre}</li></ul>
        
        
        <li>Escritura de valores en mapas</li>
         <c:set target="${mapaPersonas['Elena']}" property="nombre" value="Otro nuevo nombre cambiado en mapaPersonas con c:set"/> 
        <ul><li>${mapaPersonas["Elena"].nombre}</li></ul>
        
    </ul>
        
        
    
    <h2>Ejemplos de c:url</h2>
    <ul>
        <li>Creación de urls con soporte de sesiones (es necesario borrar la cookie del navegador)</li>
        <c:url value="JspUseBean.jsp" var="urlGenerada"/> 
        <ul><li>${urlGenerada}</li></ul>
    </ul>
        
    
    <c:set var="test" scope="session">
        <table border="5">
        Ejemplo de c:out con/sin escapeXml
            <tr>
                <td bgcolor="green">Valor1</td>

                <td bgcolor="red">Valor2</td>
            </tr>

            <tr>
                <td bgcolor="gray">Valor3</td>

                <td bgcolor="yellow">Valor4</td>
            </tr>
        </table>
    </c:set>

    <h3>out sin escapeXml=false</h3>
    <c:out value="${test}" escapeXml="true" /><br>
    <h3>out con escapeXml=false</h3>
    <c:out value="${test}" escapeXml="false" />
    <br />
    
    
    </body>
    
    
    Ejemplo de c:out con valor por defecto
    <c:out value="${variableFicticia}">Variable sin valor (valor por defecto)</c:out>
</html>
