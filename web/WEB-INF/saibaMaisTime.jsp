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
    </head>
    <body>
        Nome: ${time.nome} <br>
        Ano: ${time.data_fundacao} <br>
        Tecnico: ${time.tecnico} <br>
        Presidente: ${time.presidente} <br>
        Local de Fundação: ${time.local_fundacao} <br>
        Títulos: ${time.titulos} <br>
        Torcedores: ${time.num_torcedores} <br>
        
        <br>
        
        Contratar Jogadora
        <form action="Jogadora_TimeServlet" method="post">
            <select name="selectJ">
                <c:forEach var="jogadora" items="${jogadoras}">
                      <option value="${jogadora.id}">${jogadora.nome}</option>
                </c:forEach>
           </select> 
            Data de inicio: <input type="date" name="data_inicio" class="cadastro-time">
            Número: <input type="number" name="numero" class="cadastro-time">
            Posição: <input type="text" name="posicao" class="cadastro-time">
            <input type="hidden" value="${time.id}" name="id_time">
            <input type="submit" name="" value="Contratar" class="btn-time">
        </form>
            
            <br>
            
            Jogadoras Atuais:
            <table border="1">
            <thead>
                <tr>
                    <th>Data de Início</th>
                    <th>N. Atual</th>
                    <th>Posição</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach varStatus="status" var="jogadora" items="${jogadorasT}">
                    <tr>
                        <c:if test="${jogadora.data_fim == null}">
                        <td>${jogadora.data_inicio}</td>
                        <td>${jogadora.numero_atual}</td>
                        <td>${jogadora.posicao}</td>
                         </c:if>
                    </tr>
                    </c:forEach>   
            </tbody>
        </table>
            
            Jogadoras Antigas:
            <table border="1">
            <thead>
                <tr>
                    <th>Data de Início</th>
                    <th>Data Fim</th>
                    <th>N. Atual</th>
                    <th>Posição</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <c:forEach varStatus="status" var="jogadora" items="${jogadorasT}">
                    <tr>
                        <c:if test="${jogadora.data_fim != null}">
                        <td>${jogadora.data_inicio}</td>
                        <td>${jogadora.data_fim}</td>
                        <td>${jogadora.numero_atual}</td>
                        <td>${jogadora.posicao}</td>
                        </c:if>
                    </tr>
                    </c:forEach>   
            </tbody>
        </table>
        
        <a href="GerenciarCookies?origin=Times">voltar</a>
    </body>
</html>
