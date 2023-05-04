package controller;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Counter;

@WebServlet("/session-servlet")
public class SessionServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        synchronized (session){
            Counter counter = new Counter();
            Integer contatore = (Integer) session.getAttribute("contatore");
            if(contatore == null){
                contatore = 1;
                counter.setSessionCount(contatore);
            }
            else{
                contatore+=1;
                counter.setSessionCount(contatore);

            }

            session.setAttribute("contatore",contatore);
            request.setAttribute("counter",counter);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
            dispatcher.forward(request,response);
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
