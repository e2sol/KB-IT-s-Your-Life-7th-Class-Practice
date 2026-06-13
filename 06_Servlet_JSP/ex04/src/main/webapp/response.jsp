<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 11.
  Time: 오후 5:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = (String) request.getAttribute("username");
    String useraddress = (String) request.getAttribute("useraddress");
%>
username 값 : <%=username%> <br>
useraddress 값 : <%=useraddress%>
</body>
</html>
