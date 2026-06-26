package org.scoula.service;

import org.scoula.domain.BoardVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    void register(BoardVO board,
                  MultipartFile[] files) throws Exception;

    List<BoardVO> getList();

    BoardVO get(Long boardId);
}