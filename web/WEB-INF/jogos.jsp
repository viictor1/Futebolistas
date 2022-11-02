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
        
        
        <c:forEach var="jogo" items="${jogos}" >
            <div>
                <img src="MostrarImagem?id=${jogo.img_casa}" height="50px"/>  <img src="MostrarImagem?id=${jogo.img_visitante}" height="50px"/> 
                <br> <!-- tira depois -->
                ${jogo.nome_casa} X ${jogo.nome_visitante}
                <br> <!-- tira depois -->
                ${jogo.data_jogo}
                <c:if test="${autenticado.isAdministrador == true}">
                  <a href="RemoverJogo?id=${jogo.id}"><i class="fa-solid fa-trash-can"></i></a>
                  <a href="EditarJogo?id=${jogo.id}"><i class="fa-solid fa-pencil"></i></a>  
                </c:if>
                
            </div>
        </c:forEach>
        
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
                        <td>
                            <c:if test="${autenticado.isAdministrador == true}">
                                <a href="SairDaCompeticao?id=${participante.id}"><i class="fa-solid fa-trash-can"></i></a>
                            </c:if>
                        </td>      
                        </tr>
                        
                      </c:forEach> 
                    </tbody>
                  </table>   
                    </div>
    </body>
</html>
