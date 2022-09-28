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
        <title>JSP Page</title>
        <link rel="stylesheet" href="estilo.css" type="text/css"/>
        <link rel="stylesheet" href="everyone.css" type="text/css"/>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="pra-centralizar">
         <div class="both">
       <i class="fa-solid fa-xmark"></i>
      <div class="left">
      <c:if test="${idAlterar != null}">
          <span class="r">Alterar</span>
      </c:if>
      <c:if test="${idAlterar == null}">
          <span class="r">CADASTRO</span>
      </c:if>
        <span class="r">TIME</span>
        <span class="r">E</span>
        <span class="r">JOGADORAS</span>
      </div>
      <div class="middle"></div>
      <div class="box">
        <a href="cadastrarTimes?idAlterar=${idAlterar}" class="am">TIME
          <i class="fa-solid fa-screwdriver-wrench"></i>
        </a>
        <a href="cadastrar-jogadoras.html" class="am">JOGADORAS
        <i class="fa-solid fa-screwdriver-wrench"></i></a>
      </div>
    </div>
        </div>
    </body>
</html>
