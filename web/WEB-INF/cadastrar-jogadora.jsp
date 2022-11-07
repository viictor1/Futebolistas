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
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import> 
        
        <div class="pra-centralizar">
           <div class="estiquetas">
                <a href="MenuCadastro"><i class="fa-solid fa-chevron-left j"></i></a>
            </div> 
            <div class="b-cadastro">
                <div class="l-left">
                    <span class="r">MENU</span>
                    <span class="r">JOGADORAS</span>
                </div>
                <div class="middle"></div>
                <div class="r-right">
                    <div class="form-this">
                    <form action="JogadoraCadastrar" method="post">         
                        <input type="text" name="nome" class="cadastro-j" placeholder="Nome" value="${editar.nome}">    
                    <input type="hidden" name="id" value="${editar.id}">
                    <input type="submit" name="" value="Concluir" class="btn-j">
                   </form>
                    </div>
                    
                
                    <div class="form-this2">
                    <c:if test="${editar.id == null}">
                    <span class="n">Apagar Jogadora</span>
                    <form action="RemoverJogadora" method="post">
                        <div class="custom-select">
                          <select name="selectJ" class="select-jogadora">
                            <c:forEach var="jogadora" items="${jogadoras}">
                                  <option value="${jogadora.id}">${jogadora.nome}</option>
                            </c:forEach>
                        </select> 
                        </div>                          
                        <!-- apagar depois -->
                        <input type="submit" name="" value="Remover" class="btn-j">  
                        
                     </form>
                    </c:if>    
                    <a href="ListarJogadoras">Listar Jogadoras</a>
                    </div>
                </div>          
            </div>   
        </div>
    </body>
</html>
