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
    </head>
    <body>
        <h1><c:out value="${assunto.nome}"/></h1>
        <h2>Cadastrar novo t�pico:</h2>
        <form method="POST" action="assunto?id=<c:out value="${assunto.id}"/>">     
            <label for="nome">Seu nome �:</label><input type="text" name="nome"/>
            <label for="titulo">Titulo do t�pico:</label><input type="titulo" name="nome"/>
            <input type="submit" value="enviar"/>
        </form>
    </body>
</html>