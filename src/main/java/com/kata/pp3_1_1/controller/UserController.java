package com.kata.pp3_1_1.controller;

import com.kata.pp3_1_1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kata.pp3_1_1.service.UserService;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> users = userService.showUsers();
        model.addAttribute("users",users);
        return "users";
    }
    @GetMapping("/addUser")
    public String addUserForm(User user){
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(User user){
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
      userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/editUser/{id}")
    public String editUserForm(@PathVariable("id") int id,Model model){
            userService.findById(id);
            model.addAttribute("user",userService.findById(id));
        return "editUser";
    }

    @PostMapping("/editUser")
    public String editUser(User user){
        userService.editUser(user);
        return "redirect:/users";
    }
}
