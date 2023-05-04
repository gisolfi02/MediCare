package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Categoria;
import model.CategoriaDAO;
import model.Prodotto;
import model.ProdottoDAO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriaServlet", value = "/CategoriaServlet")
public class CategoriaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("CategoriaChoice"));
        CategoriaDAO serviceCategoria = new CategoriaDAO();

        Categoria categoria = serviceCategoria.doRetrievById(id);
        ProdottoDAO serviceProdotto = new ProdottoDAO();

        List<Prodotto> prodotti = serviceProdotto.doRetriveByCategoria(categoria.getId());
        request.setAttribute("categoria",categoria);
        request.setAttribute("prodotti",prodotti);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/categoria.jsp");
        dispatcher.forward(request,response);
    }
}
