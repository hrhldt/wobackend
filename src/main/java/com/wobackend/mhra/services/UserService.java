package com.wobackend.mhra.services;

import com.wobackend.mhra.models.User;

import java.util.List;

public interface UserService  {

    User persistUser(User user);

    User findUserById(long id);

    User updateUser(long id, User user);

    User loadUserByUsername(String userName);

    List<User> findAll();

    void deleteUser(User user);
}
