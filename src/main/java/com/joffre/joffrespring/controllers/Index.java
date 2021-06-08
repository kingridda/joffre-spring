package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    @RequestMapping(value = "/")
    public String index(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "index";
    }
}
