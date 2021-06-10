package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class Index {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;


    @RequestMapping(value = "/")
    public String index(Model model){

        model.addAttribute("user", session.getAttribute("user"));

        return "index";
    }
}
