package org.scoula.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardVO {

    private Long boardId;

    private String title;

    private String writer;

    private String content;

    private LocalDateTime createdAt;

    private List<AttachmentVO> attachments;
}