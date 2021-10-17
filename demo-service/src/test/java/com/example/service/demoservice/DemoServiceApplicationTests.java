package com.example.service.demoservice;

import com.example.service.demoservice.mapper.UserMapper;
import com.example.service.demoservice.pojo.DBUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DemoServiceApplicationTests {
    // 最大循环次数
    private static final int MAXCOUNT = 100000;

    @Autowired
    private UserMapper userMapper;

    @Test
    void insertUser() {
        long stime = System.currentTimeMillis(); // 统计开始时间
        for (int i = 0; i < MAXCOUNT; i++) {
            DBUser user = new DBUser();
            user.setUserName("test:" + i);
            user.setPassWord("123456");
            userMapper.insert(user);
        }
        long etime = System.currentTimeMillis(); // 统计结束时间
        System.out.println("执行时间：" + (etime - stime));
    }

    @Test
    void batchSave() {
        long start = System.currentTimeMillis();
        List<DBUser> userList = new ArrayList<>();
        for (int i = 0; i < MAXCOUNT; i++) {
            DBUser user = new DBUser();
            user.setUserName("name" + i);
            user.setPassWord("password" + i);
            userList.add(user);
        }
        userMapper.batchSave(userList);
        long end = System.currentTimeMillis();
        System.out.println("---------------" + (start - end) + "---------------");
    }

}
