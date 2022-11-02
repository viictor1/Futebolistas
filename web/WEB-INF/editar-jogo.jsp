<%-- 
    Document   : editar-jogo
    Created on : 29/10/2022, 16:43:11
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <title>Alterar Placar</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        
        <form action="EditarJogo" method="post">
            <img src="MostrarImagem?id=${jogo.img_casa}" height="50px" width="50px"/>  <img src="MostrarImagem?id=${jogo.img_visitante}" height="50px"/> 
        <br> <!-- tira depois -->
        ${jogo.nome_casa} X ${jogo.nome_visitante}
        <br> <!-- tira depois -->
        ${jogo.data_jogo}
        gols casa <input type="number" name="golsCasa" required> gols visitante <input type="number" name="golsVisitante" required>
        <input type="submit" name="" value="Concluir" class="btn-j">   
        <input type="hidden" name="id" value="${jogo.id}">
        </form>
        
    </body>
</html>
