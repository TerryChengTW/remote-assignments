package com.example.demo.service;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;

public interface UserService {

    User getUserById(Integer id);

    Integer addUser(UserRequest userRequest);

    boolean isEmailRegistered(String email);

    User validateUser(String email, String password);
}
