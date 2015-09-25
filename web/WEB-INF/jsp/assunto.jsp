<%-- 
    Document   : assunto
    Created on : Sep 14, 2015, 3:17:24 PM
    Author     : Alexandre
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="freeforum.model.enums.AssuntoEnum"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Assunto - Free forum!</title>
    </head>
    <body>
        <h1>Assuntos!</h1>
            <c:forEach var="assunto" items="${Assuntos}">
                <a href="assunto?id=${assunto.id}">
                    <word>${assunto.nome}</word>
                </a>
                <br />
            </c:forEach>
    </body>
</html>