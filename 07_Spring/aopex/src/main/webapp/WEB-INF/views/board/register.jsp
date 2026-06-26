<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

  <title>게시글 등록</title>

  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/board.css">

</head>

<body>

<div class="container">

  <div class="card">

    <h1>📝 게시글 등록</h1>

    <form action="${pageContext.request.contextPath}/board/register"
          method="post"
          enctype="multipart/form-data">

      <div class="form-group">

        <label>제목</label>

        <input type="text"
               name="title"
               required>

      </div>

      <div class="form-group">

        <label>작성자</label>

        <input type="text"
               name="writer"
               required>

      </div>

      <div class="form-group">

        <label>내용</label>

        <textarea name="content"
                  rows="8"></textarea>

      </div>

      <div class="form-group">

        <label>첨부파일</label>

        <input type="file"
               name="files"
               multiple>

      </div>

      <div class="button-area">

        <button type="submit"
                class="btn">
          등록
        </button>

        <a href="${pageContext.request.contextPath}/board/list"
           class="btn secondary">
          목록
        </a>

      </div>

    </form>

  </div>

</div>

</body>
</html>