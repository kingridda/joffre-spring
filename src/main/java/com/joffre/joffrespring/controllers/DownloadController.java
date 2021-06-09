package com.joffre.joffrespring.controllers;

import com.joffre.joffrespring.services.StorageService;
import com.joffre.joffrespring.storage.StorageFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DownloadController {

    private StorageService storageService;

    @Autowired
    public DownloadController(StorageService storageService) {
        this.storageService = storageService;
    }



    @RequestMapping(value = "uploads/{imageName}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String imageName)  {
        Resource file = null;

        try{
            file = storageService.loadAsResource(imageName);
        }catch (StorageFileNotFoundException e){
            System.out.println("File not found error in Download controller");
        }
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + imageName + "\"").body(file);
    }
}
