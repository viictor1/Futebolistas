<%-- 
    Document   : cadastro-noticias
    Created on : 06/10/2022, 15:06:48
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
    <div class="box-cadastro">
        <a href="MenuCadastro"> <i class="fa-solid fa-arrow-left"></i></a>
      <div class="left-times">
          
      </div>
      <div class="right-time">
          <form class="" action="NoticiaCadastrar" method="post" enctype="multipart/form-data">
          <input type="text" name="titulo" value="" class="cadastro-time" placeholder="TÍTULO">
          <input type="text" name="autor" value="" class="cadastro-time" placeholder="AUTOR">
          <textarea class="cadastro-time" name="texto" rows="15" cols="30"></textarea>
          <label for="file" class="file cadastro-time">Capa da Notícia
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
