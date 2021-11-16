package com.pazdev.tennis.core.dto;

/**
 * Class Epreuve
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

public class EpreuveLightDto {

    private Long id;
    private Short annee;
    private Character type;

    public Long getId() {
        return id;
    }

    public EpreuveLightDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getAnnee() {
        return annee;
    }

    public EpreuveLightDto setAnnee(Short annee) {
        this.annee = annee;
        return this;
    }


    public Character getType() {
        return type;
    }

    public EpreuveLightDto setType(Character type) {
        this.type = type;
        return this;
    }
}
