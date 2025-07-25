package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Users;

public interface UserService {
    Users save(Users user);
    List<Users> getAllUsers();
    Users getById(int id);
    boolean deleteById(int id);
    Users updateById(Users user,int id);
}
