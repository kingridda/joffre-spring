package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class offers {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/offers")
    public String offers(Model model){


        model.addAttribute("offers", offerService.list());
        return "offers";
    }
}
