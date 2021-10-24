package com.example.service.demoservice;

import com.example.demo.demoapi.ArticleService;
import com.example.service.demoservice.mapper.UserMapper;
import com.example.service.demoservice.pojo.DBUser;
import com.example.service.demoservice.task.AsyncTask;
import com.example.service.demoservice.task.SyncTask;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@SpringBootTest
class DemoServiceApplicationTests {
    // 最大循环次数
    private static final int MAX_LOOP_COUNT = 100000;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private SyncTask syncTask;

    @Autowired
    private AsyncTask asyncTask;

    @Test
    void insertUser() {
        long stime = System.currentTimeMillis(); // 统计开始时间
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
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
        for (int i = 0; i < MAX_LOOP_COUNT; i++) {
            DBUser user = new DBUser();
            user.setUserName("name" + i);
            user.setPassWord("password" + i);
            userList.add(user);
        }
        userMapper.batchSave(userList);
        long end = System.currentTimeMillis();
        System.out.println("---------------" + (start - end) + "---------------");
    }

    @Test
    void testAsync() {
        // 查询文章
        String article = articleService.selectArticle();
        // 阅读量+1
        articleService.updateReadCount();
        System.out.println(article);
    }

    @Test
    public void syncTaskTest() throws Exception {
        syncTask.doTaskOne();
        syncTask.doTaskTwo();
        syncTask.doTaskThree();
    }

    @Test
    public void asyncTaskTest() throws Exception {
        long start = System.currentTimeMillis();

        Future<String> task1 = asyncTask.doTaskOne();
        Future<String> task2 = asyncTask.doTaskTwo();
        Future<String> task3 = asyncTask.doTaskThree();
        while (true) {
            if (task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }

        System.out.println("任务全部完成，总耗时：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
