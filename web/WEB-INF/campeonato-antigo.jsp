<%-- 
    Document   : campeonato-antigo
    Created on : 08/10/2022, 09:48:00
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Campeonatos Antigos</title>
            <!-- ===== Link Swiper's CSS ===== -->
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />

        <!-- ===== CSS ===== -->
        <link rel="stylesheet" href="estilo.css">
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>

    <div class="body-feed">
    <section> 
      <div class="swiper mySwiper container">
        <div class="swiper-wrapper content">
            
        <c:forEach var="campeonato" items="${campeonatos}">
          <div class="swiper-slide cardf">
            <div class="media-icons">        
            </div>
            <div class="decoration2"></div><div class="decoration3"></div>
            <div class="card-content">
                <c:if test="${autenticado.isAdministrador == true}">
                    <a href="RemoverCampeonatoAntigo?id=${campeonato.id}"><i class="fa-solid fa-trash-can"></i></a>
                </c:if>
              <div class="img-feed">
                  <img src="">
              </div>
              <div class="titulo">
                <span class="name">${campeonato.ano}</span>
              </div>
            <div class="legenda">
                <span class="name">${campeonato.nome}</span>
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
