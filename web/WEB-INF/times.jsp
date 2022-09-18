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
 
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        
    <div class="feed"><center>TIMES</center></div>
    
    <c:if test="${autenticado.isAdministrador == true}"> <!-- se o usuário logado for um adm, ele poderá cadastrar um novo usuário -->
        <div id="option"><center><a href="cadastrarTimes">Cadastrar novo Time</a></center></div>
        </c:if>
        <div class="body-card">
            <section>
             <div class="swiper mySwiper container">
      <div class="swiper-wrapper content">
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="img/botafogo.png">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">BOTAFOGO</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="img/corinthians.png" alt="">
            </div>
            <div class="media-icons">
              <a href="https://twitter.com/SCCPFutFeminino?s=20&t=QZIad4S9XPe9xdCy5LxSsw"><i class="fab fa-twitter"></i></a>
            </div>
            <div class="name-time">
              <span class="name">CORINTHIANS</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="img/vasco.png" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">VASCO</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="images/img4.jpg" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              <span class="name">time</span>
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
        <div class="swiper-slide card">
          <div class="card-content">
            <div class="image">
              <img src="" alt="">
            </div>
            <div class="media-icons">
              <i class="fab fa-twitter"></i>
            </div>
            <div class="name-time">
              time
            </div>
            <div class="button-carrossel">
              <button class="saibaMais">Saiba Mais</button>
              <button class="torcer">Torcer</button>
            </div>
          </div>
        </div>
      </div>
    </div>

    <div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>
      <div class="swiper-pagination"></div>
    </section>
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
