package org.scoula.service;

import lombok.RequiredArgsConstructor;
import org.scoula.domain.AttachmentVO;
import org.scoula.domain.BoardVO;
import org.scoula.mapper.AttachmentMapper;
import org.scoula.mapper.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    private final AttachmentMapper attachmentMapper;

    @Override
    public void register(BoardVO board,
                         MultipartFile[] files) throws Exception {

        boardMapper.insert(board);

        if(files == null) {
            return;
        }

        for(MultipartFile file : files) {

            if(file.isEmpty()) {
                continue;
            }

            AttachmentVO attachment =
                    new AttachmentVO();

            attachment.setBoardId(
                    board.getBoardId()
            );

            attachment.setFileName(
                    file.getOriginalFilename()
            );

            attachment.setFileSize(
                    file.getSize()
            );

            attachment.setFileData(
                    file.getBytes()
            );

            attachmentMapper.insert(
                    attachment
            );
        }
    }

    @Override
    public List<BoardVO> getList() {
        return boardMapper.getList();
    }

    @Override
    public BoardVO get(Long boardId) {

        BoardVO board =
                boardMapper.get(boardId);

        board.setAttachments(
                attachmentMapper.getByBoardId(boardId)
        );

        return board;
    }
}