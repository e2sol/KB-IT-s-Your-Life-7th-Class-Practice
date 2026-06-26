package org.scoula.domain;

import lombok.Data;

@Data
public class ChatMessageVO {

    private String sender;

    private String message;

    private Long roomId;
}