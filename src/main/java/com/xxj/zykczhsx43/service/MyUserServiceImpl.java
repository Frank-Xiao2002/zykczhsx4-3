package com.xxj.zykczhsx43.service;

import com.xxj.zykczhsx43.dao.UserDao;
import com.xxj.zykczhsx43.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserServiceImpl implements MyUserService {
    private final UserDao userDao;

    public MyUserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void delete(Integer id) {
        userDao.deleteByPrimaryKey(id);
    }

    @Override
    public User findUserById(int id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userDao.updateByPrimaryKey(user);
    }

    @Override
    public void save(User user) {
        userDao.insertSelective(user);
    }
}
