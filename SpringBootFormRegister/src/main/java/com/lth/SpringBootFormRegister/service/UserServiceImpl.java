package com.lth.SpringBootFormRegister.service;

import com.lth.SpringBootFormRegister.model.User;
import com.lth.SpringBootFormRegister.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
        System.out.println("USER::" + user);
        userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            System.out.println("404 Not Found!");
        }
        return user;
    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
