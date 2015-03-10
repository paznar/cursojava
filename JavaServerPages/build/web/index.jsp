<%-- 
    Document   : index
    Created on : 24-ene-2012, 23:17:49
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina JSP</title>
    </head>
    <body>
        <h1>Hola Mundo!</h1>
        
        <%-- Ejemplos de declaraciones --%>
        
        <%! String variable1 = "Valor1"; %>
        <%! String variable2 = "Valor2"; %>
        
        <%-- Ejemplos de expresiones --%>
        
        <table>
            <tr>
                <td>Valor de la variable 1: </td>
                <td><b><%= variable1 %></b></td>
            </tr>           
            <tr>
                <td>Valor de la variable 2: </td>
                <td><b><%= variable2 %></b></td>
            </tr>
        </table>
            
        <%-- Ejemplo de scriptlet --%>
        
        <% if(variable1=="Valor1") {out.println("<font color=red>" + "La sentencia IF devuelve TRUE"+ "</font>");}%>
        
        
        
        
        <jsp:include page="footer.jsp"/>
        
        
        <!-- comentario html visible en el codigo fuente del documento html --> 
        <%-- comentario jsp que solo se ve en el documento jsp --%> 
        <%// comentario de linea Java visible en el documento jsp y en su servlet asociado %> 
        <% /*comentario multilínea Java visible en el documento jsp y en su servlet asociado*/%>
        
    </body>
</html>
