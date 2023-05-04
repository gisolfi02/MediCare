package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import model.Counter;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet("/all-users")
public class AllUsersSessionCounter extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = getServletContext();
        Counter counter = new Counter();
        Integer contatore = (Integer) context.getAttribute("contatore");

        if(contatore == null){
            contatore = 1;
            counter.setSessionCount(contatore);
        }
        else{
            contatore+=1;
            counter.setSessionCount(contatore);
        }

        context.setAttribute("contatore",contatore);
        request.setAttribute("counter",counter);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
