package com.prueba.prueba_tecnica.service;

import com.prueba.prueba_tecnica.models.UserModel;
import com.prueba.prueba_tecnica.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public  ArrayList<UserModel> getUsers(){
               return (ArrayList<UserModel>)userRepository.findAll();
    }

    public  UserModel saveUser(UserModel user){
        return userRepository.save(user);
    }

    public  boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<UserModel> findById(Long id){
        return userRepository.findById(id);
    }
}
