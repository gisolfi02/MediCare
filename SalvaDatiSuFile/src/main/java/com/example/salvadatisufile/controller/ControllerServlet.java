package com.example.salvadatisufile.controller;

import com.example.salvadatisufile.model.JavaBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.text.html.HTMLFrameHyperlinkEvent;
import java.io.*;

@WebServlet("/file-servlet")
public class ControllerServlet extends HttpServlet {

    @Override
   public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
       response.setContentType("html/text");
       File file = new File("C:\\Users\\Gioma\\IdeaProjects\\TSW\\SalvaDatiSuFile\\src\\main\\resources\\data.txt");

       JavaBean bean = new JavaBean();

       String email = request.getParameter("email");
       String password = request.getParameter("pass");

       FileWriter stream = new FileWriter(file,true);
       stream.append("Email: "+ email + " -- Password: " + password +"\n");
       stream.flush();
       bean.setFile(file);
       request.setAttribute("file",file);
       RequestDispatcher dispatcher = request.getRequestDispatcher("control.jsp");
       dispatcher.forward(request, response);
   }

}
