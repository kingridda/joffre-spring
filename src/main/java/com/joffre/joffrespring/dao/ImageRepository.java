package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends  JpaRepository<Image, Long> {
}
