package org.scoula.service;

import lombok.RequiredArgsConstructor;
import org.scoula.domain.ChatRoomVO;
import org.scoula.mapper.ChatRoomMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl
        implements ChatRoomService {

    private final ChatRoomMapper chatRoomMapper;

    @Override
    public void createRoom(String roomName) {

        ChatRoomVO room =
                new ChatRoomVO();

        room.setRoomName(roomName);

        chatRoomMapper.insert(room);
    }

    @Override
    public List<ChatRoomVO> getRooms() {
        return chatRoomMapper.getList();
    }

    @Override
    public ChatRoomVO getRoom(Long roomId) {
        return chatRoomMapper.get(roomId);
    }
}