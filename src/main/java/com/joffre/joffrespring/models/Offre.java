package com.joffre.joffrespring.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

public class    Offre implements Serializable {

    private Long offerId;
    private String titre;
    private Timestamp date;
    private String description;
    private Integer city;
    private Integer category;
    private List<com.JOffre.Model.Image> photos;
    private String idUser;
    private String userFirstName;

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    private String userLastName;
    private Integer score;

    public Offre(){
        super();
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<com.JOffre.Model.Image> getPhotos() {
        return photos;
    }

    public void setPhotos(List<com.JOffre.Model.Image> photos) {
        this.photos = photos;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public Long getOfferId() {
        return offerId;
    }

    public void setOfferId(Long offerId) {
        this.offerId = offerId;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}
