package freeforum.controler;

import freeforum.model.Assunto;
import freeforum.model.AssuntoMng;
import freeforum.model.IAssuntoMng;
import freeforum.model.enums.AssuntoEnum;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AssuntoServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Assunto> assuntos = new ArrayList<Assunto>();
        
        IAssuntoMng manager = new AssuntoMng();
        assuntos = manager.obterTodos();
        request.setAttribute("Assuntos", assuntos);
        
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assunto.jsp");
        rd.forward(request, response);

    }
}
