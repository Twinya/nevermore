package com.qianmi.service;

import com.qianmi.entity.MyRowMapper;
import com.qianmi.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:
 * @description: .
 * @author: zhoucy
 * @create: 2019-06-17 10:19
 */
@Service
public class ChannelService {
    /**
     * 零点
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 共享
     */
    @Autowired
    @Qualifier("gxTemplate")
    private JdbcTemplate gxTemplate;

    @Autowired
    @Qualifier("hmTemplate")
    private JdbcTemplate hemaTemplate;

    @Autowired
    @Qualifier("xfqTemplate")
    private JdbcTemplate xfqTemplate;

    @Autowired
    @Qualifier("xyTemplate")
    private JdbcTemplate xiaoyuTemplate;

    @Autowired
    @Qualifier("zyjjTemplate")
    private JdbcTemplate zyjjTemplate;

    @Autowired
    @Qualifier("zyqbTemplate")
    private JdbcTemplate zyqbTemplate;

    public static final String SQL = "select channel,FROM_UNIXTIME(create_time/1000,'%Y-%m-%d %H:%i:%S') as createTime from user where username = ?";
    public static final String SQL1 = "select channel,registTime from tbl_user where username = ?";

    public Map<String, Object> getChannelByMobile(String mobile) throws SQLException {
        Map<String, Object> map = new HashMap<>();
        if (hemaTemplate.getDataSource().getConnection() != null) {
            List<User> hema = hemaTemplate.query(SQL, new Object[]{mobile},new MyRowMapper());
            map.put("河马", hema);
        }
        List<User> xy = xiaoyuTemplate.query(SQL, new Object[]{mobile}, new MyRowMapper());
        List<User> xfq = xfqTemplate.query(SQL, new Object[]{mobile}, new MyRowMapper());
        List<User> zyjj = zyjjTemplate.query(SQL, new Object[]{mobile}, new MyRowMapper());
        List<User> zyqb = zyqbTemplate.query(SQL, new Object[]{mobile}, new MyRowMapper());
        List<User> ld = jdbcTemplate.query(SQL1, new Object[]{mobile}, new MyRowMapper());
        List<User> gx = gxTemplate.query(SQL1, new Object[]{mobile}, new MyRowMapper());
        map.put("小鱼救急", xy);
        map.put("章鱼救急", zyjj);
        map.put("章鱼钱包", zyqb);
        map.put("小番茄", xfq);
        map.put("零点", ld);
        map.put("共享", gx);
        return map;
    }

}
