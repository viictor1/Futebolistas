<%-- 
    Document   : cadastrar-campeonato-antigo
    Created on : 08/10/2022, 09:32:04
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Campeonato Antigo</title>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
    <div class="pra-centralizar">
            
    <div class="box-cadastro">
        <a href="MenuCadastro"> <i class="fa-solid fa-arrow-left"></i></a>
      <div class="left-times">
          
      </div>
      <div class="right-time">
          <form class="" action="CampeonatoAntigoCadastrar" method="post">
            <select name="selectTime">
                <c:forEach var="time" items="${times}">
                      <option value="${time.id}">${time.nome}</option>
                </c:forEach>
            </select>
          <input type="number" name="ano" value="" class="cadastro-time" placeholder="Ano">        
          <input type="submit" name="" value="Concluir" class="btn-time">   
        </form>
      </div>
    </div>
    </div>
    </body>
</html>
