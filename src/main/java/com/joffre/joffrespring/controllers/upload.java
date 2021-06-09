package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller
public class upload {

    @GetMapping("/upload")
    public String upload(Model model){

        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        model.addAttribute("offer", new Offre());
        return "upload";
    }

    @PostMapping("/upload")
    public String submit(@ModelAttribute Offre offer, Model model){
        model.addAttribute("offer", offer);
        return "upload";
    }
}
