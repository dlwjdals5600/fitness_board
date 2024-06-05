package com.fitness.board.dao;

import com.fitness.board.dto.*;

public interface UserDao {
	User selectUser(String user_id) throws Exception;
    int deleteUser(String user_id) throws Exception;
    int insertUser(User user) throws Exception;
    int updateUser(User user) throws Exception;
    int count() throws Exception;
    void deleteAll() throws Exception;
}
