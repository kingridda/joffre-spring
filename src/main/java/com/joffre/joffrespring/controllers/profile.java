package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Message;
import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.entities.User;
import com.joffre.joffrespring.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller

public class profile {
    private final String USER_SESSION = "user";

    @Autowired
    private HttpSession session;
    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "/profile")
    public String offer(Model model){

        User user = (User) session.getAttribute(USER_SESSION);
        Offre offre = new Offre();
        //user.setOffers(offerService.list());
        model.addAttribute("user", user);
        model.addAttribute("offre", offre);
        model.addAttribute("mess",new Message());
        return "profile";
    }
}
