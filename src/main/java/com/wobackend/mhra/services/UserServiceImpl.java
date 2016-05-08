package com.wobackend.mhra.services;

import com.wobackend.mhra.models.User;
import com.wobackend.mhra.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public User persistUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    @Transactional
    public User updateUser(long userId, User user) {
        User model = userRepository.findOne(userId);
        if (model != null) {
            model.setAge(user.getAge());
            model.setName(user.getName());
            return userRepository.saveAndFlush(model);
        }
        return null;
    }

    @Override
    public User loadUserByUsername(String userName) {
        return userRepository.loadUserByUsername(userName);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public User findUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
