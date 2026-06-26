package org.scoula.domain;

import lombok.Data;

@Data
public class AttachmentVO {

    private Long attachId;

    private Long boardId;

    private String fileName;

    private Long fileSize;

    private byte[] fileData;
}