<%-- 
    Document   : assuntoDetalhe
    Created on : Sep 24, 2015, 10:02:20 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>${assunto.nome}</title>
        <link href="style/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
            <a class="voltar" href="assuntos">Voltar</a>
        <h1>${assunto.nome}</h1>
            <c:forEach var="topico" items="${topicos}">
                <div class="topico">
                    <c:set var="quantidade"></c:set>
                    <c:set var="ultimaMensagem"></c:set>
                    <c:forEach var="mensagem" items="${topico.mensagens}">
                        <c:set var="quantidade">${quantidade=quantidade+1}</c:set>
                        <c:set var="ultimaMensagem">
                            <p><b>Ultimo acesso: </b>${mensagem.data}</p>
                            <p><b>Ultima mensagem de: </b>${mensagem.nome}</p>
                        </c:set>
                    </c:forEach>
                    <a href="topico?id_topico=${topico.id}&id_assunto=${assunto.id}">
                        <h2>${topico.titulo}</h2>
                        <p><b>Publicado por: </b>${topico.nome}
                        <br /><b>Em: </b>${topico.data}
                        <br /><b>Mensagens: </b>${quantidade}</p>
                        ${ultimaMensagem}
                    </a>
                </div>
            </c:forEach>
            <div class="cadastro">
                <h2>Cadastrar novo tópico:</h2>
                <form method="POST" action="assunto?id=<c:out value="${assunto.id}"/>">
                    <div class="nometitulo">
                        <label for="nome">Seu nome é:</label><input type="text" name="nome"/>
                        <label for="titulo">Titulo do tópico:</label><input type="text" name="titulo"/>
                    </div>
                    <div class="pergunta">
                        <label for="pergunta">Pergunta:</label><textarea name="pergunta" rows="4" cols="50"></textarea>
                        <input type="submit" value="enviar"/>
                    </div>
                </form>
            </div>
    </body>
</html>
