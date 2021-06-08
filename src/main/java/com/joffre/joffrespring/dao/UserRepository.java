package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
