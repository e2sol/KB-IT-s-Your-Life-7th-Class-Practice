<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>방문자수 설정하기 화면</h1>
<%! int count; %>
<%
    count++;
    application.setAttribute("countValue", count);
%>
<p>현재 방문자수 : <%=count%></p>
</body>
</html>
