<%-- 
    Document   : cadastrar-jogo
    Created on : 23/10/2022, 23:22:54
    Author     : victo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Jogo</title>
        <style>
        #div1 {
          width: 350px;
          height: 70px;
          padding: 10px;
          border: 1px solid #aaaaaa;
        }
        </style>
        <script>
            function allowDrop(ev) {
              ev.preventDefault();
            }

            function drag(ev) {
              ev.dataTransfer.setData("text", ev.target.id);
            }

            function drop(ev) {
              ev.preventDefault();
              var data = ev.dataTransfer.getData("text");
              ev.target.appendChild(document.getElementById(data));
            }
            </script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <form action="">
            Data do jogo <input type="date" name="data">
            <input type="hidden" name="campeonato" value="${campeonato.id}"> <!<!-- id do campeonato atual -->
            Time casa: <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
            Time visitante: <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"></div>
            
            Times:
            <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"> 
            <c:forEach var="time" items="${times}">          
                    <img id="drag${time.id}" src="MostrarImagem?id=${time.idArquivo}" draggable="true" ondragstart="drag(event)" width="336" height="69"> <br>             
            </c:forEach>
            </div>
           
            <input type="submit" name="" value="Concluir" class="btn-time">
        </form>
    </body>
</html>
