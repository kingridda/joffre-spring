package com.joffre.joffrespring.services;


import com.joffre.joffrespring.dao.UserRepository;
import com.joffre.joffrespring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> list() {
        return userRepository.findAll();
    }
}