package com.test_project.demo.service;


import com.test_project.demo.model.User;

public interface UserService {

    public User findUserByEmail(String email);

    public void saveUser(User user);
}