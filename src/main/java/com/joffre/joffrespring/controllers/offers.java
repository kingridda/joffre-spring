package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.entities.User;
import com.joffre.joffrespring.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.Optional;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;


@Controller
public class offers {

    @Autowired
    private OfferService offerService;

    @Autowired
    private HttpSession session;

    @RequestMapping(value = "/offers")
    public String offers(@RequestParam("category") Optional<Integer> category,
                         @RequestParam("city") Optional<Integer> city,
                         Model model){

        if(category.isPresent()){
            model.addAttribute("offers", offerService.listByCategory(category.get()));

        }else if(city.isPresent()){
            model.addAttribute("offers", offerService.listByCity(city.get()));
        }
        else{
            model.addAttribute("offers", offerService.list());
        }
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "offers";
    }



    @RequestMapping(value = "/offers/{offerId}")
    public String offer(@PathVariable long offerId , Model model){

        User user = (User) session.getAttribute("user");
        Offre offer = offerService.getById(offerId);
        offer.setUser(user);

        model.addAttribute("user", user);
        model.addAttribute("offer", offer );
        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        return "offerDetail";
    }

}
