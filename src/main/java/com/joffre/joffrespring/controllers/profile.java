package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Message;
import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller

public class profile {
    @RequestMapping(value = "/profile")
    public String offer(Model model){

        User user = new User();
        Offre offre = new Offre();
        Message mess = new Message();
        model.addAttribute("user", user);
        model.addAttribute("offre", offre);
        model.addAttribute("mess",mess);
        return "profile";
    }
}
