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
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <!-- ===== Fontawesome CDN Link ===== -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- ===== CSS ===== -->
    <link rel="stylesheet" href="estilo.css">
    <script src="https://kit.fontawesome.com/46a2e52881.js" crossorigin="anonymous"></script>
    </head>
    <body>
        <c:import url="header.jsp"></c:import>
        <div class="pra-centralizar">
            <div class="estiquetas">
                <a href="MenuCadastro"><i class="fa-solid fa-chevron-left j3"></i></a>
            </div>  
            <div class="b-cadastro-big">
                <div class="l-left">
                    <span class="r">MENU</span>
                    <span class="r">PARA</span>
                    <span class="r">CADASTRO</span>
                    <span class="r">DE</span>
                    <span class="r">TIME</span>
                </div>
                <div class="middle"></div>
                <div class="r-right">
                    <form class="" action="CadastrarTimes?id=${alterar.id}" method="post" enctype="multipart/form-data">
                        <c:if test="${alterar.id != null}">
                        <input type="hidden" id="id" name="idArquivo" value="${alterar.idArquivo}">
                        </c:if>
                    <input type="text" name="nome" value="${alterar.nome}" class="cadastro-j" placeholder="Nome do time" required>
                    <input type="date" name="data" value="${alterar.data_fundacao}" class="cadastro-j" placeholder="Ano de Fundação" required>
                    <input type="text" name="tecnico" value="${alterar.tecnico}" class="cadastro-j" placeholder="Técnico" required>
                    <input type="text" name="presidente" value="${alterar.presidente}" class="cadastro-j" placeholder="Presidente" required>
                    <input type="text" name="local" value="${alterar.local_fundacao}" class="cadastro-j" placeholder="Local de Fundação" required>
                    <label for="file" class="file cadastro-j">Logo do time
                      <i class="fa-solid fa-image"></i>
                    </label>
                    <input type="file" name="imagem" id="file" value="" class="cadastro-j">
                    <input type="submit" name="" value="Concluir" class="btn-j">   
                  </form>
                </div>
            </div>
        </div>
    </body>
</html>
