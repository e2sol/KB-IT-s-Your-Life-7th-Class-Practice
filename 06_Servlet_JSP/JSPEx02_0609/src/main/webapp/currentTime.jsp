<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>현재 날짜 출력 실습</h1>
<%
    Date date = new Date();
%>
<p>현재 날짜 : <%=date%></p>
</body>
</html>
