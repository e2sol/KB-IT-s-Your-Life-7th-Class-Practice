package org.scoula.mapper;

import org.scoula.domain.AttachmentVO;

import java.util.List;

public interface AttachmentMapper {

    void insert(AttachmentVO attachment);

    List<AttachmentVO> getByBoardId(Long boardId);

    AttachmentVO get(Long attachId);
}