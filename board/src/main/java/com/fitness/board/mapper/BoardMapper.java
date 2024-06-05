package com.fitness.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.fitness.board.dao.SearchCondition;
import com.fitness.board.dto.BoardDto;

@Mapper
public interface BoardMapper {

    int count();

    void deleteAll();

    void delete(@Param("bno") int bno, @Param("writer") String writer);

    void insert(BoardDto boardDto);

    List<BoardDto> selectAll();

    BoardDto select(@Param("bno") int bno);

    List<BoardDto> selectPage(@Param("offset") int offset, @Param("pageSize") int pageSize);

    void update(BoardDto boardDto);

    void updateCommentCnt(@Param("bno") int bno, @Param("cnt") int cnt);

    void increaseViewCnt(@Param("bno") int bno);

    List<BoardDto> searchSelectPage(@Param("searchCondition") SearchCondition searchCondition, 
                                    @Param("offset") int offset, 
                                    @Param("pageSize") int pageSize);

    int searchResultCnt(@Param("searchCondition") SearchCondition searchCondition);
}
