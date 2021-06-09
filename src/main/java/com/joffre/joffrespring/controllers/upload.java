package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.entities.Offre;
import com.joffre.joffrespring.services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static com.joffre.joffrespring.util.SharedEnums.Category;
import static com.joffre.joffrespring.util.SharedEnums.City;

@Controller
public class upload {

    private final StorageService storageService;

    @Autowired
    public Upload(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping("/upload")
    public String upload(Model model){

        model.addAttribute("City", City);
        model.addAttribute("Category", Category);
        model.addAttribute("offer", new Offre());
        return "upload";
    }

    @PostMapping("/upload")
    public String submit(@RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes){

        model.addAttribute("offer", offer);
        return "upload";
    }


        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
