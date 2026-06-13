<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<h3>실습풀이 링크</h3>
<a href="session_product.jsp">상품 리스트 화면으로 이동</a><br>
<br>
<h3>심화 실습 풀이 링크</h3>
<a href="cookie_product.jsp">쿠키 실습 화면으로 이동</a><br>
<br>
<hr>
<h3>요청 포워딩 심화 실습 풀이 링크</h3>
<a href="/request">요청 포워딩 관련 실습</a><br>
<a href="/request_redirect">리다이렉트 : request_redirect로 이동</a><br>
<a href="/response_redirect">리다이렉트 : response_redirect로 이동</a><br>
</body>
</html>