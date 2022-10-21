<%-- 
    Document   : cadastro-noticias
    Created on : 06/10/2022, 15:06:48
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="estilo.css">
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <div class="pra-centralizar">
           <div class="estiquetas">
                <a href="Hub?/=SaibaMaisTime"><i class="fa-solid fa-chevron-left j"></i></a>
            </div> 
            <div class="b-cadastro">
                <div class="l-left">
                    <span class="r">MENU</span>
                    <span class="r">PARA</span>
                    <span class="r">CADASTRO</span>
                    <span class="r">DE</span>
                    <span class="r">NOTICÍAS</span>
                </div>
                <div class="middle"></div>
      <div class="r-right">
          <form class="" action="NoticiaCadastrar" method="post" enctype="multipart/form-data">
          <input type="text" name="titulo" value="" class="cadastro-j" placeholder="Título">
          <input type="text" name="autor" value="" class="cadastro-j" placeholder="Autor">
          <textarea class="cadastro-j" name="texto" rows="10" cols="20" style="resize: none; height:80px" placeholder="Texto"></textarea>
          <label for="file" class="file cadastro-j">Capa da Notícia
            <i class="fa-solid fa-image"></i>
          </label>
          <input type="file" name="imagem" id="file" value="" class="cadastro-j">
          <input type="submit" name="" value="Concluir" class="btn-j">   
        </form>
      </div>
    </div>
    </div>
    </body>
</html>
