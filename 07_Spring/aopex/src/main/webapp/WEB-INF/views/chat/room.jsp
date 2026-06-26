<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>

    <title>채팅방</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/chat.css">

</head>

<body>

<div class="container">

    <h1>${room.roomName}</h1>

    <div id="chatArea"></div>

    <input type="text"
           id="sender"
           placeholder="닉네임">

    <input type="text"
           id="message"
           placeholder="메시지">

    <button onclick="sendMessage()">
        전송
    </button>

    <br><br>

    <a href="${pageContext.request.contextPath}/chat/rooms">
        채팅방 나가기
    </a>

</div>

<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>

<script>

    let stompClient = null;
    const roomId = ${room.roomId};

    connect();

    function connect() {

        const socket =
            new SockJS(
                '${pageContext.request.contextPath}/ws'
            );

        stompClient =
            Stomp.over(socket);

        stompClient.connect(
            {},
            function () {

                stompClient.subscribe(
                    '/topic/room/' + roomId,
                    function (message) {

                        showMessage(
                            JSON.parse(
                                message.body
                            )
                        );
                    }
                );
            }
        );
    }

    function sendMessage() {

        const sender =
            document.getElementById("sender").value;

        const message =
            document.getElementById("message").value;

        stompClient.send(
            "/app/chat.send/" + roomId,
            {},
            JSON.stringify({
                sender: sender,
                message: message
            })
        );

        document.getElementById(
            "message"
        ).value = "";
    }

    function showMessage(message) {

        const area =
            document.getElementById("chatArea");

        area.innerHTML +=
            '<div class="message">' +
            '<div class="sender">' +
            message.sender +
            '</div>' +
            '<div>' +
            message.message +
            '</div>' +
            '</div>';

        area.scrollTop = area.scrollHeight;
    }

</script>

</body>
</html>