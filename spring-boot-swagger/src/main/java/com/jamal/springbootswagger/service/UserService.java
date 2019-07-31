package com.jamal.springbootswagger.service;

import com.jamal.springbootswagger.domain.User;

import java.util.List;

public interface UserService {

    List<User> findUser();

    void insertUser(User user);

    void deleteUser(int id);

    void updateUser(User user);
}
