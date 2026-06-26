package org.scoula.websocket;

import lombok.RequiredArgsConstructor;
import org.scoula.domain.ChatMessageVO;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatMessageController {

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.send/{roomId}")
    public void sendMessage(
            @DestinationVariable Long roomId,
            ChatMessageVO message
    ) {

        message.setRoomId(roomId);

        messagingTemplate.convertAndSend(
                "/topic/room/" + roomId,
                message
        );
    }
}