package com.example.myspringbootoauthjwt.controller;

import com.example.myspringbootoauthjwt.entity.User;
import com.example.myspringbootoauthjwt.model.UserDao;
import com.example.myspringbootoauthjwt.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/register-user")
    public User registerUser(@RequestBody UserDao userDao){
        return userService.registerUser(userDao);
    }
}
