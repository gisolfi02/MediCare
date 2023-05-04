<%@ page import="java.util.List" %>
<%@ page import="model.Prodotto" %>
<%@ page import="model.ProdottoDAO" %>
<%@ page import="model.Categoria" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Categorie</title>
</head>
<style>
    table, th, td {
        border:1px solid black;
    }
</style>
<body>
    <table style="width: 100%">
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrizione</th>
            <th>Prezzo</th>
        </tr>
        <%
            List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
            for(Prodotto p : prodotti){%>
            <tr>
                <th>
                <%=p.getId()%>
                </th>
                <th>
                    <%=p.getNome()%>
                </th>
                <th>
                    <%=p.getDescrizione()%>
                </th>
                <th>
                    <%=p.getPrezzo()%>
                </th>
            </tr>
        <%}%>
    </table>

    <form action="CategoriaServlet">
Scegli la categoria: <select name="CategoriaChoice">
        <%
            List<Categoria> categorie = (List<Categoria>) application.getAttribute("categorie");
            for(Categoria c : categorie){%>
            <option value="<%=c.getId()%>"><%=c.getNome()%></option>
        <%}%>
    </select>
        <input type="submit" value="Invia">
    </form>
</body>
</html>