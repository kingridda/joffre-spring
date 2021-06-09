package com.joffre.joffrespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller

public class offer {
    @RequestMapping(value = "/offer")
    public String offer(Model model){


        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "offerDetail";
    }
}
