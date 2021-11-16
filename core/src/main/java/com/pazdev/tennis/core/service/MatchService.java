package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.dto.JoueurDto;
import com.pazdev.tennis.core.dto.MatchDto;
import com.pazdev.tennis.core.entity.Match;
import com.pazdev.tennis.core.repository.MatchRepositoryImpl;
import com.pazdev.tennis.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

    public MatchDto getMatch(Long id){
        Transaction transaction = null;
        Match match;
        MatchDto dto = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            match = matchRepository.getById(id);
            dto = new MatchDto();
            dto.setId(match.getId());

            JoueurDto finalisteDto = new JoueurDto();
            finalisteDto.setId(match.getFinaliste().getId());
            finalisteDto.setNom(match.getFinaliste().getNom());
            finalisteDto.setPrenom(match.getFinaliste().getPrenom());
            finalisteDto.setSexe(match.getFinaliste().getSexe());
            dto.setFinaliste(finalisteDto);

            JoueurDto vainqueurDto = new JoueurDto();
            vainqueurDto.setId(match.getVainqueur().getId());
            vainqueurDto.setNom(match.getVainqueur().getNom());
            vainqueurDto.setPrenom(match.getVainqueur().getPrenom());
            vainqueurDto.setSexe(match.getVainqueur().getSexe());

            dto.setFinaliste(finalisteDto);
            dto.setVainqueur(vainqueurDto);
            transaction.commit();
        } catch (Throwable e){
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return dto;
    }
}
