<%@page contentType="text/html; charset=UTF-8" %>

<%--headerの読み込み--%>
<%@include file="../header.html" %>

<%--式の結果を暗黙オブジェクト「out」で出力--%>
<p><% out.println(Math.random()); %></p>

<%--式の結果をそのまま出力--%>
<p><%=Math.random() %></p>

<%--footerの読み込み--%>
<%@include file="../footer.html" %>