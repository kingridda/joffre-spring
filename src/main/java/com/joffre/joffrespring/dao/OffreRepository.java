package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {

    public List<Offre> findByUserIdUser(String idUser);
    public List<Offre> findAllByOrderByDateDesc();


}
