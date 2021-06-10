package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OffreRepository extends JpaRepository<Offre, Long> {

    public List<Offre> findByUserIdUser(String idUser);
    public List<Offre> findAllByOrderByDateDesc();
    @Query("SELECT o FROM Offre o WHERE o.category = :category ORDER BY o.date desc")
    public List<Offre> findAllByCategory(@Param("category") int category);


    @Query("SELECT o FROM Offre o WHERE o.city = :city ORDER BY o.date desc")
    public List<Offre> findAllByCity(@Param("city") int city);


}
