package com.joffre.joffrespring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

public class Message {


    @Id
    @GeneratedValue
    private Long messageId;
    private Timestamp dateMessage;
    private String message;

    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;

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

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
