package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.dao.UserRepository;
import com.joffre.joffrespring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class Index {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/")
    public String index(Model model){

        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }
}
