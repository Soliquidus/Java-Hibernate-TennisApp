package com.pazdev.tennis.core.dto;

/**
 * Class Match
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */

public class MatchDto {

    private Long id;
    private JoueurDto vainqueur;
    private JoueurDto finaliste;
    private EpreuveFullDto epreuve;
    private ScoreFullDto scorefullDto;

    public Long getId() {
        return id;
    }

    public MatchDto setId(Long id) {
        this.id = id;
        return this;
    }

    public JoueurDto getVainqueur() {
        return vainqueur;
    }

    public void setVainqueur(JoueurDto vainqueur) {
        this.vainqueur = vainqueur;
    }

    public JoueurDto getFinaliste() {
        return finaliste;
    }

    public void setFinaliste(JoueurDto finaliste) {
        this.finaliste = finaliste;
    }

    public EpreuveFullDto getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(EpreuveFullDto epreuve) {
        this.epreuve = epreuve;
    }

    public ScoreFullDto getScorefullDto() {
        return scorefullDto;
    }

    public void setScoreDto(ScoreFullDto scorefullDto) {
        this.scorefullDto = scorefullDto;
    }
}
