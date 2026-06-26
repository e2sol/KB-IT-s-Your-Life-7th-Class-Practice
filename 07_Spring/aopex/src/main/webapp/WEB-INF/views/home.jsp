<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>

    <meta charset="UTF-8">

    <title>Board & Chat System</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/home.css">

</head>

<body>

<div class="hero">

    <div class="hero-card">

        <h1>📚 Board & Chat System</h1>

        <p>
            Spring MVC · MyBatis · WebSocket(STOMP)
        </p>

        <div class="hero-buttons">

            <a href="${pageContext.request.contextPath}/board/list"
               class="btn">
                게시판 이동
            </a>

            <a href="${pageContext.request.contextPath}/chat/rooms"
               class="btn">
                채팅방 이동
            </a>

        </div>

    </div>

</div>

<div class="container">

    <div class="feature-card">

        <div class="icon">📝</div>

        <h2>게시판</h2>

        <p>
            게시글 작성 및 조회<br>
            첨부파일 BLOB 저장 지원
        </p>

    </div>

    <div class="feature-card">

        <div class="icon">💬</div>

        <h2>실시간 채팅</h2>

        <p>
            STOMP 기반<br>
            채팅방별 메시지 분리
        </p>

    </div>

</div>

<footer>

    Spring MVC Project

</footer>

</body>
</html>