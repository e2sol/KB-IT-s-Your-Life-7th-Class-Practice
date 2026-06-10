<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<jsp:include page="header2.jsp" flush="true">
    <jsp:param name="nickName"
               value='<%= URLEncoder.encode("홍길동", "UTF-8") %>' />
</jsp:include>
<br>
<h1>Main3</h1>
<%
    String test = "홍길동test";
    out.println(test);
%>
</body>
</html>
