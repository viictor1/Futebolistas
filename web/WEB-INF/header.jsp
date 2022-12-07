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
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="style.css" type="text/css">
        <link rel="stylesheet" href="everyone.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" integrity="sha512-1ycn6IcaQQ40/MKBW2W4Rhis/DbILU74C1vSrLJxCq57o941Ym01SwNsOMqvEBFlcgUa6xLiPY/NS5R+E6ztJQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <script type="text/javascript">
        async function logar(event){
            event.preventDefault();
            let data = new FormData(event.target);

            let resultado = await fetch('UsuarioLogin', {
                method: 'post',
                body: data
            });

            let resultadoData = await resultado.json();

            if(resultadoData.status){
                alert(resultadoData.Message);
            }
            else{
                window.location.href = "Hub";
            }
                
            
    }
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
        <div class="first">   
    <div id="decoration">
    <div id="barra"></div>
    <div id="textinho">SITE FOCADO NO <br> FUTEBOL FEMININO </div>
  </div>
        <div class="boasvindas">
      <c:if test="${autenticado != null}">Seja bem-vindo, ${autenticado.nome}!</c:if>
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
    </div>
        <c:if test="${autenticado == null}"> <!-- Se não tiver usuário logado, aparecerá esse menu -->
    <div class="side-menu">
      <div class="modal" id="modal">
        <div class="modal-content">
          <span class="x" onclick="hideModal()">&times;</span>
          <div id=modal-titulo>USUÁRIO</div>
          <div class="nada">
          <div class="modal-line"></div>          
          <div class="option" onclick="showLogin();hideModal()"><center>Login</center></div>
          <div class="modal-line"></div>
          <div class="option" onclick="showCadastro();hideModal()"><center>Registrar Conta</center></div>
          <div class="modal-line"></div>  
          </div>
        </div>
      </div>
    </div>
    </c:if>
        
        <c:if test="${autenticado != null}"> <!-- Se tiver usuário logado, apareerá essa tela -->
    <div class="side-menu" onclick="sh">
    <div class="modal-logado" id="modal-logado">
    <div class="content-logado">        
    <span class="x" onclick="hideLogado()">&times;</span>
    <div id="modal-titulo">${autenticado.nome}</div> <!--AQ É A VARIÁVEL DO NOME QUE O USUÁRIO ESCOLHEU -->
    <a href="SaibaMaisTime?id=${autenticado.time}"><div class="option"><center>Meu Time</center></div></a>
    <div class="modal-line"></div>
    <div class="option" onclick="showAtualizarS();hideLogado()"><center>Alterar Senha</center></div>
    <div class="modal-line"></div>
    <div class="option"><center><a onclick="validarRemover()">Apagar Conta</a></center></div>
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
            <div class="pra-centralizar">
                <div class="estiquetas">
                    <span onclick="hideLogin()"><i class="fa-solid fa-xmark j"></i></span>
                </div>
                <div class="b-cadastro">
                    <div class="l-left">
                        <span class="r">FAÇA</span>
                        <span class="r">SEU</span>
                        <span class="r">LOGIN</span>
                    </div>
                    <div class="middle"></div>
                    <div class="r-right">
                        <form class="form" action="UsuarioLogin" method="post" onsubmit="logar(event)">
                            <input type="email" name="email" class="j2" placeholder=" Seu E-Mail">
                            <input type="password" name="senha" class="j2" placeholder="Sua senha">
                          <div id="k">
                            <label class="container-label">Mantenha-me conectado
                                <input type="checkbox" id="manter" value="s" name="manter">
                            <span class="checkmark"></span>
                          </label>
                        </div>
                          <input type="submit" name="" value="Entrar" class="btn-j2"> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>    
        
        <div class="cadastro"> <!-- Modal para cadastrar um novo usuário -->
            <div class="modal-cadastro" id="modal-cadastro">
                <div class="pra-centralizar">
                    <div class="estiquetas">
                        <span onclick="hideCadastro()"><i class="fa-solid fa-xmark j3"></i></span>
                    </div>
                    <div class="b-cadastro2">
                        <div class="l-left">
                            <span class="r">CRIE</span>
                            <span class="r">SUA</span>
                            <span class="r">CONTA</span>
                        </div>
                        <div class="middle"></div>
                        <div class="r-right">
                            <form class="form-cadastro" action="UsuarioCadastrar" method="post">
                                <input type="text" name="nome" placeholder="Nome de usuário" class="j2" required>
                                <input type="email" name="email" placeholder="Seu E-Mail" class="j2" required>
                                <input type="password" name="senha" placeholder="Sua senha" class="j2" required>
                                Escolha seu time: 
                                <div class="botaozinhos"> 
                                    <select name="selectTime" class="select-time">
                                        <c:forEach var="time" items="${times}">
                                              <option value="${time.id}">${time.nome}</option>
                                         </c:forEach>
                                    </select>
                                    <c:if test="${autenticado.isAdministrador == true}"> <!-- ADM pode cadastrar um novo usuároi adm -->
                                        <div class="kadm">
                                            <label class="container-label">Administrador
                                                <input type="checkbox" id="adm" value="s" name="adm">
                                                <span class="checkmark"></span>
                                            </label>
                                        </div>
                                    </c:if>
                                </div>
                                <input type="submit" name="" value="Criar Conta" class="btn-j2"> 
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="atualizarS"> 
            <div class="modal-esquece" id="modal-esquece">
                <div class="pra-centralizar">
                    <div class="estiquetas">
                        <span onclick="hideAtualizarS()"><i class="fa-solid fa-xmark j"></i></span>
                    </div>
                    <div class="b-cadastro">
                        <div class="l-left">
                            <span class="r">CRIE</span>
                            <span class="r">SUA</span>
                        </div>
                        <div class="middle"></div>
                        <div class="r-right">
                            <form action="AlterarSenha" method="post">
                                <input type="password" name="senhaAntiga" class="j2" placeholder="Senha Atual" required>
                                <input type="password" name="senhaNova" class="j2" placeholder="Nova Senha" required>
                                <input type="submit" name="" value="Alterar Senha" class="btn-j2">
                            </form>
                        </div>
                    </div>
                </div>
                
                
            </div>
      </div>

    </body>
</html>
