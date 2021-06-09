package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller
public class upload {
    @RequestMapping(value = "/upload")
    public String upload(Model model){

        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "upload";
    }
}
