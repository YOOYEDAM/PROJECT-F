<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>신규 등록</title>
    <script src="js/validation.js"></script>
</head>
<body>
    <h2>신규 등록</h2>

    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>

    <form action="RegisterAction" method="post" onsubmit="return validateForm()">
        <label>이용자 ID:</label><input type="text" name="id" required><br>
        <label>패스워드:</label><input type="password" name="password" required><br>
        <label>이름:</label><input type="text" name="name" required><br>
        <label>이메일:</label><input type="email" name="email" required><br>
        <label>희망 부서:</label>
        <select name="department">
            <option value="개발">개발</option>
            <option value="마케팅">마케팅</option>
            <option value="영업">영업</option>
        </select><br>
        <input type="submit" value="등록">
    </form>
</body>
</html>
