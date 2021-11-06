package com.pazdev.tennis.core.entity;
/**
 * Class Epreuve
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class Epreuve {

    private Long id;
    private Short annee;
    private Tournoi tournoi;
    private Character type;

    public Long getId() {
        return id;
    }

    public Epreuve setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getAnnee() {
        return annee;
    }

    public Epreuve setAnnee(Short annee) {
        this.annee = annee;
        return this;
    }

    public Tournoi getTournoi() {
        return tournoi;
    }

    public Epreuve setTournoi(Tournoi tournoi) {
        this.tournoi = tournoi;
        return this;
    }

    public Character getType() {
        return type;
    }

    public Epreuve setType(Character type) {
        this.type = type;
        return this;
    }
}
