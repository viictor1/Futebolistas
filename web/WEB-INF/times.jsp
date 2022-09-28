<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
       <!-- ===== Link Swiper's CSS ===== -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

    <!-- ===== Fontawesome CDN Link ===== -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
    <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="menu.jsp"></c:import>
        
    <div class="feed"><center>TIMES</center></div>
    
    <c:if test="${autenticado.isAdministrador == true}"> <!-- se o usuário logado for um adm, ele poderá cadastrar um novo time -->
        <div id="option"><center><a href="cadastrarTimes">Cadastrar novo Time</a></center></div>
        </c:if>
        <div class="body-card">
            <section>
             <div class="swiper mySwiper container">
      <div class="swiper-wrapper content">
      <c:forEach var="time" items="${times}">
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="">
            </div>
            <div class="media-icons">   
                <c:if test="${autenticado.isAdministrador == true}">
                    <a href="menuTimes?idAlterar=${time.id}"><i class="fa-solid fa-pencil"></i></a>
                    <a href="removerTime?id=${time.id}"><i class="fa-solid fa-xmark"></i></a>
                </c:if>
              
            </div>
            <div class="name-time">
              <span class="name">${time.nome}</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <c:if test="${autenticado != null && autenticado.time != time.id}">
                  <button class="torcer"> <a href="torcerTime?idTime=${time.id}">Torcer</a></button> 
              </c:if>              
            </div>
          </div>
        </div>
        </c:forEach>
          </div>
        </div>
       <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </section>
      </div>

    
    <!-- Swiper JS -->
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

  <!-- Initialize Swiper -->
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
        </div>
  </body>
</html>
