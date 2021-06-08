package com.joffre.joffrespring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    @RequestMapping(value = "/")
    public String index(){
        return "index";
    }
}