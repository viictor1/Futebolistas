<%-- 
    Document   : jogos
    Created on : 24/10/2022, 19:12:11
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogos</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        
        <c:forEach var="jogo" items="${jogos}" >
            <div>
                ${jogo.time_casa} X ${jogo.time_visitante}
            </div>
        </c:forEach>
    </body>
</html>
