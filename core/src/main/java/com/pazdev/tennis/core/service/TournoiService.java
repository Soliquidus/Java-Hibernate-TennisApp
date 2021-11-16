package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.HibernateUtil;
import com.pazdev.tennis.core.dto.TournoiDto;
import com.pazdev.tennis.core.entity.Tournoi;
import com.pazdev.tennis.core.repository.TournoiRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Class TournoiService
 *
 * @author Tibo Pfeifer
 * @version 1.0
 * @date 06/11/2021
 */

public class TournoiService {
    private final TournoiRepositoryImpl tournoiRepository;

    public TournoiService() {
        this.tournoiRepository = new TournoiRepositoryImpl();
    }

    public void createTournoi(TournoiDto tournoiDto) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            Tournoi tournoi = new Tournoi();
            tournoi.setId(tournoiDto.getId());
            tournoi.setNom(tournoiDto.getNom());
            tournoi.setCode(tournoiDto.getCode());
            tournoiRepository.create(tournoi);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public TournoiDto getTournoi(Long id) {
        Transaction transaction = null;
        Tournoi tournoi;
        TournoiDto tournoiDto = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tournoi = tournoiRepository.getById(id);
            tournoiDto = new TournoiDto();
            tournoiDto.setId(tournoi.getId());
            tournoiDto.setNom(tournoi.getNom());
            tournoiDto.setCode(tournoi.getCode());
            transaction.commit();
        } catch (Throwable e) {
            if(transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        return tournoiDto;
    }

    public void deleteTournoi(Long id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().getCurrentSession()) {
            transaction = session.beginTransaction();
            tournoiRepository.delete(id);
            transaction.commit();
        } catch (Throwable t) {
            if (transaction != null) transaction.rollback();
            t.printStackTrace();
        }
    }
}