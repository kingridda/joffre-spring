package com.joffre.joffrespring.controllers;


import com.joffre.joffrespring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //TODO: refactor this trick to real login when u can
    @Autowired
    private HttpSession session;


    @PostMapping(value = "/login")
    public String loginUser(RedirectAttributes redirectAttributes){
        User user = new User();

        user.setIdUser("00000000");
        user.setUsername("Benn Beckman");
        session.setAttribute("user", user);
        redirectAttributes.addFlashAttribute("message",
                "You successfully logged in ");
        return "redirect:/";
    }

    @GetMapping(value = "/logout")
    public String logOutUser(RedirectAttributes redirectAttributes){

        session.setAttribute("user", null);
        redirectAttributes.addFlashAttribute("message",
                " logged out ");
        return "redirect:/";
    }


}
