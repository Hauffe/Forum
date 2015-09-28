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
        <title>${topico.titulo}</title>
        <link href="style/estilo.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <a class="voltar" href="assunto?id=<c:out value="${assunto.id}"/>">Voltar</a>
        <h1>${topico.titulo}</h1>
        <div class="mensagens">
            <div class="perguntadono">
                <div class="dono">
                    Por: ${topico.nome}<br/>
                    Em: ${topico.data}
                </div>
            <h2>${topico.pergunta}</h2>
            </div>
                <c:forEach var="mensagem" items="${mensagens}">
                    <div class="resposta">
                        <div class="respostadono">
                            Por: ${mensagem.nome}<br/>
                            Em: ${mensagem.data}
                        </div> 
                        <p class="triangle-isosceles left">
                            ${mensagem.conteudo}
                        </p>
                    </div>
                </c:forEach>
        </div>
        <div class="cadastro">
        <h2>Responder o tópico:</h2>
        <form method="POST" action="topico?id_topico=<c:out value="${topico.id}"/>&id_assunto=<c:out value="${assunto.id}"/>">
            <div class="nometitulo">
                <label for="nome">Seu nome é:</label><input type="text" name="nome"/>
            </div>
            <div class="pergunta">
                <label for="conteudo">Resposta:</label><textarea name="conteudo" rows="4" cols="50"></textarea>
                <input type="submit" value="enviar"/>
            </div>
        </form>
        </div>
    </body>
</html>
