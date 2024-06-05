package com.fitness.board.service;

import java.util.List;

import com.fitness.board.dto.CommentDto;

public interface CommentService {
	
    public int getCount(Integer bno) throws Exception;
    public int remove(Integer cno, Integer bno, String commenter) throws Exception;
    public int write(CommentDto commentDto) throws Exception;
    public List<CommentDto> getList(Integer bno) throws Exception;
    public CommentDto read(Integer cno) throws Exception;
    public int modify(CommentDto commentDto) throws Exception;
}
