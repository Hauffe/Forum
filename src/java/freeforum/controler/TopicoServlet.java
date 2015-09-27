/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.controler;

import freeforum.dao.ITopicoDAO;
import freeforum.model.Assunto;
import freeforum.model.AssuntoMng;
import freeforum.model.IAssuntoMng;
import freeforum.model.IMensagemMng;
import freeforum.model.ITopicoMng;
import freeforum.model.Mensagem;
import freeforum.model.MensagemMng;
import freeforum.model.Topico;
import freeforum.model.TopicoMng;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre
 */
public class TopicoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Mensagem> mensagens = new ArrayList<Mensagem>();
            int id_assunto, id_topico;
            String id_assuntoS, id_topicoS;
            id_topicoS = request.getParameter("id_topico");
            id_topico = Integer.parseInt(id_topicoS);
            id_assuntoS = request.getParameter("id_assunto");
            id_assunto = Integer.parseInt(id_assuntoS);
            
            Assunto assunto = obterAssunto(request, id_assunto);
            Topico topico = obterTopico(request, id_topico, assunto);

            IMensagemMng manegerMsg = new MensagemMng();
            mensagens = manegerMsg.selecionarPorTopico(topico, assunto);

            request.setAttribute("mensagens", mensagens);
            request.setAttribute("topico", topico);
            request.setAttribute("assunto", assunto);
        } catch (Exception e) {
            throw e;
        }
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/topico.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            int id_assunto, id_topico;
            String id_assuntoS, id_topicoS;
            id_topicoS = request.getParameter("id_topico");
            id_topico = Integer.parseInt(id_topicoS);
            id_assuntoS = request.getParameter("id_assunto");
            id_assunto = Integer.parseInt(id_assuntoS);
            Date data = new Date(System.currentTimeMillis());
            
            Assunto assunto = obterAssunto(request, id_assunto);
            Topico topico = obterTopico(request, id_topico, assunto);
            
            IMensagemMng maneger = new MensagemMng();
            Mensagem mensagem = new Mensagem(topico, assunto);
            mensagem.setNome(request.getParameter("nome"));
            mensagem.setData(data);
            mensagem.setConteudo(request.getParameter("conteudo"));
            mensagem.setTopico(topico);
            mensagem.setAssunto(assunto);
            maneger.inserirMensagem(mensagem);
            

    }
    
    
    protected Assunto obterAssunto(HttpServletRequest request, int id){
        Assunto assunto;
        IAssuntoMng maneger = new AssuntoMng();
        assunto = maneger.obterPorId(id);
        return assunto;
        
    }
    protected Topico obterTopico(HttpServletRequest request, int id, Assunto assunto){
        Topico topico;
        ITopicoMng maneger = new TopicoMng();
        topico = maneger.selecionarPorId(id, assunto);
        return topico;
    }

}
