package com.qianmi.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @program:
 * @description:
 * @author: zhoucy
 * @create: 2019-06-17 18:17
 */
public class MyRowMapper implements RowMapper<User> {


    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        String channel = resultSet.getString("channel");
        String time = resultSet.getString(2);
        User user = new User();
        user.setChannel(channel);
        user.setTime(time);
        return user;
    }
}
