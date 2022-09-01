<%--
    Document   : indexlogin
    Created on : 20/06/2022, 08:30:20
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Futebolistas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="http://fonts.cdnfonts.com/css/lovelo" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="estilo.css">
        <link rel="stylesheet" href="style.css" type="text/css">
        <link rel="stylesheet" href="everyone.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script type="text/javascript">
        function validarRemover(){
            if(window.confirm("Deseja realmente apagar a conta?") == true){
                window.location.href = "UsuarioRemover";
            }
            return;
        }
        function validarSair(){
            if(window.confirm("Deseja realmente sair?") == true){
                window.location.href = "EncerrarSessao";
            }
        }
        function showLogado() {
          var element = document.getElementById("modal-logado");
          element.classList.add("show-modal-logado");
        }
        function hideLogado() {
          var element = document.getElementById("modal-logado");
          element.classList.remove("show-modal-logado");
        }
        function showEsquece() {
          var element = document.getElementById("modal-esquece");
          element.classList.add("show-esquece");
        }
        function hideEsquece() {
          var element = document.getElementById("modal-esquece");
          element.classList.remove("show-esquece");
        }
        
        </script>
    </head>
    <body>
        <script>alert("Seja bem-vindo, ${autenticado.nome}!")</script>
     <div id="decoration">
    <div id="barra"></div>
    <div id="textinho">SITE FOCADO NO <br> FUTEBOL FEMININO </div>
  </div>
     
    <div id="menu-login" onclick="showLogado()">
      <center>
      <div id="line-login"></div>
      <div id="line-login"></div>
      <div id="line-login"></div>
      </center>
    </div>
    <div class="side-menu">
      <div class="modal-logado" id="modal-logado">
        <div class="content-logado">
            
          <span onclick="hideLogado()">&times;</span>
          <div id=modal-titulo>${autenticado.nome}</div> <!--AQ É A VARIÁVEL DO NOME QUE O USUÁRIO ESCOLHEU -->
          <div id="modal-line"></div>
          <div id="option"><center>Meu time</center></div>
          <div id="modal-line"></div>
          <div id="option" onclick="showEsquece();hideLogado()"><center>Alterar senha</center></div>
          <div id="modal-line"></div>
          <div id="option"><center><a onclick="validarRemover()">Apagar conta</a></center></div>
          <div id="modal-line"></div>
          <c:if test="${autenticado.isAdministrador == true}">
              Cadastrar novo Usuario
          </c:if>
            <div id="modal-line"></div>
          <div id="option"><center><a onclick="validarSair()"">Sair</a></center></div> <!--Aq é pra logout-->
        </div>
      </div>
    </div>
    <div class="esqueceu">
      <div class="modal-esquece" id="modal-esquece">
        <div class="content-login">
          <span onclick="hideEsquece()">&times;</span>
          ALTERAR SENHA
        </div>
      </div>
    </div>
    <div id="pmenu">
      ELAS NO CAMPO
    </div>
    <div id="smenu">FUTEBOLISTAS</div>
    <hr color="black" size="3px">
    <div class="links">
        <center>
          <nav class="menu">
            <ul>
              <li><a href="index.html">HOME</a></li>
              <li><a href="">TIMES</a></li>
              <li><a href="">CAMPEONATO</a></li>
              <li><a href="">JOGOS</a></li>
              <li><a href="">TORCIDAS</a></li>
              <li><a href="">HISTÓRIA</a></li>
            </ul>
          </nav>
        </center>
    </div>
    <center><div id="line"></div></center>
    <div class="feed"><center>FEED</center></div>
   <center>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div>
  </div>
    <div id="space"></div>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div></div>
    <div id="space"></div>
    <div class="containers"><div class="decoration2"></div><div class="decoration3"></div>
    <img src="img/exemplo.jpg" id="img-feed"><div id="titulo">TÍTULO</div><div id="legenda">legenda legenda legenda legenda</div></div>
    </center>
  </body>
</html>
