package com.joffre.joffrespring.services;

import com.joffre.joffrespring.dao.OffreRepository;
import com.joffre.joffrespring.entities.Offre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OfferService {
    @Autowired
    private OffreRepository offreRepository;

    public List<Offre> list() {
        return offreRepository.findAll();
    }

    public List<Offre> getBy(String id) {
        List<Offre> offers = new ArrayList<>();

        offreRepository.findByUserIdUser(id)
                .forEach(offers::add);

        return offers;
    }
}
