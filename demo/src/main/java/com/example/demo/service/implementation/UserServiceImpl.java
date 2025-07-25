package com.example.demo.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public Users save(Users user) {
       Users savedUser = userRepository.save(user);
       return savedUser;
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getById(int id) {
        Optional<Users> user = userRepository.findById(id);
        if(!user.isEmpty())
        {
            return user.get();
        }
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        Optional<Users> user = userRepository.findById(id);
        if(!user.isEmpty())
        {
            userRepository.delete(user.get());
            return true;
        }
        return false;
    }

    @Override
    public Users updateById(Users user, int id) {
       Optional<Users> oldUser = userRepository.findById(id);
       if(oldUser.isPresent())
       {
            oldUser.get().setUsername(user.getUsername()!=null?user.getUsername():oldUser.get().getUsername());
            oldUser.get().setPassword(user.getPassword()!=null?user.getPassword():oldUser.get().getPassword());
            return userRepository.save(oldUser.get());
       }
       return null;
    }

}
