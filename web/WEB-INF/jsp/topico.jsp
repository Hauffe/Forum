<%-- 
    Document   : topico
    Created on : Sep 27, 2015, 2:14:00 PM
    Author     : Alexandre
--%>


<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title><c:out value="${topico.titulo}"/></title>
    </head>
    <body>
        <h1><c:out value="${topico.titulo} - ${topico.pergunta}"/></h1>
        <div>
            <c:forEach var="mensagens" items="${mensagens}">
                <div>
                    <p>${mensagens.nome} - ${mensagens.conteudo}</p>                
                </div>
            </c:forEach>
        </div>
         <h2>Responder o tópico:</h2>
        <form method="POST" action="topico?id_topico=<c:out value="${topico.id}"/>&id_assunto=<c:out value="${assunto.id}"/>">     
            <label for="nome">Seu nome é:</label><input type="text" name="nome"/>
            <label for="conteudo">Resposta:</label><textarea name="conteudo" rows="4" cols="50"></textarea>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>
