package com.joffre.joffrespring.dao;

import com.joffre.joffrespring.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
