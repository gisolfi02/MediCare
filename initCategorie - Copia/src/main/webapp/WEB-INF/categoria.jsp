<%@ page import="model.Categoria" %>
<%@ page import="model.Prodotto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Gioma
  Date: 06/04/2023
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prodotti Categoria</title>
</head>
<style>
    table, th, td{
        border: 1px solid black;
    }
</style>

<body>
<h1><%Categoria cat = (Categoria) request.getAttribute("categoria");%><%=cat.getNome().toUpperCase()%></h1>
<h2> Queste/i sono i/le <%=cat.getNome().toUpperCase()%> </h2>
<table style="width: 100%">
    <tr>
        <th>Nome</th>
        <th>Descrizione</th>
    </tr>
    <%
        List<Prodotto> prodotti = (List<Prodotto>) request.getAttribute("prodotti");
        for(Prodotto p : prodotti){%>
        <tr>
            <th><%=p.getNome()%></th>
            <th><%=p.getDescrizione()%></th>
            <th><%=p.getPrezzo()%></th>
        </tr>
    <%}%>
</table>
<a href="index.html">Torna alla lista dei prodotti</a>
</body>
</html>
