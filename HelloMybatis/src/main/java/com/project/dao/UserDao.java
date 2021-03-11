package com.project.dao;



import com.project.entity.User;

import java.util.List;


public interface UserDao {
    int insertUser(User user);
    User login( String email);
    List<User> selectTest();
}
