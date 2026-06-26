package org.scoula.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatRoomVO {

    private Long roomId;

    private String roomName;

    private LocalDateTime createdAt;
}