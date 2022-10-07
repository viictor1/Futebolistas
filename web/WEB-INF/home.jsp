<%-- 
    Document   : home
    Created on : 27/06/2022, 08:06:27
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <!-- ===== Link Swiper's CSS ===== -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

    <!-- ===== Fontawesome CDN Link ===== -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

    <!-- ===== CSS ===== -->
    <link rel="stylesheet" href="estilo.css">
    <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <c:if test="${cadastro == true}">
        <body onload="showCadastro()">
    </c:if>
    <c:if test="${cadastro == false}">
         <body>
    </c:if>
     
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>

        <!-- Feed de notícias -->
    <div class="feed"><center>FEED</center></div>
    <div class="body-feed">
    <section> 
      <div class="swiper mySwiper container">
        <div class="swiper-wrapper content">
            
        <c:forEach var="noticia" items="${noticias}">
          <div class="swiper-slide cardf">
            <div class="media-icons">        
            </div>
            <div class="decoration2"></div><div class="decoration3"></div>
            <div class="card-content">
                <c:if test="${autenticado.isAdministrador == true}">
                    <a href="RemoverNoticia?id=${noticia.id}"><i class="fa-solid fa-trash-can"></i></a>
                </c:if>
              <div class="img-feed">
                <img src="MostrarImagem?id=${noticia.idArquivo}">
              </div>
              <div class="titulo">
                <span class="name">${noticia.titulo}</span>
              </div>
              <div class="legenda">
                <span class="legenda-noticia">${noticia.texto}</span>
              </div>
            </div>
          </div>          
        </c:forEach>
      </div>
      <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-pagination"></div>
      </div>
    </section>
      <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
      
      <script>
    var swiper = new Swiper(".mySwiper", {
      slidesPerView: 3,
      spaceBetween: 30,
      slidesPerGroup: 3,
      loop: true,
      loopFillGroupWithBlank: true,
      pagination: {
        el: ".swiper-pagination",
        clickable: true,
      },
      navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
      },
    });
  </script>
  </body>
</html>
