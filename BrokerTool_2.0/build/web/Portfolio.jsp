<%-- 
    Document   : Portfolio
    Created on : 10-mar-2015, 21:38:49
    Author     : Hyaku Nin Giri
--%>

<%@page import="trader.*;"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portfolio</title>
    </head>
    <body>
        <jsp:include page="Menu.jspf"/>
        <c:choose>
            <c:when test="${requestScope.message == null}" >
                ${requestScope.customer.name}'s Stocks
                <br />
                <table border="1" cellpadding="4">
                    <thead>
                        <tr>
                            <th>Stock Symbol</th>
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="share" items="${requestScope.shares}">
                            <tr>
                                <td>${share.stockSymbol}</td>
                                <td>${share.quantity}</td>
                            </tr>
                        </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <div style="color:red;">${requestScope.message}</div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
