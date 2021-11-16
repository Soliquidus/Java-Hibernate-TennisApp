package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.dto.EpreuveFullDto;
import com.pazdev.tennis.core.dto.MatchDto;
import com.pazdev.tennis.core.dto.ScoreFullDto;
import com.pazdev.tennis.core.dto.TournoiDto;
import com.pazdev.tennis.core.entity.Score;
import com.pazdev.tennis.core.repository.ScoreRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Class TournoiService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

public class ScoreService {
    private final ScoreRepositoryImpl scoreRepository;

    public ScoreService() {
        this.scoreRepository = new ScoreRepositoryImpl();
    }

    public void deleteScore(Long id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            scoreRepository.delete(id);
            transaction.commit();
        } catch (Throwable e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public ScoreFullDto getScore(Long id) {
        Transaction transaction = null;
        Score score;
        ScoreFullDto dto = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()
        ) {
            transaction = session.beginTransaction();
            score = scoreRepository.getById(id);

            dto = new ScoreFullDto();
            dto.setId(score.getId());
            dto.setSet1(score.getSet1());
            dto.setSet2(score.getSet2());
            dto.setSet3(score.getSet3());
            dto.setSet4(score.getSet4());
            dto.setSet5(score.getSet5());

            MatchDto matchDto = new MatchDto();
            matchDto.setId(score.getMatch().getId());

            dto.setMatchDto(matchDto);

            EpreuveFullDto epreuveDto = new EpreuveFullDto();
            epreuveDto.setId(score.getMatch().getEpreuve().getId());
            epreuveDto.setAnnee(score.getMatch().getEpreuve().getAnnee());
            epreuveDto.setType(score.getMatch().getEpreuve().getType());

            TournoiDto tournoiDto = new TournoiDto();
            tournoiDto.setId(score.getMatch().getEpreuve().getId());
            tournoiDto.setNom(score.getMatch().getEpreuve().getTournoi().getNom());
            tournoiDto.setCode(score.getMatch().getEpreuve().getTournoi().getCode());
            epreuveDto.setTournoiDto(tournoiDto);

            matchDto.setEpreuve(epreuveDto);

            transaction.commit();
        } catch (Throwable e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return dto;
    }
}