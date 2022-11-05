<%-- 
    Document   : historico-jogos
    Created on : 05/11/2023, 10:07:14
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Histórico de Jogos</title>
        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        <a href="Jogos">Voltar</a>
        
        <h1>${campeonato.ano}</h1>
        <c:forEach var="jogo" items="${historico}" >
            <div>
                <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == null}"> <%-- Se for a final, pode escolher o vencedor --%>
                    <a href="AddVencedor?id=${jogo.time_casa}"><i class="fa-solid fa-trophy"></i></a>
                </c:if>
                <img src="MostrarImagem?id=${jogo.img_casa}" height="50px"/>  <img src="MostrarImagem?id=${jogo.img_visitante}" height="50px"/> 
                <br> <!-- tira depois -->
                ${jogo.nome_casa} X ${jogo.nome_visitante} 
                ${jogo.gol_casa}    ${jogo.gol_visitante}
                <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == null}">
                    <a href="AddVencedor?id${jogo.time_visitante}"><i class="fa-solid fa-trophy"></i></a>
                </c:if>
                <br> <!-- tira depois -->
                ${jogo.data_jogo}
                ${jogo.fase}
                <c:if test="${autenticado.isAdministrador == true}">
                  <a href="RemoverJogo?id=${jogo.id}"><i class="fa-solid fa-trash-can"></i></a>
                </c:if>
                
            </div>
        </c:forEach>
    </body>
</html>
