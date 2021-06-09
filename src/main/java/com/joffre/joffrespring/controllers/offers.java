package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;


@Controller
public class offers {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/offers")
    public String offers(Model model){


        model.addAttribute("offers", offerService.list());
        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "offers";
    }

    @RequestMapping(value = "/offers/{offerId}")
    public String offer(@PathVariable long offerId , Model model){


        model.addAttribute("offer", new Offre());
        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "offerDetail";
    }

}
