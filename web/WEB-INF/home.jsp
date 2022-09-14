<%-- 
    Document   : home
    Created on : 27/06/2022, 08:06:27
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
    <body <c:if test="${autenticado == null}">onload="showLogin()"</c:if>> <!-- Se usuário não estiver logado, aparecerá tela para realizar login -->
        <c:if test="${autenticado != null}"><script>alert("Seja bem vindo, ${autenticado.nome}!") </script></c:if> <!-- Saudação para usuário logado -->   
    <div id="decoration">
    <div id="barra"></div>
    <div id="textinho">SITE FOCADO NO <br> FUTEBOL FEMININO </div>
  </div>
        <div id="menu-login" onclick="<c:if test="${autenticado == nul}">showModal()</c:if> <c:if test="${autenticado != nul}">showLogado()</c:if>"> <!-- mudando o modal que aparecerá dependendo se o usuário está ou não logado -->
      <center>
      <div id="line-login"></div>
      <div id="line-login"></div> <!-- Menu do lado fechado -->
      <div id="line-login"></div>
      </center>
    </div>
        <c:if test="${autenticado == null}"> <!-- Se não tiver usuário logado, aparecerá esse menu -->
    <div class="side-menu">
      <div class="modal" id="modal">
        <div class="modal-content">
          <span onclick="hideModal()">&times;</span>
          <div id=modal-titulo>USUÁRIO</div>
          <div id="modal-line"></div>
          <div id="option" onclick="showLogin();hideModal()"><center>Login</center></div>
          <div id="modal-line"></div>
          <div id="option" onclick="showCadastro();hideModal()"><center>Registrar conta</center></div>
          <div id="modal-line"></div>
          <div id="option"><center>mais opções</center></div>
          <div id="modal-line"></div>
        </div>
      </div>
    </div>
    </c:if>
        
        <c:if test="${autenticado != null}"> <!-- Se tiver usuário logado, apareerá essa tela -->
    <div class="side-menu" onclick="sh">
    <div class="modal-logado" id="modal-logado">
    <div class="content-logado">        
    <span onclick="hideLogado()">&times;</span>
    <div id=modal-titulo>${autenticado.nome}</div> <!--AQ É A VARIÁVEL DO NOME QUE O USUÁRIO ESCOLHEU -->
    <div class="modal-line"></div>
    <div id="option"><center>Meu time</center></div>
    <div id="modal-line"></div>
    <div id="option" onclick="showAtualizarS();hideLogado()"><center>Alterar senha</center></div>
    <div id="modal-line"></div>
    <div id="option"><center><a onclick="validarRemover()">Apagar conta</a></center></div>
    <div id="modal-line"></div>
    <div id="option"><center><a onclick="validarSair()"">Sair</a></center></div> <!--Aq é pra logout-->
    </div>
  </div>
    <c:if test="${autenticado.isAdministrador == true}"> <!-- se o usuário logado for um adm, ele poderá cadastrar um novo usuário -->
            <div id="option" onclick="showCadastro();hideLogado()"><center>Cadastrar novo Usuário</center></div>
        </c:if>
  </div>
      </c:if>  
    
        <div class="login"> <!-- Modal para fazer login -->
      <div class="modal-login" id="modal-login">
        <div class="content-login">
          <span onclick="hideLogin()">&times;</span>
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
          <center><div class="esquece" onclick="showEsquece();hideLogin()">ESQUECEU A SENHA?</div></center>
        </div>
      </div>
    </div>
        
        <div class="cadastro"> <!-- Modal para cadastrar um novo usuário -->
      <div class="modal-cadastro" id="modal-cadastro">
        <div class="content-login">
          <span onclick="hideCadastro()">&times;</span>
          CADASTRO
          <form class="form-cadastro" action="UsuarioCadastrar" method="post">
            Nome: <input type="text" name="nome" placeholder="Digite seu nome de usuário" id="form-cadastro" required>
            E-Mail: <input type="email" name="email" placeholder="Digite seu endereço de E-Mail" id="form-cadastro" required>
            Senha: <input type="password" name="senha" placeholder="Digite sua senha" id="form-cadastro" required>
          <c:if test="${autenticado.isAdministrador == true}"> <!-- ADM pode cadastrar um novo usuároi adm -->
            Administrador: <input type="checkbox" name="adm" id="adm" value="s">
            </c:if>
            Escolha seu time: <br>
           <button type="submit" class="cadastro-button">CRIAR CONTA</button>
            <div class="select-box">
            <div class="options-container">
              <div class="option" id="option1">
                <input type="radio" class="radio"/>
                <label for="film">Atlético-MG</label>
              </div>
              <div class="option">
                <input type="radio" class="radio" />
                <label for="film">Corinthians</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">CRESSPOM</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Cruzeiro</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">ESMAC</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Ferroviária</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Flamengo</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Grêmio</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Internacional</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Avaí/Kinderman</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Palmeiras</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Real Brasília</label>
              </div>
              <div class="option">
                <input type="radio" class="radio"  />
                <label for="film">Red Bull Bragantino</label>
              </div>
            </div>
            <div class="selected">
              SELECIONE
            </div>
            <div class="search-box">
              <input type="text" placeholder="Procurar..." />
            </div>
          </div>
          <script src="main.js"></script>
          </form>
        </div>
      </div>
    </div>
        <div class="atualizarS"> <!<!-- Modal para alterar senha -->
      <div class="modal-esquece" id="modal-esquece">
        <div class="content-login">
          <span onclick="hideAtualizarS()">&times;</span>
          ALTERAR SENHA
          <form action="alterarSenha" method="post">
              Senha Antiga: <input type="password" name="senhaAntiga" id="form-cadastro" required>
              Senha Nova:  <input type="password" name="senhaNova" id="form-cadastro" required>
              <button type="submit" class="cadastro-button">Alterar Senha</button>
          </form>
        </div>
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
          </nav>
        </center>
    </div>
<center><div id="line"></div></center> <!-- Feed de notícias -->
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
