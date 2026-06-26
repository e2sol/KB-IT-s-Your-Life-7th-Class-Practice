<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <title>채팅방 목록</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/chat.css">

</head>

<body>

<div class="container">

    <div class="card">

        <h1>💬 채팅방 목록</h1>

        <form action="${pageContext.request.contextPath}/chat/create"
              method="post">

            <input type="text"
                   name="roomName"
                   placeholder="채팅방 이름">

            <button type="submit">
                방 만들기
            </button>

        </form>

        <br>

        <c:forEach items="${rooms}" var="room">

            <div class="room">

                <div>

                    <h3>${room.roomName}</h3>

                </div>

                <a href="${pageContext.request.contextPath}/chat/${room.roomId}">
                    <button>
                        입장
                    </button>
                </a>

            </div>

        </c:forEach>

    </div>

</div>

</body>
</html>