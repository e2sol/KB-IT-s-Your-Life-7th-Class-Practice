<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 11.
  Time: 오후 4:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>상품 리스트</h1>
<h5>쿠키 관련 실습</h5>
<form action="cart_save_cookie" method="get">
    <input type="radio" name="product" value="BMW"> BMW <br>
    <input type="radio" name="product" value="SM5"> SM5 <br>
    <input type="radio" name="product" value="K7"> K7 <br>
    <input type="submit" value="카트 저장">
</form>
</body>
</html>
