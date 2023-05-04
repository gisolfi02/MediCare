<%@ page import="model.Counter" %>
<%@ page import="javax.swing.plaf.IconUIResource" %>
<%@ page import="javax.swing.plaf.basic.BasicOptionPaneUI" %><%--
  Created by IntelliJ IDEA.
  User: Gioma
  Date: 23/03/2023
  Time: 09:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Representation page</title>
</head>
<body>
<% Counter count = (Counter) request.getAttribute("counter");%>
<h1 style="text-align: center">Gli accessi fatto sono in tutto  <%= count.getCounter()%></h1>
</body>
</html>
