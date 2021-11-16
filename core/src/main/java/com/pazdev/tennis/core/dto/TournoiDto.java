package com.pazdev.tennis.core.dto;

/**
 * Class Tournoi
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 07/11/2021
 */
public class TournoiDto {

    private Long id;
    private String nom;
    private String code;

    public Long getId() {
        return id;
    }

    public TournoiDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public TournoiDto setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getCode() {
        return code;
    }

    public TournoiDto setCode(String code) {
        this.code = code;
        return this;
    }
}