package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.api.facebook.Facebook;
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

    private Facebook facebook;

    @Autowired
    public Index(Facebook facebook) {
        this.facebook = facebook;
    }

    @RequestMapping(value = "/")
    public String index(Model model){

        model.addAttribute("profile", facebook.getProfile());
        model.addAttribute("user", null);

        return "index";
    }
}
