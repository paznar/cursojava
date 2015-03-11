<%-- 
    Document   : CustomerDetails
    Created on : 10-mar-2015, 22:03:54
    Author     : Hyaku Nin Giri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="trader.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Details</title>
    </head>
    <body>
        <jsp:include page="Menu.jspf"/>
        <form action='CustomerController' method='GET'>
            <input type='hidden' name='version' value='${customer.version}'/>
            <table border='1' cellpadding='4'>
                <tbody>
                    <tr>
                        <td>Customer Name</td>
                        <td><input name='customerName' value='${customer.name}' type='text'/></td>
                    </tr>
                    <tr>
                        <td>Customer Identity</td>
                        <td><input name='customerIdentity' value='${customer.id}' type='text'/></td>
                    </tr>
                    <tr>
                        <td>Customer Address</td>
                        <td><input name='customerAddress' value='${customer.addr}' type='text'/></td>
                    </tr>
                    <tr>
                        <td colspan='2' align='center'><input name='submit' value='Get Customer' type='submit'/>
                            <input name='submit' value='Update Customer' type='submit'/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan='2' align='center'><input name='submit' value='Add Customer' type='submit'/>
                            <input name='submit' value='Delete Customer' type='submit'/>
                        </td>
                    </tr>
                    <c:if test="${not empty customer.id}">
                        <tr>
                            <td colspan='2' align='center'>
                                <a href='PortfolioController?customerIdentity=${customer.id}'>View Portfolio</a>
                            </td>
                        </tr>
                    </c:if>
                </tbody>
            </table>
        </form>
        <br/>
        <c:if test="${not empty requestScope.message}">
            <div style="color:red;">${requestScope.message}</div>
        </c:if>
    </body>
</html>