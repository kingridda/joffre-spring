package com.joffre.joffrespring.entities;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Message {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long messageId;

    @CreationTimestamp
    private Timestamp dateMessage;

    private String message;

    @ManyToOne
    private User toUser;

    @ManyToOne
    private User fromUser;

    public Message(){super();}



    public Long getMessageId() { return messageId; }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Timestamp getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Timestamp dateMessage) {
        this.dateMessage = dateMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }
}
