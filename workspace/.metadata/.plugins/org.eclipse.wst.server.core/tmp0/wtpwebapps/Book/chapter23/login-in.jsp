<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<form action="Login.action" method="post">
<p><input type="text" name="login"></p>
<p>ログイン<input type="password" name="password"></p>
<p><input type="submit" value="ログイン"></p>
</form>

<%@include file="../footer.html" %>