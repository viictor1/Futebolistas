<%-- 
    Document   : saibaMaisTime
    Created on : 12/10/2022, 13:41:17
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saiba Mais</title>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        
        <c:import url="header.jsp"></c:import>
        <c:import url="menu.jsp"></c:import>
        
        
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="Times"><i class="fa-solid fa-chevron-left"></i></a>
                <c:if test="${autenticado.isAdministrador == true}">
                    <a href="Jogadora_TimeServlet?id=${time.id}"><i class="fa-solid fa-pencil fa-2"><span class="cje">Cadastrar Jogadoras</span></i></a>
                </c:if>
            </div>
            <div class="bonitinha">
                <div class="c2">
                    <div class="tabela">
                    <table>
                    <thead>
                      <tr>
                        <th>JOGADORAS</th>
                        <th>Posição</th>
                        <th>Data de Início</th>
                        <th>N. Atual</th>
                      </tr>
                    </thead>
                    <tbody>
                      <c:forEach varStatus="status" var="jogadora" items="${jogadorasT}">
                        <tr>
                        <td>${jogadora.nome}</td>
                        <td>${jogadora.posicao}</td>
                        <td>${jogadora.data_inicio}</td>
                        <td>${jogadora.numero_atual}</td>
                        <c:if test="${autenticado.isAdministrador == true}">
                            <td><a href="Jogadora_TimeServlet?id_jogadora=${jogadora.id}&id=${jogadora.id_time}"><i class="fa-solid fa-pencil"></i></a></td>
                            <td><a href="RemoverJT?id=${jogadora.id}"><i class="fa-solid fa-trash-can"></a></i></td>
                        </c:if>                     
                        </tr>
                        
                      </c:forEach> 
                    </tbody>
                  </table>   
                    </div>
                </div>
                <div class="c1">
                    <div class="cont-img">
                        <div class="card-x">
                            <style>
                                .cont-img .card-x:after{
                                    content: '${time.nome}';
                                }
                            </style>
                    <div class="imgBx">
                        <img src="MostrarImagem?id=${time.idArquivo}">
                    </div>
                    <div class="contentBx">
                        
                        
                        <div class="size">
                            <h2>${time.nome} </h2>
                            <span>Fundação: ${time.data_fundacao} </span>
                            <span>Tecnico: ${time.tecnico} </span>
                            <span>Presidente: ${time.presidente} </span>
                            <span>Local Fundação: ${time.local_fundacao}</span>
                            <span>Títulos: ${time.titulos} </span>
                            <span>Torcedores: ${time.num_torcedores}</span>
                        </div>
                    </div>
                    </div>
                    </div>
                </div>
                
            </div>
        
        </div>

    </body>
</html>
