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
        System.out.print("\nQuel nouveau joueur voulez vous créer ?" +
                "\nNom du joueur : ");
        String nom = scanner.nextLine();
        System.out.print("\nPrénom du joueur : ");
        String prenom = scanner.nextLine();
        System.out.print("\nSexe du joueur : ");
        String sexe = scanner.nextLine();
        Joueur joueur = new Joueur();

        joueur.setNom(nom);
        joueur.setPrenom(prenom);
        joueur.setSexe(sexe.charAt(0));
        joueurService.createJoueur(joueur);
        System.out.println("Le/La joueur/joueuse " + joueur.getPrenom() + " " + joueur.getNom() + " a bien été créé." +
                "\n Identifiant : " + joueur.getId());
    }

    public void modifierNomJoueur() {
        System.out.println("Quel est l'identifiant de joueur dont vous voulez modifier le nom ?");
        Long identifiant = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel nouveau nom voulez vous donner ?");
        String nom = scanner.nextLine();
        joueurService.renommerNomJoueur(identifiant, nom);
    }

    public void modifierSexeJoueur() {
        System.out.println("Quel est l'identifiant de joueur dont vous voulez modifier le sexe ?");
        Long identifiant = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Quel nouveau sexe voulez vous donner ?");
        Character sexe = scanner.nextLine().charAt(0);
        joueurService.changerSexeJoueur(identifiant, sexe);
    }

    public void supprimerJoueur() {
        System.out.println("Quel est l'identifiant du joueur que vous voulez supprimer ?");
        Long identifiant = scanner.nextLong();
        joueurService.deleteJoueur(identifiant);
    }



}
