package com.joffre.joffrespring.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable {

    @Id
    private String idUser;
    private String username;

    @OneToMany
    private List<Offre> offers;

    @OneToMany
    private List<Message> sentMessages;

    @OneToMany
    private List<Message> receivedMessages;




    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Offre> getOffers() {
        return offers;
    }

    public void setOffers(List<Offre> offers) {
        this.offers = offers;
    }


    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }
}
