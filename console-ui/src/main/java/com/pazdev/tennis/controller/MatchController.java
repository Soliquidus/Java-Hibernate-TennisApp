package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.dto.EpreuveFullDto;
import com.pazdev.tennis.core.dto.JoueurDto;
import com.pazdev.tennis.core.dto.MatchDto;
import com.pazdev.tennis.core.dto.ScoreFullDto;
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

    public void tapisVert(){

        System.out.println("Quel est l'identifiant du match que vous voulez annuler ?");
        Long identifiant = scanner.nextLong();
        matchService.tapisVert(identifiant);
    }

    public void ajouterMatch(){

        System.out.println("Quel est l'identifiant de l'épreuve ?");
        long epreuveId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'identifiant du vainqueur ?");
        long vainqueurId = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel est l'identifiant du finaliste ?");
        long finalisteId = scanner.nextLong();
        scanner.nextLine();

        MatchDto dto = new MatchDto();
        dto.setEpreuve(new EpreuveFullDto());
        dto.getEpreuve().setId(epreuveId);
        dto.setFinaliste(new JoueurDto());
        dto.getFinaliste().setId(finalisteId);
        dto.setVainqueur(new JoueurDto());
        dto.getVainqueur().setId(vainqueurId);

        System.out.println("Quel est la valeur du 1er set ?");
        byte set1 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 2éme set ?");
        byte set2 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 3éme set ?");
        byte set3 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 4éme set ?");
        byte set4 = scanner.nextByte();
        scanner.nextLine();
        System.out.println("Quel est la valeur du 5éme set ?");
        byte set5 = scanner.nextByte();
        scanner.nextLine();

        ScoreFullDto scoreDto = new ScoreFullDto();
        scoreDto.setSet1(set1);
        scoreDto.setSet2(set2);
        scoreDto.setSet3(set3);
        scoreDto.setSet4(set4);
        scoreDto.setSet5(set5);

        dto.setScoreDto(scoreDto);
        scoreDto.setMatchDto(dto);

        matchService.createMatch(dto);
    }

    public void afficherDetailsMatch() {
        System.out.println("Quel est l'identifiant du match dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        MatchDto match = matchService.getMatch(identifiant);
        System.out.println("Le match sélectionné a comme vainqueur " + match.getVainqueur().getPrenom() + " " + match.getVainqueur().getNom() +
                " et comme finaliste " + match.getFinaliste().getPrenom() + " " + match.getFinaliste().getNom());
        System.out.println("Il s'agit d'un match de " + match.getEpreuve().getAnnee() + " qui s'est déroulé à " + match.getEpreuve().getTournoiDto().getNom());
        System.out.println("Les sets du score sont : ");
        System.out.println(match.getScorefullDto().getSet1());
        System.out.println(match.getScorefullDto().getSet2());
        if (match.getScorefullDto().getSet3() != null) {
            System.out.println(match.getScorefullDto().getSet3());
        }
        if (match.getScorefullDto().getSet4() != null) {
            System.out.println(match.getScorefullDto().getSet4());
        }
        if (match.getScorefullDto().getSet5() != null) {
            System.out.println(match.getScorefullDto().getSet5());
        }
    }

    public void supprimerMatch(){
        System.out.println("Quel est l'identifiant du match que vous voulez supprimer ?");
        Long identifiant = scanner.nextLong();
        matchService.deleteMatch(identifiant);
    }

}
