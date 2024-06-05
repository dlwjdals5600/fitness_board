package com.fitness.board.mapper;

import org.apache.ibatis.annotations.Mapper;


import com.fitness.board.dto.User;

@Mapper
public interface UserMapper {
	User selectUser(String user_id);
	int insertUser(User user);
}
