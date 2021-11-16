package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.dto.EpreuveFullDto;
import com.pazdev.tennis.core.dto.EpreuveLightDto;
import com.pazdev.tennis.core.dto.JoueurDto;
import com.pazdev.tennis.core.service.EpreuveService;

import java.util.Scanner;

/**
 * Class JoueurController
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class EpreuveController {

    private final EpreuveService epreuveService;
    private final Scanner scanner = new Scanner(System.in);

    public EpreuveController() {
        this.epreuveService = new EpreuveService();
    }

    public void afficherDetailsEpreuve() {
        System.out.println("Quel est l'identifiant de l'épreuve dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        EpreuveFullDto epreuve = epreuveService.getEpreuveDetaillee(identifiant);
        System.out.println("Le nom du tournoi est " + epreuve.getTournoiDto().getNom());
        System.out.println("Participants : ");
        for(JoueurDto joueurDto : epreuve.getParticipants()){
            System.out.println(joueurDto.getPrenom() + " " + joueurDto.getNom());
        }
    }

    public void afficherRolandGarros() {
        System.out.println("Quel est l'identifiant de l'épreuve dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        EpreuveLightDto epreuve = epreuveService.getEpreuveSansTournoi(identifiant);
    }
}
