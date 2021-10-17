package com.example.service.demoservice.controller;

import com.example.service.demoservice.mapper.UserMapper;
import com.example.service.demoservice.pojo.DBUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @RequestMapping("/getUsers")
    public List<DBUser> getUsers() {
        List<DBUser> users = userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser/{id}")
    public DBUser getUser(@PathVariable("id") Long id) {
        DBUser user = userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(DBUser user) {
        userMapper.insert(user);
    }

    @RequestMapping(value = "update")
    public void update(DBUser user) {
        userMapper.update(user);
    }

    @RequestMapping(value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }
}