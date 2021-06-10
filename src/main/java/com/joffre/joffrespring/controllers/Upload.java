package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.services.OffreFormService;
import com.joffre.joffrespring.storage.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller
public class Upload {

    @Autowired
    private HttpSession session;

    @Autowired
    private OffreFormService offreFormService;




    @GetMapping("/upload")
    public String upload(Model model){


        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("form", offreFormService);
        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        model.addAttribute("offer", new Offre());
        return "upload";
    }

    @PostMapping("/upload")
    public String submit(@ModelAttribute Offre offer, @RequestParam("file") MultipartFile file  , RedirectAttributes redirectAttributes, Model model){

        offreFormService.setErrorsEmpty();
        if( offreFormService.handleForm(offer, file) ){

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded " + file.getOriginalFilename() + "!");
            return "redirect:/";
        }else{

            model.addAttribute("user", session.getAttribute("user"));
            model.addAttribute("form", offreFormService);
            model.addAttribute("City", City);
            model.addAttribute("Category", Category);
            model.addAttribute("offer", new Offre());
            return "upload";
        }
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
