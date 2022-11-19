<%-- 
    Document   : jogos
    Created on : 24/10/2022, 19:12:11
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jogos</title>
        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

        <!-- ===== Fontawesome CDN Link ===== -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"/>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        <div class="feed">CAMPEONATO</div>
        <div class="ano-feed">${campeonato.ano}
            <c:if test="${campeonato.vencedor != 0}">  <br> <!-- tirar depois -->
             Vencedor: ${campeonato.nome}
         </c:if>
        </div>
        
        
       
        <div class="frase-proximo">Próximos jogos:</div>
        <div class="body-camp">
            <section class="section-camp">
                <div class="swiper mySwiper container">
                    <div class="swiper-wrapper content">
                       <c:forEach var="jogo" items="${jogos}" >
                           <div class="swiper-slide card-camp">
                               <div class="card-content">
                                   <div class="image-camp">
                                       <div class="nome-time"><img src="MostrarImagem?id=${jogo.img_casa}" height="50px"/>${jogo.nome_casa}
                                           <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == 0}">
                                               <a href="AddVencedor?id=${jogo.time_casa}"><i class="fa-solid fa-trophy"></i></a>                                           
                                           </c:if>
                                       </div>
                                       
                                       <div class="nome-time"><img src="MostrarImagem?id=${jogo.img_visitante}" height="50px"/>${jogo.nome_visitante}
                                            <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == 0}"> <%-- Se for a final, pode escolher o vencedor --%>
                                             <a href="AddVencedor?id=${jogo.time_visitante}"><i class="fa-solid fa-trophy"></i></a>
                                            </c:if>
                                       </div>                             
                                        
                                   </div>
                                    <div class="linha-small"></div>
                                    <div class="data-hora">
                                        <span>${jogo.data_jogo}</span>
                                        <span>${jogo.horario}</span>
                                        <span class="fase">${jogo.fase}</span>    
                                    </div>
                                   <div class="media-icons">
                                       <c:if test="${autenticado.isAdministrador == true}">
                                       <a href="RemoverJogo?id=${jogo.id}"><i class="fa-solid fa-trash-can"></i></a>
                                        <a href="EditarJogo?id=${jogo.id}"><i class="fa-solid fa-pencil"></i></a> 
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
      <div class="cont-campt">
        <div class="tabela3">
            Primeira Fase:
                <table>
                    <thead>
                      <tr>
                        <th>CLASSIFICAÇÃO</th>
                        <th>P</th>
                        <th>J</th>
                        <th>V</th>
                        <th>E</th>
                        <th>D</th>
                        <th>GP</th>
                        <th>GC</th>
                        <th>SG</th>
                        <th color="transparent">.</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach varStatus="status" var="participante" items="${participantes}">
                        <tr>
                        <td> 
                        <c:if test="${autenticado.isAdministrador == true}">
                            <a href="EditarPosicao?id=${participante.id}"><i class="fa-solid fa-pencil"></i></a>  
                        </c:if>
                      ${participante.posicao} ${participante.nome}</td>
                        <td>${participante.pontos}</td>
                        <td>${participante.jogos}</td>        
                        <td>${participante.vitorias}</td>
                        <td>${participante.empates}</td>
                        <td>${participante.derrotas}</td>
                        <td>${participante.golsMarcados}</td>
                        <td>${participante.golsSofridos}</td>
                        <td>${participante.saldo}</td>
                        <c:if test="${autenticado.isAdministrador == true}">
                            <td>
                                <a href="SairDaCompeticao?id=${participante.id}"><i class="fa-solid fa-trash-can"></i></a>
                            </td>
                        </c:if>
                              
                        </tr>
                        
                      </c:forEach> 
                    </tbody>
                  </table>  
            
                    </div>
        </div>
        <div class="link-historico"><a href="HistoricoJogos">Ver Histórico de Jogos</a></div>
    </body>
</html>
