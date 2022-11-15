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
        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="estilo.css">
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
        <title>Alterar Placar</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="Jogos"><i class="fa-solid fa-chevron-left j3"></i></a>
            </div>
            <div class="b-cadastro">
                <div class="l-left">
                    <span class="r">MENU</span>
                    <span class="r">PARA</span>
                    <span class="r">EDITAR</span>
                    <span class="r">JOGO</span>
                </div>
                <div class="middle"></div>
                <div class="r-right">
                    <form action="EditarJogo" method="post">
                        <div class="img-editartime">
                           <img src="MostrarImagem?id=${jogo.img_casa}"/>
                           <img src="MostrarImagem?id=${jogo.img_visitante}"/>
                        </div>
                        <div class="bajo">
                            ${jogo.nome_casa} X ${jogo.nome_visitante}
                        </div>
                            <span class="g">${jogo.data_jogo}</span>
                        <input type="number" name="golsCasa" class="cadastro-j" placeholder="Gols casa" required> 
                        <input type="number" name="golsVisitante" class="cadastro-j" placeholder="Gols visitante" required>
                        <input type="submit" name="" value="Concluir" class="btn-j">   
                        <input type="hidden" name="id" value="${jogo.id}">
                    </form>
                </div>
            </div>
        </div>      
    </body>
</html>
