<%-- 
    Document   : cadastrar-times
    Created on : 14/09/2022, 14:42:10
    Author     : maluc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- ===== Fontawesome CDN Link ===== -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- ===== CSS ===== -->
    <link rel="stylesheet" href="estilo.css">
    <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="pra-centralizar">
            
    <div class="box-cadastro">
        <a href="menuTimes"> <i class="fa-solid fa-arrow-left"></i></a>
      <div class="left-times">
          
      </div>
      <div class="right-time">
          <form class="" action="cadastrarTimes?id=${alterar.id}" method="post" enctype="multipart/form-data">
          <input type="text" name="nome" value="${alterar.nome}" class="cadastro-time" placeholder="Nome do time">
          <input type="text" name="data" value="${alterar.data_fundacao}" class="cadastro-time" placeholder="Ano de Fundação">
          <input type="text" name="tecnico" value="${alterar.tecnico}" class="cadastro-time" placeholder="Técnico">
          <input type="text" name="presidente" value="${alterar.presidente}" class="cadastro-time" placeholder="Presidente">
          <input type="text" name="local" value="${alterar.local_fundacao}" class="cadastro-time" placeholder="Local de Fundação">
          <input type="text" name="titulos" value="${alterar.titulos}" class="cadastro-time" placeholder="Campeonatos Vencidos">
          <label for="file" class="file cadastro-time">Logo do time
            <i class="fa-solid fa-image"></i>
          </label>
          <input type="file" name="imagem" id="file" value="" class="cadastro-time">
          <input type="submit" name="" value="Concluir" class="btn-time">   
        </form>
      </div>
    </div>
    </div>
  </body>
</html>
