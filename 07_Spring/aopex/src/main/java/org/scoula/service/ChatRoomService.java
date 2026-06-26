package org.scoula.service;

import org.scoula.domain.ChatRoomVO;

import java.util.List;

public interface ChatRoomService {

    void createRoom(String roomName);

    List<ChatRoomVO> getRooms();

    ChatRoomVO getRoom(Long roomId);
}