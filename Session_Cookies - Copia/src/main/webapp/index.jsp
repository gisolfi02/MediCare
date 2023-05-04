<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Scegli la servlet</title>
</head>
<body>
<h1 style="text-align: center">Quale servlet vuoi usare?</h1>
<form action="session-servlet" method="post">
    <input type="submit" value="Session" style="height: 60px; width: 100px" >
</form>
<br>
<form action="cookie-servlet" method="post" >
    <input type="submit" value="Cookie" style="height: 60px;width: 100px">
</form>
<br>
<form action="all-users" method="post">
    <input type="submit" value="Context" style="height: 60px;width: 100px">
</form>

<br/>

</body>
</html>