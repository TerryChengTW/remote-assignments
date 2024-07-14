package com.example.demo.dao;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;

public interface UserDao {

    User getUserById(Integer id);

    Integer addUser(UserRequest userRequest);

    User getUserByEmail(String email);
}
