<%-- 
    Document   : jogadora_time
    Created on : 18/10/2022, 17:03:48
    Author     : maluc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <c:import url="menu.jsp"></c:import>
        
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="SaibaMaisTime?id=${id}"><i class="fa-solid fa-chevron-left j"></i></a>
            </div>
            <div class="b-cadastro">
                <div class="l-left">
                    <span class="r">MENU</span>
                    <span class="r">PARA</span>
                    <c:if test="${jt.posicao != null}">
                        <span class="r">ALTERAÇÃO</span>
                    </c:if>
                    <c:if test="${jt.posicao == null}">
                        <span class="r">CADASTRO</span>
                    </c:if>
                    <span class="r">DE</span>
                    <span class="r">JOGADORAS</span>
                </div> 
                <div class="middle"></div>
                <div class="r-right">
                    <form action="Jogadora_TimeServlet" method="post">
                    <c:if test="${jt.posicao != null}">
                        <span class="r-little">Data de Fim:</span> <input type="date" name="data_fim" class="cadastro-j">
                        <input type="hidden" value="${jt.id}" name="alterando"> <!-- Para verificar se está alterando ou cadastrando -->
                        <input type="hidden" value="${jt.id_jogadora}" name="id_jogadora">
                    </c:if>
                    <c:if test="${jt.posicao == null}">
                        <span class="r-little">Data de inicio:</span> <input type="date" name="data_inicio" class="cadastro-j" required>
                    </c:if>
                        <span class="r-little">Número:</span> <input type="number" name="numero" class="cadastro-j" value="${jt.numero_atual}" required>
                    <span class="r-little">Posição:</span> <input type="text" name="posicao" class="cadastro-j" value="${jt.posicao}" required>
                    <input type="hidden" value="${id}" name="id">
                    <div class="custom-select"> 
                    <c:if test="${jt.posicao == null}">
                    <select name="selectJ" class="select-jogadora">
                        <c:forEach var="jogadora" items="${jogadoras}">
                              <option value="${jogadora.id}">${jogadora.nome}</option>
                        </c:forEach>
                   </select> 
                    </c:if>
                   </div>
                    <input type="submit" name="" value="Concluir" class="btn-j">
                </form>
                </div>
            </div>
        </div>
    </body>
</html>
