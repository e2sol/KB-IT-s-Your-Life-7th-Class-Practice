<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 9:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 입력 파라미터 출력</h1>
<%
    String id = request.getParameter("userid");
    String pw = request.getParameter("password");
%>
<p>아이디값: <%=id%></p>
<p>비밀번호: <%=pw%></p>
</body>
</html>
