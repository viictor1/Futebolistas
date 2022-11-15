<%-- 
    Document   : noticia
    Created on : 18/10/2022, 15:44:46
    Author     : maluc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Noticia</title>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="menu.jsp"></c:import>
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="Hub"><i class="fa-solid fa-chevron-left j"></i></a>
            </div>
            <div class="bonitinha">
                <div class="c2">
                    <div class="info-noticia">
                        <span class="title">${noticia.titulo}</span>
                        <span class="author">${noticia.autor}</span>
                        <span class="texto-noticia">${noticia.texto}</span>
                    </div>  
                </div>
                <div class="c1">
                    <div class="img-noticia">
                        <img src="MostrarImagem?id=${noticia.idArquivo}"/>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
