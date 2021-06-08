package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.models.Offre;
import com.joffre.joffrespring.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class upload {
    @RequestMapping(value = "/upload")
    public String upload(Model model){
        Offre offre = new Offre();

        model.addAttribute("upload", offre);
        return "upload";
    }
}
