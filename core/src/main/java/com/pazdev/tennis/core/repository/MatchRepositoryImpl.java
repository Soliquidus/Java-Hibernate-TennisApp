package com.pazdev.tennis.core.repository;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Match;
import org.hibernate.Session;

/**
 * Class JoueurRepositoryImpl
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class MatchRepositoryImpl {

    public void create(Match match) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.persist(match);
        System.out.println("Match ajouté");
    }
    public Match getById(Long id){
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Match match = session.get(Match.class, id);
        System.out.println("Match lu");
        return match;
    }

    public void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Match match = session.get(Match.class, id);
        session.delete(match);
        System.out.println("Match supprimé");
    }
}
