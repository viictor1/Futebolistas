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
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
        <style>
            #div1 {
                width: 2.5vw;
                height: 5vh;
                flex-direction: row;
                display: flex;
                gap: 10px;
                position: relative;
            }
            .controle{
                max-width: 220px;
                overflow-x: scroll;
                height: 60px;
            }
        </style>
        <script>
            function allowDrop(ev) {
                ev.preventDefault();
            }

            function drag(ev) {
                ev.dataTransfer.setData("text", ev.target.id);
            }

            function drop_casa(ev) {
                ev.preventDefault();
                if(ev.target.id !== "div1"){
                    return;
                }
                var data = ev.dataTransfer.getData("text");
                document.querySelector("[name='time_casa']").value = data;
                ev.target.appendChild(document.getElementById(data));
            }

            function drop_visitante(ev) {
                ev.preventDefault();
                if(ev.target.id !== "div1"){
                    return;
                }
                var data = ev.dataTransfer.getData("text");
                document.querySelector("[name='time_visitante']").value = data;
                ev.target.appendChild(document.getElementById(data));
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
            <div class="pra-centralizar">
                <div class="estiquetas">
                    <a href="MenuCadastro"><i class="fa-solid fa-chevron-left j3"></i></a>
                </div>  
            
            <div class="b-cadastro2">
                <div class="l-left">
                    <span class="r">CADASTRO</span>
                    <span class="r">DE</span>
                    <span class="r">JOGOS</span>
                </div>
                <div class="middle"></div>
                <div class="r-right">
                    <form action="JogoCadastrar" method="post">
                        <input type="hidden" name="campeonato" value="${campeonato.id}">  <!--id do campeonato atual-->
                        <input type="date" name="data_jogo" class="cadastro-j" placeholder="Data do Jogo" required>
                        <input type="time" name="horario" class="cadastro-j" required>
                        <select class="select-jogadora" name="select">
                            <option value="Primeira Fase">Primeira Fase</option>
                            <option value="Quartas de Final">Quartas de Final</option>
                            <option value="Semifinal">Semifinal</option>
                            <option value="Final">Final</option>
                        </select>

                        Time casa: <div id="div1" ondrop="drop_casa(event)" ondragover="allowDrop(event)">
                        <input type="hidden" name="time_casa" class="cadastro-j" placeholder="Time casa" required></div>
                        Time visitante: <div id="div1" ondrop="drop_visitante(event)" ondragover="allowDrop(event)">
                            <input type="hidden" name="time_visitante" required></div>

                        Times:
                        <div class="controle">
                        <div id="div1" ondrop="drop(event)" ondragover="allowDrop(event)"> 
                            <c:forEach var="time" items="${participantes}">          
                                <img id="${time.id}" src="MostrarImagem?id=${time.idArquivo}" draggable="true" ondragstart="drag(event)" width="100%" height="100%"> 
                            </c:forEach>
                        </div>
                        </div>
                        <input type="submit" name="" value="Concluir" class="btn-j">
                    </form> 
                </div>
            </div>
        </div>
    </body>
</html>
