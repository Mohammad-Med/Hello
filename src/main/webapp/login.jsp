<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href='style.css'>
</head>
<body>
<h1>Benvenus</h1>
<form method="post" action="login">
<label for='log'>Login</label> <input type="text" name="login" id='log' value='${login }' placeholder="votre nom"> <br> <br>
<label for='pass'>Password</label> <input type="password" name="pass" id="pass" value="${password }" placeholder="votre mot de passe"> <br> <br>
<input type="submit" value="Connect">
<div>${error}</div>
</form>
<
</body>
</html>