<%-- 
    Document   : cadastro_times_jogadoras
    Created on : 27/09/2022, 14:52:49
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu de Cadastros</title>
        <link rel="stylesheet" href="estilo.css" type="text/css"/>
        <link rel="stylesheet" href="everyone.css" type="text/css"/>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <div class="pra-centralizar">
        <div class="estiquetas">
                <a href="Hub"><i class="fa-solid fa-xmark j3"></i></a>
            </div>
         <div class="both">
      <div class="left">
        <span class="r">MENU</span>
        <span class="r">ADM</span>
      </div>
      <div class="middle"></div>
      
      <div class="box">
          
        <a href="CadastrarTimes?idAlterar=${idAlterar}" class="am">TIME
          <i class="fa-solid fa-screwdriver-wrench"></i>
        </a>
        <a href="NoticiaCadastrar" class="am">NOTÍCIA
        <i class="fa-solid fa-screwdriver-wrench"></i></a>
        <a href="JogadoraCadastrar" class="am">JOGADORA
        <i class="fa-solid fa-screwdriver-wrench"></i></a>
        <span onclick="showCadastro()"><a class="am">USUÁRIO
                <i class="fa-solid fa-screwdriver-wrench"></i></a></span>
        <a href="CampeonatoCadastrar" class="am">CAMPEONATO
        <i class="fa-solid fa-screwdriver-wrench"></i></a>
        <a href="JogoCadastrar" class="am">JOGO
        <i class="fa-solid fa-screwdriver-wrench"></i></a>
      </div>
          
    </div>
        </div>
    </body>
</html>
