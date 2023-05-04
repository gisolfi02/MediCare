package controller;
import java.io.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Counter;

@WebServlet("/cookie-servlet")
public class CookieServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isFound = false;
        int counter = 1;
        Counter count = new Counter();
        Cookie[] cookies =  request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("cookie")){
                    isFound = true;
                    counter += Integer.parseInt(cookie.getValue());
                    count.setSessionCount(counter);
                }
            }
        }
        if(!isFound)
            count.setSessionCount(counter);

        Cookie c = new Cookie("cookie",Integer.toString(counter));
        c.setSecure(true);
        c.setMaxAge(5);
        c.setPath("/");
        response.addCookie(c);
        request.setAttribute("counter",count);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view.jsp");
        dispatcher.forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


