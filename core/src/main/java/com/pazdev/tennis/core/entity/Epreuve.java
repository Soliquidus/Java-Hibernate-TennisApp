package com.pazdev.tennis.core.entity;

import javax.persistence.*;

/**
 * Class Epreuve
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

@Entity
@Table(name = "EPREUVE")
public class Epreuve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Short annee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_TOURNOI")
    private Tournoi tournoi;
    @Column(name = "TYPE_EPREUVE")
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
