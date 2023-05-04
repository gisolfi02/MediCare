<%@ page import="java.io.File" %>
<%@ page import="java.io.FileReader" %>
<%@ page import="java.util.Scanner" %><%--
  Created by IntelliJ IDEA.
  User: Gioma
  Date: 14/03/2023
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Redirection to result page</title>
</head>
<body>
    <h1 style="text-align: center; font-family: Algerian">File results</h1>
    <%
        File file = (File) request.getAttribute("file");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
    %>

    <%=  in.nextLine()
    %>
    <br>
    <% }%>
</body>
</html>
