package com.pazdev.tennis.core.dto;

import java.util.Set;

/**
 * Class Epreuve
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

public class EpreuveFullDto {
    private Long id;
    private Short annee;
    private TournoiDto tournoi;
    private Character type;
    private Set<JoueurDto> participants;

    public Long getId() {
        return id;
    }

    public EpreuveFullDto setId(Long id) {
        this.id = id;
        return this;
    }

    public Short getAnnee() {
        return annee;
    }

    public EpreuveFullDto setAnnee(Short annee) {
        this.annee = annee;
        return this;
    }

    public TournoiDto getTournoiDto() {
        return tournoi;
    }

    public EpreuveFullDto setTournoiDto(TournoiDto tournoi) {
        this.tournoi = tournoi;
        return this;
    }

    public Character getType() {
        return type;
    }

    public EpreuveFullDto setType(Character type) {
        this.type = type;
        return this;
    }

    public TournoiDto getTournoi() {
        return tournoi;
    }

    public void setTournoi(TournoiDto tournoi) {
        this.tournoi = tournoi;
    }

    public Set<JoueurDto> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<JoueurDto> participants) {
        this.participants = participants;
    }
}
