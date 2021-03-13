package com.bh.test;

import com.bh.mapper.UserMapper;
import com.bh.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description: mybatis与spring整合测试类
 * @Author: WWT
 * @Date: 2021/3/12
 * @Time: 17:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 这里表示加载配置文件
@ContextConfiguration({"classpath:applicationContext.xml"})

public class MybatisAndStringTest {
    @Autowired
    private UserMapper userMapper;      //自动注入

    @Test
    public void testFindUserById() {
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
