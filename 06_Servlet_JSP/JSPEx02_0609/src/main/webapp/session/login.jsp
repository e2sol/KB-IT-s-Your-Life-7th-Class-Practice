<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 10.
  Time: 오전 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>로그인 정보 세션 저장</h1>
<%
    javax.servlet.jsp.JspWriter writer = out;
%>
<%
    String id = request.getParameter("userid");

    if (id == null) response.sendRedirect("loginForm.html");
    else {
        String pw = request.getParameter("password");
        session.setAttribute("userId", id);
        session.setAttribute("userPw", pw);
        out.println("안녕하세요 " + id);
        out.println("<br> <a href='loginInfo.jsp'>정보보기</a>");
    }
%>
</body>
</html>
