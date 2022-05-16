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

    @GetMapping("/getUsers")
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/newUser")
    public UserModel newUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @PutMapping("/updateUser")
    public UserModel updateUser(@RequestBody UserModel user){
        return userService.saveUser(user);
    }

    @DeleteMapping( path = "/deleteUser/{id}")
    public  String deleteUser(@PathVariable("id")Long id){
        if(userService.deleteUser(id)){
            return "El usuario con id "+id+" se elimino correctamente";
        }else {
            return "El usuario con id "+id+" no se pudo eliminar";
        }
    }
}
