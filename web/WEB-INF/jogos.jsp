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
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        
        <h1>${campeonato.ano}</h1>
        <c:if test="${campeonato.vencedor != 0}"> <h2>Vencedor: ${campeonato.nome}</h2></c:if>
        <c:forEach var="jogo" items="${jogos}" >
            <div>
                <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == null}"> <%-- Se for a final, pode escolher o vencedor --%>
                    <a href="AddVencedor?id=${jogo.time_casa}"><i class="fa-solid fa-trophy"></i></a>
                </c:if>
                <img src="MostrarImagem?id=${jogo.img_casa}" height="50px"/>  <img src="MostrarImagem?id=${jogo.img_visitante}" height="50px"/> 
                <br> <!-- tira depois -->
                ${jogo.nome_casa} X ${jogo.nome_visitante} 
                <c:if test="${jogo.fase == 'Final' && campeonato.vencedor == null}">
                    <a href="AddVencedor?id${jogo.time_visitante}"><i class="fa-solid fa-trophy"></i></a>
                </c:if>
                <br> <!-- tira depois -->
                ${jogo.data_jogo}
                ${jogo.horario}
                ${jogo.fase}
                <c:if test="${autenticado.isAdministrador == true}">
                  <a href="RemoverJogo?id=${jogo.id}"><i class="fa-solid fa-trash-can"></i></a>
                  <a href="EditarJogo?id=${jogo.id}"><i class="fa-solid fa-pencil"></i></a>  
                </c:if>
                
            </div>
        </c:forEach>
        <a href="HistoricoJogos">Ver Histórico de Jogos</a>
        Primeira Fase:
        <div class="tabela">
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
    </body>
</html>
