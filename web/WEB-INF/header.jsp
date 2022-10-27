<%-- 
    Document   : header
    Created on : 15/09/2022, 11:03:13
    Author     : maluc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
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
        function showAtualizarS() {
          var element = document.getElementById("modal-esquece");
          element.classList.add("show-esquece");
        }
        function hideAtualizarS() {
          var element = document.getElementById("modal-esquece");
          element.classList.remove("show-esquece");
        }
        function showModal() {
          var element = document.getElementById("modal");
          element.classList.add("show-modal");
        }
        function hideModal() {
          var element = document.getElementById("modal");
          element.classList.remove("show-modal");
        }
        function showLogin() {
          var element = document.getElementById("modal-login");
          element.classList.add("show-login");
        }
        function hideLogin() {
          var element = document.getElementById("modal-login");
          element.classList.remove("show-login");
        }
        function showCadastro() {
          var element = document.getElementById("modal-cadastro");
          element.classList.add("show-cadastro");
        }
        function hideCadastro() {
          var element = document.getElementById("modal-cadastro");
          element.classList.remove("show-cadastro");
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
        
        <style>.options-container{
                padding-top: 50px
            }
            </style>
    </head>
    <body>
        
    <div id="decoration">
    <div id="barra"></div>
    <div id="textinho">SITE FOCADO NO <br> FUTEBOL FEMININO </div>
  </div>
        <div id="menu-login" onclick="<c:if test="${autenticado == nul}">showModal()</c:if> <c:if test="${autenticado != nul}">showLogado()</c:if>"> <!-- mudando o modal que aparecerá dependendo se o usuário está ou não logado -->
      <center>
      <div class="line-login"></div>
      <div class="line-login"></div> <!-- Menu do lado fechado -->
      <div class="line-login"></div>
      </center>
    </div>
    <div id="pmenu">
      ELAS NO CAMPO
    </div>
    <div id="smenu">FUTEBOLISTAS</div>
    <hr color="black" size="3px">
        <c:if test="${autenticado == null}"> <!-- Se não tiver usuário logado, aparecerá esse menu -->
    <div class="side-menu">
      <div class="modal" id="modal">
        <div class="modal-content">
          <span class="x" onclick="hideModal()">&times;</span>
          <div id=modal-titulo>USUÁRIO</div>
          <div class="modal-line"></div>
          <div class="option" onclick="showLogin();hideModal()"><center>Login</center></div>
          <div class="modal-line"></div>
          <div class="option" onclick="showCadastro();hideModal()"><center>Registrar conta</center></div>
          <div class="modal-line"></div>
          <div class="option"><center>mais opções</center></div>
          <div class="modal-line"></div>
        </div>
      </div>
    </div>
    </c:if>
        
        <c:if test="${autenticado != null}"> <!-- Se tiver usuário logado, apareerá essa tela -->
    <div class="side-menu" onclick="sh">
    <div class="modal-logado" id="modal-logado">
    <div class="content-logado">        
    <span class="x" onclick="hideLogado()">&times;</span>
    <div id=modal-titulo>${autenticado.nome}</div> <!--AQ É A VARIÁVEL DO NOME QUE O USUÁRIO ESCOLHEU -->
    <a href="SaibaMaisTime?id=${autenticado.time}"><div class="option"><center>Meu time</center></div></a>
    <div class="modal-line"></div>
    <div class="option" onclick="showAtualizarS();hideLogado()"><center>Alterar senha</center></div>
    <div class="modal-line"></div>
    <div class="option"><center><a onclick="validarRemover()">Apagar conta</a></center></div>
    <div class="modal-line"></div>
    <c:if test="${autenticado.isAdministrador == true}"> <!-- se o usuário logado for um adm, ele poderá cadastrar novos times, noticias, usuarios, jogadoras, campeonatos antigos -->
        <a href="MenuCadastro"><div class="option"><center>Menu ADM</center></div></a>
        <div class="modal-line"></div>
        </c:if>
    <div class="option"><center><a onclick="validarSair()"">Sair</a></center></div> <!--Aq é pra logout-->
    </div>
  </div>
  </div>
      </c:if>  
    
        <div class="login"> <!-- Modal para fazer login -->
      <div class="modal-login" id="modal-login">
        <div class="content-login">
          <span class="x" onclick="hideLogin()">&times;</span>
          LOGIN
          <form class="form" action="UsuarioLogin" method="post">
            E-Mail: <input type="email" name="email" placeholder="Digite seu endereço de E-Mail" required>
            Senha: <input type="password" name="senha" placeholder="Digite sua senha" required>
            <div id="k">
              <label class="container-label">Mantenha-me conectado
                  <input type="checkbox" id="manter" value="s" name="manter">
              <span class="checkmark"></span>
            </label>
          </div>
            <center><button type="submit" class="form-button">ENTRAR</button></center>
          </form>
          <center><div class="esquece">ESQUECEU A SENHA?</div></center>
        </div>
      </div>
    </div>
        
        <div class="cadastro"> <!-- Modal para cadastrar um novo usuário -->
      <div class="modal-cadastro" id="modal-cadastro">
        <div class="content-login">
          <span class="x" onclick="hideCadastro()">&times;</span>
          CADASTRO
          <form class="form-cadastro" action="UsuarioCadastrar" method="post">
            Nome: <input type="text" name="nome" placeholder="Digite seu nome de usuário" id="form-cadastro" required>
            E-Mail: <input type="email" name="email" placeholder="Digite seu endereço de E-Mail" id="form-cadastro" required>
            Senha: <input type="password" name="senha" placeholder="Digite sua senha" id="form-cadastro" required>
            Escolha seu time: 
            <div class="botaozinhos"> 
                <select name="selectTime" class="select-time">
            <c:forEach var="time" items="${times}">
                  <option value="${time.id}">${time.nome}</option>
             </c:forEach>
            </select>
          <c:if test="${autenticado.isAdministrador == true}"> <!-- ADM pode cadastrar um novo usuároi adm -->
                <div class="kadm">
              <label class="container-label">Administrador:
                  <input type="checkbox" id="adm" value="s" name="adm">
              <span class="checkmark"></span>
            </label>
          </div>
            </c:if>
            
          </div>
            <button type="submit" class="cadastro-button">CRIAR CONTA</button>
            </div>  
          <script src="main.js"></script>
          </form>
        </div>
      </div>
        <div class="atualizarS"> <!<!-- Modal para alterar senha -->
      <div class="modal-esquece" id="modal-esquece">
        <div class="content-login">
          <span class="x" onclick="hideAtualizarS()">&times;</span>
          ALTERAR SENHA
          <form action="AlterarSenha" method="post">
              Senha Antiga: <input type="password" name="senhaAntiga" id="form-cadastro" required>
              Senha Nova:  <input type="password" name="senhaNova" id="form-cadastro" required>
              <button type="submit" class="cadastro-button">Alterar Senha</button>
          </form>
        </div>
        </div>
      </div>
    </div>

    </body>
</html>
