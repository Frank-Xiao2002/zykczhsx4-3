package com.xxj.zykczhsx43.service;

import com.xxj.zykczhsx43.entity.User;

import java.util.List;

public interface MyUserService {
    List<User> findAll();

    /**
     * 根据id删除用户
     */
    void delete(Integer id);

    /**
     * 根据id查找用户
     */
    User findUserById(int id);

    /**
     * 更改用户信息
     */
    void update(User user);

    void save(User user);
}
