package freeforum.controler;

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
        List<AssuntoEnum> assuntos = new ArrayList<AssuntoEnum>();
        assuntos.add(AssuntoEnum.JOGOS);
        assuntos.add(AssuntoEnum.FILMES);
        assuntos.add(AssuntoEnum.COMIDA);
        assuntos.add(AssuntoEnum.MUSICA);
        assuntos.add(AssuntoEnum.SERIES);
        
        
        request.setAttribute("Assuntos", assuntos);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/WEB-INF/jsp/assunto.jsp");
        rd.forward(request, response);

    }
}
