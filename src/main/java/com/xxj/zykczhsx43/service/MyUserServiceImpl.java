package com.xxj.zykczhsx43.service;

import com.xxj.zykczhsx43.dao.UserDao;
import com.xxj.zykczhsx43.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
    private UserDao userDao;

    public MyUserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
