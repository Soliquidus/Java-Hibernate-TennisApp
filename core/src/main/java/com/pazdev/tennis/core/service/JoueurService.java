package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.entity.Joueur;
import com.pazdev.tennis.core.repository.JoueurRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Class JoueurService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

public class JoueurService {
    private final JoueurRepositoryImpl joueurRepository;

    public JoueurService() {
        this.joueurRepository = new JoueurRepositoryImpl();
    }

    public void createJoueur(Joueur joueur) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            joueurRepository.create(joueur);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
    }

    public void renommerNomJoueur(Long id, String nouveauNom) {
        Transaction transaction = null;
        Joueur joueur = getJoueur(id);
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            joueur.setNom(nouveauNom);
            session.merge(joueur);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
    }

    public void changerSexeJoueur(Long id, Character nouveauSexe) {
        Transaction transaction = null;
        Joueur joueur = getJoueur(id);
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            joueur.setSexe(nouveauSexe);
            session.merge(joueur);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
    }

    public Joueur getJoueur(Long id) {
        Transaction transaction = null;
        Joueur joueur = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            joueur = joueurRepository.getById(id);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
        return joueur;
    }

    public void deleteJoueur(Long id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            joueurRepository.delete(id);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
    }
}