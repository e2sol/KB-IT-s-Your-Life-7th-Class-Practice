package org.scoula.mapper;

import org.scoula.domain.ChatRoomVO;

import java.util.List;

public interface ChatRoomMapper {

    void insert(ChatRoomVO room);

    List<ChatRoomVO> getList();

    ChatRoomVO get(Long roomId);
}