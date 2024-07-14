package com.example.demo.dao;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;
import com.example.demo.rowmapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public User getUserById(Integer id) {
        String sql = "SELECT id, email, password " +
                "FROM user WHERE id = :id";

        Map<String, Object> map = new HashMap<>();
        map.put("id", id);

        logger.info("(dao)Executing query to fetch user with ID: {}", id);
        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (!userList.isEmpty()) {
            logger.info("(dao)User found with ID: {}", id);
            return userList.get(0);
        } else {
            logger.warn("(dao)User not found with ID: {}", id);
            return null;
        }
    }
    @Override
    public Integer addUser(UserRequest userRequest) {
        String sql = "INSERT INTO user(email, password) " +
                "VALUES (:email, :password)";
        Map<String, Object> map = new HashMap<>();
        map.put("email", userRequest.getEmail());
        map.put("password", userRequest.getPassword());

        KeyHolder keyHolder = new GeneratedKeyHolder();

        logger.info("(dao)Executing query to add user with email: {}", userRequest.getEmail());
        namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(map), keyHolder);

        int id = keyHolder.getKey().intValue();
        logger.info("(dao)User added with ID: {}", id);

        return id;
    }

    @Override
    public User getUserByEmail(String email) {
        String sql = "SELECT id, email, password FROM user WHERE email = :email";

        Map<String, Object> map = new HashMap<>();
        map.put("email", email);

        logger.info("(dao)Executing query to fetch user with email: {}", email);
        List<User> userList = namedParameterJdbcTemplate.query(sql, map, new UserRowMapper());

        if (!userList.isEmpty()) {
            logger.info("(dao)User found with email: {}", email);
            return userList.get(0);
        } else {
            logger.warn("(dao)User not found with email: {}", email);
            return null;
        }
    }
}
