<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>

  <title>게시글 상세</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/board.css">

</head>

<body>

<div class="container">

  <h1>${board.title}</h1>

  <p>
    작성자 :
    ${board.writer}
  </p>

  <hr>

  <pre>${board.content}</pre>

  <hr>

  <h3>첨부파일</h3>

  <ul>

    <c:forEach items="${board.attachments}"
               var="file">

      <li>

        <a href="${pageContext.request.contextPath}/board/download/${file.attachId}">
            ${file.fileName}
        </a>

      </li>

    </c:forEach>

  </ul>

  <a href="${pageContext.request.contextPath}/board/list">
    목록
  </a>

</div>

</body>
</html>