<%-- 
    Document   : cadastrar-times
    Created on : 14/09/2022, 14:42:10
    Author     : maluc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>  
    <div class="jogadoras">Jogadoras</div>
    <div class="divisao">.</div>
    <div class="info-time">
      <center>
        <form class="" action="cadastrarTimes" method="post">
          <div class="container-img">.</div>
          <div class="infos-times"><input type="text" name="nome" value="" id="nome-time" placeholder="NOME DO TIME"></div>
          <div class="form-time1">
          Ano de Fundação: <input type="text" name="data" class="form-time" required>
          </div>
          <div class="form-time1">
          Técnico: <input type="text" name="tecnico" class="form-time" required>
          </div>
          <div class="form-time1">
          Presidente: <input type="text" name="presidente" class="form-time" required>
          </div>
          <div class="form-time1">
              Local de Fundação: <input type="text" name="local" class="form-time" required>
          </div>
          <div class="form-time1">
          Campeonatos Vencidos: <input type="text" name="titulos" class="form-time" required>
          </div>
          <button type="submit" class="form-button-time">SALVAR</button>
        </form>
        </center>
    </div>
  </body>
</html>
