<%-- 
    Document   : cadastrar-campeonato-antigo
    Created on : 08/10/2022, 09:32:04
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Campeonato</title>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>        
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
            <div class="pra-centralizar">
                <div class="estiquetas">
                    <a href="MenuCadastro"><i class="fa-solid fa-chevron-left j3"></i></a>
                </div>     
                <div class="b-cadastro">

                    <div class="l-left">
                        <span class="r">CADASTRO</span>
                        <span class="r">DE</span>
                        <span class="r">CAMPEONATOS</span>
                    </div>
                    <div class="middle"></div>
                    <div class="r-right">
                        <form class="" action="CampeonatoCadastrar" method="post">
                            <select name="selectTime" class="select-jogadora">
                                <option value="0"></option>
                            <c:forEach var="time" items="${times}">
                                <option value="${time.id}">${time.nome}</option>
                            </c:forEach>
                        </select>
                        <input type="number" name="ano" value="" class="cadastro-j" placeholder="Ano" required>        
                        <input type="submit" name="" value="Concluir" class="btn-j">   
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
