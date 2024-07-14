package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer id) {
        logger.info("(ser)Fetching user with ID: {}", id);
        User user = userDao.getUserById(id);
        if (user != null) {
            logger.info("(ser)User found with ID: {}", id);
        } else {
            logger.warn("(ser)User not found with ID: {}", id);
        }
        return user;
    }

    @Override
    public Integer addUser(UserRequest userRequest) {
        logger.info("(ser)Adding user with email: {}", userRequest.getEmail());
        Integer id = userDao.addUser(userRequest);
        if (id != null) {
            logger.info("(ser)User added with ID: {}", id);
        } else {
            logger.error("(ser)Failed to add user with email: {}", userRequest.getEmail());
        }
        return id;
    }

    @Override
    public boolean isEmailRegistered(String email) {
        logger.info("(ser)Checking if email is registered: {}", email);
        return userDao.getUserByEmail(email) != null;
    }

    @Override
    public User validateUser(String email, String password) {
        logger.info("(ser)Validating user with email: {}", email);
        User user = userDao.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            return null;
        }
    }
}
