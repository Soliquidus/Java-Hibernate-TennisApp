package com.pazdev.tennis.core.repository;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Epreuve;
import org.hibernate.Session;

/**
 * Class JoueurRepositoryImpl
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */
public class EpreuveRepositoryImpl {

    public Epreuve getById(Long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Epreuve epreuve = session.get(Epreuve.class, id);
        System.out.println("Épreuve lue");
        return epreuve;
    }
}
