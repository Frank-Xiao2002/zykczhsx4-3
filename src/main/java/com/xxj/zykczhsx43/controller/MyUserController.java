package com.xxj.zykczhsx43.controller;

import com.xxj.zykczhsx43.entity.User;
import com.xxj.zykczhsx43.service.MyUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyUserController {
    private MyUserService myUserService;

    public MyUserController(MyUserService myUserService) {
        this.myUserService = myUserService;
    }

    @RequestMapping("/findAll")
    public List<User> findAll() {
        return myUserService.findAll();
    }
}
