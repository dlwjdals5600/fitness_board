package com.fitness.board.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fitness.board.dto.CommentDto;

public interface CommentMapper {
	
    public int count(Integer bno);

    public int deleteAll(Integer bno);
   
    public int delete(Integer cno, String commenter);

    public int insert(CommentDto dto);

    public List<CommentDto> selectAll(Integer bno);

    public CommentDto select(Integer cno);

    public int update(CommentDto dto);
}
