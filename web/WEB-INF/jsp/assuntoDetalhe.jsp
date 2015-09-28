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
        <title><c:out value="${assunto.nome}"/></title>
        <link href="style/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1><c:out value="${assunto.nome}"/></h1>
        <div class="topico">
            <c:forEach var="topico" items="${topicos}">
                <a href="topico?id_topico=${topico.id}&id_assunto=${assunto.id}">
                    <li>${topico.titulo} - ${topico.nome}</li>
                </a>
            </c:forEach> 
        </div>
        <h2>Cadastrar novo tópico:</h2>
        <form method="POST" action="assunto?id=<c:out value="${assunto.id}"/>">     
            <label for="nome">Seu nome é:</label><input type="text" name="nome"/>
            <label for="titulo">Titulo do tópico:</label><input type="text" name="titulo"/>
            <!-- Adicionar pergunta em topico-->
            <label for="pergunta">Pergunta:</label><textarea name="pergunta" rows="4" cols="50"></textarea>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
