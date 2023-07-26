package com.example.pp_3_1_2_springboot.dao;


import com.example.pp_3_1_2_springboot.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    User findById(Long id);

    void merge(User user);

    void remove(User user);
}