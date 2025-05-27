package com.lth.SpringBootFormRegister.controller;

import com.lth.SpringBootFormRegister.model.User;
import com.lth.SpringBootFormRegister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "index.html";
    }

    @GetMapping("/addNewUserForm")
    public String addNewUserForm(Model model){
        User user = new User();
        model.addAttribute("User",user);
        return "new_user.html";
    }

    @PostMapping("/saveUser")
    public String saveUsers(@ModelAttribute("User") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateUser(@PathVariable("id") int id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute("User",user);
        return "update_user.html";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        userService.deleteUserById(id);
        return "redirect:/";
    }
}
