<%-- 
    Document   : listar-jogadoras
    Created on : 05/11/2022, 14:42:13
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Jogadoras</title>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        <c:import url="menu.jsp"></c:import>
        
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="JogadoraCadastrar"><i class="fa-solid fa-chevron-left j"></i></a>
            </div> 
            <div class="b-small">
                <div class="l-small">
                    <span class="r">Jogadoras</span> 
                    <span class="r">Cadastradas</span>
                </div>
                <div class="r-small">
                    <div class="tabela">
                        <table>
                            <thead>
                              <tr>
                                <th>JOGADORA</th>
                                <th>TIME</th>
                              </tr>
                            </thead>
                            <tbody>
                              <c:forEach varStatus="status" var="jogadora" items="${jogadorasAll}">
                                <tr>
                                <td>${jogadora.nome}  <a href="JogadoraEditar?id=${jogadora.id}"> <i class="fa-solid fa-pencil t"></i></a></td>
                                <td>${jogadora.nomeTime}</td>               
                                </tr>                        
                              </c:forEach> 
                            </tbody>
                        </table>   
                </div>
                </div>                
            </div>
        </div>
        
    </body>
</html>
