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
import freeforum.model.ITopicoMng;
import freeforum.model.Topico;
import freeforum.model.TopicoMng;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexandre
 */
public class AssuntoDetalheServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Topico> topicos = new ArrayList<Topico>();
        int id;
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        ITopicoMng maneger = new TopicoMng();
        topicos = maneger.selecionarPorAssunto(obterAssunto(request, id));
        
        request.setAttribute("topicos", topicos);
        request.setAttribute("assunto", obterAssunto(request, id));
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assuntoDetalhe.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id;
        Date data = new Date(System.currentTimeMillis());
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        
        ITopicoMng maneger = new TopicoMng();
        Assunto assunto = obterAssunto(request, id);
        Topico topico = new Topico(assunto);
        topico.setData(data);
        topico.setMensagens(null);
        topico.setTitulo(request.getParameter("titulo"));
        topico.setNome(request.getParameter("nome"));
        topico.setPergunta(request.getParameter("pergunta"));
        maneger.novoTopico(topico);
        
        response.sendRedirect("assunto?id="+id);
        
        
    }
    
    protected Assunto obterAssunto(HttpServletRequest request, int id){
        Assunto assunto;
        IAssuntoMng maneger = new AssuntoMng();
        assunto = maneger.obterPorId(id);
        return assunto;
    }

}
