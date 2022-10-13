<%-- 
    Document   : cadastrar-jogadora
    Created on : 12/10/2022, 10:17:12
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Jogadoras</title>
        
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        
        <div class="pra-centralizar">
            
    <div class="box-cadastro">
        <a href="MenuCadastro"> <i class="fa-solid fa-arrow-left"></i></a>
      <div class="left-times">
          
      </div>
      <div class="right-time">
          <form class="" action="JogadoraCadastrar" method="post">         
          <input type="text" name="nome" class="cadastro-time" placeholder="Nome">        
          <input type="submit" name="" value="Cadastrar" class="btn-time">
        </form>
          
          Apagar Jogadora
          <form action="RemoverJogadora" method="post">
            <select name="selectJ">
                <c:forEach var="jogadora" items="${jogadoras}">
                      <option value="${jogadora.id}">${jogadora.nome}</option>
                </c:forEach>
            </select> 
              <br> <!<!-- apagar depois -->
              <input type="submit" name="" value="Remover" class="btn-time">
           </form>
      </div>
              
    </div>
        
    </div>
    </body>
</html>
