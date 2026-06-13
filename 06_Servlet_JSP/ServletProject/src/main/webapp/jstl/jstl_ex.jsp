<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 12.
  Time: 오후 3:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
  <title>JSTL 예제</title>
</head>
<body>
<%-- 예제 코드 작성 --%>
<c:set var="username" value="KB_User" scope="request" />
<p>사용자 이름: ${username}</p>


<hr>
<c:set var="message" value="<b>Hello</b> JSTL!" />
<p>이스케이프 안 함: <c:out value="${message}" escapeXml="false" /></p>
<p>이스케이프 함: <c:out value="${message}" /></p>
<p>이스케이프 안 함 > 문자열 내 HTML 코드가 해석되어 화면에 출력</p>
<p>이스케이프 진행 > 문자열 내 HTML 코드가 해석되지 않고 문자열로 화면에 출력</p>

<c:set var="undefinedVar" />
<p>기본값: <c:out value="${undefinedVar}" default="값이 없습니다" /></p>


<hr>
<p>if문 연습</p>
<c:set var="score" value="85" />
<c:if test="${score >= 90}">
  <p>점수가 90점 이상입니다 (A학점)</p>
</c:if>
<c:if test="${score < 60}">
  <p>점수가 60점 미만입니다 (F학점)</p>
</c:if>


<hr>
<c:set var="grade" value="B" />
<c:choose>
  <c:when test="${grade eq 'A'}">
    <p>Excellent!</p>
  </c:when>
  <c:when test="${grade eq 'B'}">
    <p>Good!</p>
  </c:when>
  <c:otherwise>
    <p>Try Harder!</p>
  </c:otherwise>
</c:choose>


<hr>
<%-- 숫자 반복 --%>
<p>1부터 5까지 반복:</p>
<ul>
  <c:forEach var="i" begin="1" end="5">
    <li>${i}</li>
  </c:forEach>
</ul>

<%-- 배열/리스트 반복 --%>
<c:set var="fruits" value="${['사과', '바나나', '오렌지', '포도']}" />
<p>과일 목록:</p>
<ul>
  <c:forEach var="fruit" items="${fruits}" varStatus="status">
    <li>${status.index}. ${fruit} ${status.first ? '(첫 번째)' : ''} ${status.last ? '(마지막)' : ''}</li>
  </c:forEach>
</ul>


<hr>
<%-- URL 생성 --%>
<%--원하는 경로 뒤 파라미터 값을 더해 URL을 생성할 수 있다.--%>
<c:url var="myUrl" value="/user/profile.jsp">
  <c:param name="id" value="kbuser" />
  <c:param name="mode" value="view" />
</c:url>
<p>생성된 URL: <a href="${myUrl}">${myUrl}</a></p>

<%-- 리다이렉트 (실행하면 이 페이지가 아닌 다른 페이지로 이동) --%>
<%--
<c:redirect url="<http://www.google.com>" />
<c:redirect url="/anotherPage.jsp">
    <c:param name="redirected" value="true" />
</c:redirect>
--%>
</body>
</html>
