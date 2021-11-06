package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.entity.Joueur;
import com.pazdev.tennis.core.service.JoueurService;

import java.util.Scanner;

/**
 * Class JoueurController
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class JoueurController {

    private final JoueurService joueurService;
    private final Scanner scanner = new Scanner(System.in);

    public JoueurController() {
        this.joueurService = new JoueurService();
    }

    public void afficheDetailJoueur() {
        System.out.println("Quel est l'identifiant de joueur dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        Joueur joueur = joueurService.getJoueur(identifiant);
        System.out.println("Le joueur sélectionné s'appelle " + joueur.getPrenom() + " " + joueur.getNom());
    }

    public void creerJoueur() {
        Joueur noah = new Joueur();
        System.out.print("\nQuel nouveau joueur voulez vous créer ?" +
                "\nNom du joueur : ");
        String nom = scanner.nextLine();
        noah.setNom(nom);
        System.out.print("\nPrénom du joueur : ");
        String prenom = scanner.nextLine();
        noah.setPrenom(prenom);
        System.out.print("\nSexe du joueur : ");
        String sexe = scanner.nextLine();
        noah.setSexe(sexe.charAt(0));
        joueurService.createJoueur(noah);
        System.out.println("Le/La joueur/joueuse " + noah.getPrenom() + " " + noah.getNom() + " a bien été créé." +
                "\n Identifiant : " + noah.getId());
    }
}
