package com.prueba.prueba_tecnica.controller;

import com.prueba.prueba_tecnica.models.UserModel;
import com.prueba.prueba_tecnica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public UserModel newUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }
}
