package com.lth.SpringBootFormRegister.service;

import com.lth.SpringBootFormRegister.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    void saveUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);
}
