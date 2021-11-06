package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.entity.Tournoi;
import com.pazdev.tennis.core.service.TournoiService;

import java.util.Scanner;

/**
 * Class TournoiController
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class TournoiController {

    private final TournoiService tournoiService;
    private final Scanner scanner = new Scanner(System.in);

    public TournoiController() {
        this.tournoiService = new TournoiService();
    }

    public void afficheDetailTournoi() {
        System.out.println("Quel est l'identifiant du tournoi dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        Tournoi tournoi = tournoiService.getTournoi(identifiant);
        System.out.println("Le tournoi sélectionné s'appelle " + tournoi.getNom() + " avec le code " + tournoi.getCode());
    }

    public void creerTournoi() {
        Tournoi tournoi = new Tournoi();
        System.out.print("\nQuel nouveau tournoi voulez vous créer ?" +
                "\nNom du tournoi : ");
        String nom = scanner.nextLine();
        tournoi.setNom(nom);
        System.out.print("\nCode du Tournoi : ");
        String code = scanner.nextLine();
        tournoi.setCode(code);
        tournoiService.createTournoi(tournoi);
        System.out.println("Le tournoi " + tournoi.getNom() + " au code " + tournoi.getCode() + " a bien été créé." +
                "\n Identifiant : " + tournoi.getId());
    }
}
