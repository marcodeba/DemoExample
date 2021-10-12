package com.example.service.demoservice.controller;

import com.example.service.demoservice.enums.CommonEnum;
import com.example.service.demoservice.exception.BizException;
import com.example.service.demoservice.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserRestController {

    @PostMapping("/user")
    public boolean insert(@RequestBody User user) {
        //如果姓名为空就手动抛出一个自定义的异常！
        if (user.getName() == null) {
            throw new BizException(CommonEnum.USER_NAME_IS_NULL);
        }
        return true;
    }

    @PutMapping("/user")
    public boolean update() {
        //这里故意造成一个空指针的异常，并且不进行处理
        String str = null;
        str.equals("111");
        return true;
    }

    @DeleteMapping("/user")
    public boolean delete() {
        //这里故意造成一个异常，并且不进行处理
        Integer.parseInt("abc123");
        return true;
    }

    @GetMapping("/user")
    public List<User> findByUser() {
        List<User> userList = new ArrayList<>();
        User user = new User();
        user.setId(1L);
        user.setName("marco pan");
        user.setAge(18);
        userList.add(user);
        return userList;
    }
}
