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
        
    </head>
    <body>
     
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>

        <!-- Feed de notícias -->
    <div class="feed"><center>FEED</center></div>
    
    <center>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div>
  </div>
    <div id="space"></div>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div></div>
    <div id="space"></div>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div></div>
    </center>
    <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
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
