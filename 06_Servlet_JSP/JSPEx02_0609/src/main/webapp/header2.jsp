<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 11:25
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%

    request.setCharacterEncoding("UTF-8");
    String nickName = URLDecoder.decode(
            request.getParameter("nickName"),
            "UTF-8"
    );
    System.out.print(nickName);
    Calendar calendar = Calendar.getInstance();
    int hour = calendar.get(Calendar.HOUR_OF_DAY);
    int min = calendar.get(Calendar.MINUTE);
    int sec = calendar.get(Calendar.SECOND);
%>
<p>안녕하세요 당신의 닉네임은 <%=nickName%>입니다.</p>
<p>현재 시간 >> <%=hour%>:<%=min%>:<%=sec%></p>
</body>
</html>
