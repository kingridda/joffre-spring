package com.joffre.joffrespring.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String idUser;
    private String firstName;
    private String lastName;
    private List<com.joffre.joffrespring.models.Offre> offers ;
    private List<com.joffre.joffrespring.models.Offre> favorites ;
    private List<com.joffre.joffrespring.models.Message> messages;

    public List<com.joffre.joffrespring.models.Offre> getFavorites() { return favorites; }

    public void setFavorites(List<com.joffre.joffrespring.models.Offre> favorites) { this.favorites = favorites; }

    public List<com.joffre.joffrespring.models.Offre> getOffers() {
        return offers;
    }

    public void setOffers(List<com.joffre.joffrespring.models.Offre> offers) {
        this.offers = offers;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<com.joffre.joffrespring.models.Message> getMessages() {
        return messages;
    }

    public void setMessages(List<com.joffre.joffrespring.models.Message> messages) {
        this.messages = messages;
    }
}
