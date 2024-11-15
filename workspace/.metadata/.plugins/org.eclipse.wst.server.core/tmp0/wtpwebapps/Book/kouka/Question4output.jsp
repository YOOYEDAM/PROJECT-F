<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<h1>Question4</h1>
<meta charset="UTF-8">
<title>Servlet/JSP Samples</title>
</head>
<body>
<% request.setCharacterEncoding("UTF-8"); %>
<p>入力されたお名前は．．．</p>
<p><%=request.getParameter("user") %></p>
<p>ですね！</p>


