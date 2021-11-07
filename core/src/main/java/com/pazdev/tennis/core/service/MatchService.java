package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.entity.Match;
import com.pazdev.tennis.core.repository.MatchRepositoryImpl;
import com.pazdev.tennis.core.repository.ScoreRepositoryImpl;

public class MatchService {

    private final ScoreRepositoryImpl scoreRepository;
    private final MatchRepositoryImpl matchRepository;

    public MatchService() {
        this.scoreRepository = new ScoreRepositoryImpl();
        this.matchRepository = new MatchRepositoryImpl();
    }

    public void enregistrerNouveauMatch(Match match){
        matchRepository.create(match);
        scoreRepository.create(match.getScore());
    }
}
