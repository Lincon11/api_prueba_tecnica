package com.prueba.prueba_tecnica.controller;

import com.prueba.prueba_tecnica.models.UserModel;
import com.prueba.prueba_tecnica.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

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
    public ResponseEntity<UserModel> newUser(@RequestBody UserModel user){
        ResponseEntity<UserModel> response = null;

        if(user.getNombre()==null || user.getTelefono()==null || Objects.equals(user.getNombre(), "") || Objects.equals(user.getTelefono(), "")){
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else{
            response = ResponseEntity.ok(userService.saveUser(user));
        }
        return response;
    }

    @PutMapping("/updateUser")
    public ResponseEntity<UserModel>  updateUser(@RequestBody UserModel user){
        ResponseEntity<UserModel> response = null;
        if(user.getNombre()==null || user.getTelefono()==null || Objects.equals(user.getNombre(), "") || Objects.equals(user.getTelefono(), "")){
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }else if (userService.findById(user.getId()).isPresent()){
                response = ResponseEntity.ok(userService.saveUser(user));
        }else{
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @DeleteMapping( path = "/deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id")Long id){
        ResponseEntity<String> response = null;
        if(userService.deleteUser(id)){
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("El usuario con id " +id+ " se elimino correctamente");
        }else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario con id "+id+" no se pudo eliminar");
        }
        return response;
    }
}
