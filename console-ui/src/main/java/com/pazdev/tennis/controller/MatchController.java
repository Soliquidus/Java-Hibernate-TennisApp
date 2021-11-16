package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.dto.MatchDto;
import com.pazdev.tennis.core.service.MatchService;

import java.util.Scanner;

/**
 * Class TournoiController
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 08/11/2021
 */
public class MatchController {

    private final MatchService matchService;
    private final Scanner scanner = new Scanner(System.in);

    public MatchController() {
        this.matchService = new MatchService();
    }

    public void afficheDetailMatch() {
        System.out.println("Quel est l'identifiant du match dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        MatchDto match = matchService.getMatch(identifiant);
        System.out.println("Le match sélectionné a comme vainqueur " + match.getVainqueur().getPrenom() + " " + match.getVainqueur().getNom() +
                " et comme finaliste " + match.getFinaliste().getPrenom() + " " + match.getFinaliste().getNom());
    }

}
