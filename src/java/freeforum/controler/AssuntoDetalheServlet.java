/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freeforum.controler;

import freeforum.model.Assunto;
import freeforum.model.AssuntoMng;
import freeforum.model.IAssuntoMng;
import java.io.IOException;
import java.io.PrintWriter;
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
        int id;
        Assunto assunto;
        String idParam;
        idParam = request.getParameter("id");
        id = Integer.parseInt(idParam);
        IAssuntoMng maneger = new AssuntoMng();
        assunto = maneger.obterPorId(id);
        
        request.setAttribute("assunto", assunto);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assuntoDetalhe.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

}
