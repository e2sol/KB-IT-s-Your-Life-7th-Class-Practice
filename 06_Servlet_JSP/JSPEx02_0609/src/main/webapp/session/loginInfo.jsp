<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 보기</h1>
<%
    String id = (String) session.getAttribute("userId");
    String pw = (String) session.getAttribute("userPw");
%>
사용자 아이디값: <%=id%> <br>
사용자 비밀번호값: <%=pw%> <br>
<a href="logout.jsp">로그아웃</a>
</body>
</html>
