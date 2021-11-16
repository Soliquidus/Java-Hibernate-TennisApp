package com.pazdev.tennis.controller;

import com.pazdev.tennis.core.entity.Score;
import com.pazdev.tennis.core.service.ScoreService;

import java.util.Scanner;

/**
 * Class JoueurController
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class ScoreController {

    private final ScoreService scoreService;
    private final Scanner scanner = new Scanner(System.in);

    public ScoreController() {
        this.scoreService = new ScoreService();
    }

    public void afficheDetailScore() {
        System.out.println("Quel est l'identifiant du score dont vous voulez afficher les informations ?");
        Long identifiant = scanner.nextLong();
        Score score = scoreService.getScore(identifiant);
        System.out.println("Les sets du score sont : ");
        System.out.println(score.getSet1());
        System.out.println(score.getSet2());
        if (score.getSet3() != null) {
            System.out.println(score.getSet3());
        }
        if (score.getSet4() != null) {
            System.out.println(score.getSet4());
        }
        if (score.getSet5() != null) {
            System.out.println(score.getSet5());
        }
    }
}
