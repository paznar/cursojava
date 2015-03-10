<%-- 
    Document   : AllCustomers
    Created on : 10-mar-2015, 16:52:04
    Author     : Hyaku Nin Giri
--%>

<%@page import="trader.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Customers</title>
    </head>
    <body>
        <jsp:include page="Menu.jspf"/>
        
        <table border="1">
            <tr>
                <td align="center"><b>Customer ID</b></td>
                <td align="center"><b>Name</b></td>
                <td align="center"><b>Address</b></td>
                <td align="center"><b>Portfolio</b></td>
            </tr>
            <%
                Customer[] customers = (Customer[])request.getAttribute("customers");
                
                for(int i=0; i < customers.length; i++)
                {
            %>
            <tr>
                <td align="center"><%=customers[i].getId()%></td>
                <td align="center"><%=customers[i].getName()%></td>
                <td align="center"><%=customers[i].getAddr()%></td>
                <td align="center"><a href="PortfolioController?customerIdentity=<%=customers[i].getId()%>">View</a></td>               
            </tr>
            <%
                }
            %>
        </table>
        <%
            String message = (String)request.getAttribute("message");
            
            if(message != null)
            {
                out.println("<font color='red'>" + message + "</font>");
            }
        %>
    </body>
</html>
