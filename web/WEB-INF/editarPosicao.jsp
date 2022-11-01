<%-- 
    Document   : editarPosicao
    Created on : 01/11/2022, 10:51:27
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Posicao</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        
        <form action="EditarPosicao" method="post">
            ${time.nome}
            Posicao: <input type="number" name="posicao" value="${time.posicao}">
            <input type="hidden" name="id" value="${time.id}">
            <input type="submit" name="Editar">
        </form>
    </body>
</html>
