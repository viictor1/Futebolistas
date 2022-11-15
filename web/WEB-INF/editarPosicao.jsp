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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="estilo.css">
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
        <title>Editar Posicao</title>
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
                    <span class="r">POSIÇÃO</span>
                </div>
                <div class="middle"></div>
                <div class="r-right">
                    <form action="EditarPosicao" method="post">
                        <span class="g2">${time.nome}</span>
                        <span class="g">Posição:</span>
                        <input type="number" name="posicao" value="${time.posicao}" class="cadastro-j">
                        <input type="hidden" name="id" value="${time.id}" class="cadastro-j">
                        <input type="submit" name="Editar" value="Concluir" class="btn-j">
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
