package com.example.springbootwebadmin;

import com.example.springbootwebadmin.bean.User;
import com.example.springbootwebadmin.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class SpringBootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from t_book", Long.class);
        log.info("記錄總數：{}",aLong);
    }

    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1L);
        log.info("用戶信息{}",user);
    }

}
