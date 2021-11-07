package com.pazdev.tennis.core.service;

import com.pazdev.tennis.core.entity.Tournoi;
import com.pazdev.tennis.core.repository.TournoiRepositoryImpl;

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

    public void createTournoi(Tournoi tournoi) {
        tournoiRepository.create(tournoi);
    }

    public Tournoi getTournoi(Long id) {
        return tournoiRepository.getById(id);
    }
}