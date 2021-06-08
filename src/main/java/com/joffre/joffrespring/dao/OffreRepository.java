package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre, Long> {
}
