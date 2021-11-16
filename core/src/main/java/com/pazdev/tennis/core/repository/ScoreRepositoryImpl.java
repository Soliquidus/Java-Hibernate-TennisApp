package com.pazdev.tennis.core.repository;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Score;
import org.hibernate.Session;

/**
 * Class JoueurRepositoryImpl
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class ScoreRepositoryImpl {

    public void create(Score score) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(score);
        System.out.println("Score ajouté");
    }

    public Score getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Score score = session.get(Score.class, id);
        System.out.println("Score lu");
        return score;
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Score score = session.get(Score.class, id);
        session.delete(score);
        System.out.println("Score supprimé");
    }
}
