package com.pazdev.tennis.core.entity;

import javax.persistence.*;

/**
 * Class Tournoi
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
@Entity
@Table(name = "TOURNOI")
public class Tournoi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String code;

    public Long getId() {
        return id;
    }

    public Tournoi setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNom() {
        return nom;
    }

    public Tournoi setNom(String nom) {
        this.nom = nom;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Tournoi setCode(String code) {
        this.code = code;
        return this;
    }
}