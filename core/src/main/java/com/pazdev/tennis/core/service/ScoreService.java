package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
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

    public Score getScore(Long id) {
        Transaction transaction = null;
        Score score = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            score = scoreRepository.getById(id);
            transaction.commit();
        } catch (Throwable e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return score;
    }
}