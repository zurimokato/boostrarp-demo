package com.zurimokato.curso.dao;

import com.zurimokato.curso.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void delete(Long id);
    void add(User user);
}
