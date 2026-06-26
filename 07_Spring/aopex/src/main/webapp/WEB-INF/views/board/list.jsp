<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

  <title>게시판</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/board.css">

</head>

<body>

<div class="container">

  <div class="card">

    <div class="top-bar">

      <h1>📋 게시판 목록</h1>

      <a class="btn"
         href="${pageContext.request.contextPath}/board/register">
        글쓰기
      </a>

    </div>

    <table>

      <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
      </tr>

      <c:forEach items="${list}" var="board">

        <tr>

          <td>${board.boardId}</td>

          <td>

            <a href="${pageContext.request.contextPath}/board/read/${board.boardId}">
                ${board.title}
            </a>

          </td>

          <td>${board.writer}</td>

        </tr>

      </c:forEach>

    </table>

  </div>

</div>

</body>
</html>