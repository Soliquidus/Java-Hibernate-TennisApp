package com.pazdev.tennis.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class Match
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class Match {

    private Long id;
    private Joueur vainqueur;
    private Joueur finaliste;
    private Epreuve epreuve;
    private Score score;

    public Long getId() {
        return id;
    }

    public Match setId(Long id) {
        this.id = id;
        return this;
    }

    public Joueur getVainqueur() {
        return vainqueur;
    }

    public Match setVainqueur(Joueur vainqueur) {
        this.vainqueur = vainqueur;
        return this;
    }

    public Joueur getFinaliste() {
        return finaliste;
    }

    public Match setFinaliste(Joueur finaliste) {
        this.finaliste = finaliste;
        return this;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public Match setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
        return this;
    }

    public Score getScore() {
        return score;
    }

    public Match setScore(Score score) {
        this.score = score;
        return this;
    }
}
