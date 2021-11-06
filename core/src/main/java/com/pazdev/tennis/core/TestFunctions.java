package com.pazdev.tennis.core;

import com.pazdev.tennis.core.entity.Joueur;
import com.pazdev.tennis.core.entity.Tournoi;
import com.pazdev.tennis.core.repository.JoueurRepositoryImpl;
import com.pazdev.tennis.core.repository.TournoiRepositoryImpl;
import com.pazdev.tennis.core.service.JoueurService;
import com.pazdev.tennis.core.service.MatchService;
import com.pazdev.tennis.core.service.TournoiService;

import java.util.List;

/**
 * Class TestDeConnection
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 04/11/2021
 */

public class TestFunctions {
    public static void main(String[] args) {
        JoueurRepositoryImpl joueurRepository = new JoueurRepositoryImpl();
        List<Joueur> joueurs = joueurRepository.listJoueur();

        for(Joueur jouer : joueurs){
            System.out.println(jouer.getPrenom() + " " + jouer.getNom());
        }

        TournoiRepositoryImpl tournoiRepository = new TournoiRepositoryImpl();
        List<Tournoi> tournois = tournoiRepository.listTournoi();

        for(Tournoi tournoi : tournois){
            System.out.println(tournoi.getNom() + " " + tournoi.getCode());
        }
        JoueurService joueurService = new JoueurService();
//        Joueur noah = new Joueur();
//        noah.setNom("Noah");
//        noah.setPrenom("Yannick");
//        noah.setSexe('M');
//        joueurService.createJoueur(noah);
//
//        System.out.println("L'identification du joueur crée est " + noah.getId());
        Long id = 47L;
        Joueur noah = joueurService.getJoueur(id);
        System.out.println("Joueur récupéré : " + noah.getNom() + " " + noah.getPrenom());

        TournoiService tournoiService = new TournoiService();
//        Tournoi test = new Tournoi();
//        test.setCode("TE");
//        test.setNom("TEST");
//        tournoiService.createTournoi(test);
//        System.out.println("L'identification du tournoi créé est " + test.getId());

        Long testId = 5L;
        Tournoi getTest = tournoiService.getTournoi(testId);
        System.out.println("Tournoi récupéré : " + getTest.getNom() + " " + getTest.getCode());

        MatchService matchService = new MatchService();
//        Match match = new Match();
//        Score score = new Score();
//        score.setSet1((byte)3);
//        score.setSet2((byte)4);
//        score.setSet3((byte)6);
//        match.setScore(score);
//        score.setMatch(match);
//        Joueur federer = new Joueur();
//        federer.setId(32L);
//        Joueur murray = new Joueur();
//        murray.setId(34L);
//        match.setVainqueur(federer);
//        match.setFinaliste(murray);
//        Epreuve epreuve = new Epreuve();
//        epreuve.setId(10L);
//        match.setEpreuve(epreuve);
//        matchService.enregistrerNouveauMatch(match);
//
//        System.out.println("L'identification du match créé est " + match.getId());
    }
}

