<%-- 
    Document   : assunto
    Created on : Sep 14, 2015, 3:17:24 PM
    Author     : Alexandre
--%>

<!DOCTYPE HTML>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Assunto - Free forum!</title>
    </head>
    <body>
        <h1>Assuntos!</h1>
            <c:forEach var="assunto" items="${Assuntos}">
                <c:set var="quantidadeTop">0</c:set>
                <c:set var="quantidadeMsg">0</c:set>
                <c:set var="ultimaMensagem"></c:set>
                <c:forEach var="a" items="${assunto.topicos}">
                    <c:set var="quantidadeTop">${quantidadeTop=quantidadeTop+1}</c:set>
                </c:forEach>
                <c:forEach var="b" items="${assunto.mensagens}">
                    <c:set var="quantidadeMsg">${quantidadeMsg=quantidadeMsg+1}</c:set>
                </c:forEach>
                <a href="assunto?id=${assunto.id}">
                    <word>${assunto.nome}</word>
                </a>
                    Topicos - ${quantidadeTop}
                    Mensagens - ${quantidadeMsg}
                <c:forEach var="mensagem" items="${assunto.mensagens}">
                    <c:set var="ultimaMensagem">
                        <a href="topico?id_topico=${mensagem.topico.id}&id_assunto=${mensagem.assunto.id}">
                            ${mensagem.nome} - ${mensagem.data}
                        </a>
                    </c:set>
                </c:forEach>
                    ${ultimaMensagem}
                <br />
            </c:forEach>
    </body>
</html>