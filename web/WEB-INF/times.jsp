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
    
        <div class="body-card">
            <section>
             <div class="swiper mySwiper container">
      <div class="swiper-wrapper content">
      <c:forEach var="time" items="${times}">
        <div class="swiper-slide card">
            
          <div class="card-content">
            <div class="image">
              <img src="MostrarImagem?id=${time.idArquivo}">
            </div>
            <div class="media-icons">   
                <c:if test="${autenticado.isAdministrador == true}">
                    <a href="CadastrarTimes?idAlterar=${time.id}"><i class="fa-solid fa-pencil"></i></a>
                    <a href="RemoverTime?id=${time.id}"><i class="fa-solid fa-trash-can"></i></a>
                </c:if>
              
            </div>
            <div class="name-time">
              <span class="name">${time.nome}</span>
            </div>
            <div class="button-carrossel">
                <a href="SaibaMaisTime?id=${time.id}"><button class="saibaMais">Saiba Mais</button></a>
              <c:if test="${autenticado != null && autenticado.time != time.id}">
                <a href="TorcerTime?idTime=${time.id}"><button class="torcer">Torcer</button></a>
              </c:if>  
            <c:if test="${autenticado != null && autenticado.time == time.id}">
            <a href="TorcerTime?idTime=0"><button class="torcer">Deixar de Torcer</button></a>
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
  </body>
</html>
