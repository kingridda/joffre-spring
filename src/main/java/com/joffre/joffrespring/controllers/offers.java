package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class offers {
    @RequestMapping(value = "/offers")
    public String offers(Model model){
        Offre offre = new Offre();

        model.addAttribute("offers", offre);
        return "offers";
    }
}
