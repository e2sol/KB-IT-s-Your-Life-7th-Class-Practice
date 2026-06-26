package org.scoula.mapper;

import org.scoula.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    void insert(BoardVO board);

    List<BoardVO> getList();

    BoardVO get(Long boardId);
}