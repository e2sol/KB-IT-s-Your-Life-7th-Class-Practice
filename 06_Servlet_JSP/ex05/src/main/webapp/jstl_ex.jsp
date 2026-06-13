<%--
  Created by IntelliJ IDEA.
  User: hj409
  Date: 26. 6. 12.
  Time: 오후 5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>JSTL 테스트</h1>
<h3>role 속성값 검사</h3>
<c:choose>
    <c:when test="${role eq 'ADMIN'}">
        <p>관리자</p>
    </c:when>
    <c:otherwise>
        <p>일반회원</p>
    </c:otherwise>
</c:choose>

<h3>members 목록 이용하여 table로 출력</h3>
<table>
    <tbody>
    <c:forEach var="member" items="${members}" varStatus="status">
        <tr>
            <td>${status.index} | ${member.name} | ${member.userid}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<h3>Date 속성 관련 출력 (fmt 태그 이용 예제)</h3>
단순 객체 출력 : ${today}<br>
type : date >>  <fmt:formatDate value="${today}" type="date"/><br>
type : time >>  <fmt:formatDate value="${today}" type="time"/><br>
type : both >>  <fmt:formatDate value="${today}" type="both"/><br>
type : both & dateStyle : short & timeStyle : long >>  <fmt:formatDate value="${today}" type="both" dateStyle="short" timeStyle="long"/><br>
type : both & dateStyle : long & timeStyle : short >>  <fmt:formatDate value="${today}" type="both" dateStyle="long" timeStyle="short"/><br>
pattern 이용 >>  <fmt:formatDate value="${today}" pattern="YYYY-MM-dd HH:mm:ss"/> <br>
pattern 이용 >>  <fmt:formatDate value="${today}" pattern="YYYY-MM-dd a HH:mm:ss"/>
</body>
</html>
