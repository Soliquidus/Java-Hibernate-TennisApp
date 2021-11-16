package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.dto.*;
import com.pazdev.tennis.core.entity.Joueur;
import com.pazdev.tennis.core.entity.Match;
import com.pazdev.tennis.core.entity.Score;
import com.pazdev.tennis.core.repository.EpreuveRepositoryImpl;
import com.pazdev.tennis.core.repository.JoueurRepositoryImpl;
import com.pazdev.tennis.core.repository.MatchRepositoryImpl;
import com.pazdev.tennis.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatchService {

    private final ScoreRepositoryImpl scoreRepository;
    private final MatchRepositoryImpl matchRepository;
    private final EpreuveRepositoryImpl epreuveRepository;
    private final JoueurRepositoryImpl joueurRepository;

    public MatchService() {
        this.scoreRepository = new ScoreRepositoryImpl();
        this.matchRepository = new MatchRepositoryImpl();
        this.epreuveRepository = new EpreuveRepositoryImpl();
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public void enregistrerNouveauMatch(Match match) {
        matchRepository.create(match);
        scoreRepository.create(match.getScore());
    }

    public void createMatch(MatchDto dto){
        Transaction transaction = null;
        Match match;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {

            transaction = session.beginTransaction();
            match = new Match();
            match.setEpreuve(epreuveRepository.getById(dto.getEpreuve().getId()));
            match.setVainqueur(joueurRepository.getById(dto.getVainqueur().getId()));
            match.setFinaliste(joueurRepository.getById(dto.getFinaliste().getId()));
            Score score = new Score();
            score.setMatch(match);
            match.setScore(score);
            score.setSet1(dto.getScorefullDto().getSet1());
            score.setSet2(dto.getScorefullDto().getSet2());
            score.setSet3(dto.getScorefullDto().getSet3());
            score.setSet4(dto.getScorefullDto().getSet4());
            score.setSet5(dto.getScorefullDto().getSet5());

            matchRepository.create(match);

            transaction.commit();

        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void tapisVert(Long id) {
        Transaction transaction = null;
        Match match;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            match = matchRepository.getById(id);

            Joueur ancienVainqueur = match.getVainqueur();
            match.setVainqueur(match.getFinaliste());
            match.setFinaliste(ancienVainqueur);

            match.getScore().setSet1((byte)0);
            match.getScore().setSet2((byte)0);
            match.getScore().setSet3((byte)0);
            match.getScore().setSet4((byte)0);
            match.getScore().setSet5((byte)0);

            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteMatch(Long id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            matchRepository.delete(id);
            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public MatchDto getMatch(Long id) {
        Transaction transaction = null;
        Match match;
        MatchDto dto = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
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

            EpreuveFullDto epreuveDto = new EpreuveFullDto();
            epreuveDto.setId(match.getEpreuve().getId());
            epreuveDto.setAnnee(match.getEpreuve().getAnnee());
            epreuveDto.setType(match.getEpreuve().getType());

            TournoiDto tournoiDto = new TournoiDto();
            tournoiDto.setId(match.getEpreuve().getId());
            tournoiDto.setNom(match.getEpreuve().getTournoi().getNom());
            tournoiDto.setCode(match.getEpreuve().getTournoi().getCode());
            epreuveDto.setTournoiDto(tournoiDto);

            dto.setEpreuve(epreuveDto);

            ScoreFullDto scoreDto = new ScoreFullDto();

            scoreDto.setId(match.getScore().getId());
            scoreDto.setSet1(match.getScore().getSet1());
            scoreDto.setSet2(match.getScore().getSet2());
            scoreDto.setSet3(match.getScore().getSet3());
            scoreDto.setSet4(match.getScore().getSet4());
            scoreDto.setSet5(match.getScore().getSet5());

            dto.setScoreDto(scoreDto);
            scoreDto.setMatchDto(dto);

            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return dto;
    }
}
