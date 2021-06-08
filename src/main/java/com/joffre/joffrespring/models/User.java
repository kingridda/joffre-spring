package com.joffre.joffrespring.models;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

    private String idUser;
    private String firstName;
    private String lastName;
    private List<com.JOffre.Model.Offre> offers ;
    private List<com.JOffre.Model.Offre> favorites ;
    private List<com.JOffre.Model.Message> messages;

    public List<com.JOffre.Model.Offre> getFavorites() { return favorites; }

    public void setFavorites(List<com.JOffre.Model.Offre> favorites) { this.favorites = favorites; }

    public List<com.JOffre.Model.Offre> getOffers() {
        return offers;
    }

    public void setOffers(List<com.JOffre.Model.Offre> offers) {
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

    public List<com.JOffre.Model.Message> getMessages() {
        return messages;
    }

    public void setMessages(List<com.JOffre.Model.Message> messages) {
        this.messages = messages;
    }
}
