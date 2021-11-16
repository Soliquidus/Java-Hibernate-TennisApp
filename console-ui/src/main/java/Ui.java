import com.pazdev.tennis.controller.*;

public class Ui {
    public static void main(String[] args) {
        JoueurController joueurController = new JoueurController();
        TournoiController tournoiController = new TournoiController();
        ScoreController scoreController = new ScoreController();
        EpreuveController epreuveController = new EpreuveController();
        MatchController matchController = new MatchController();
//        joueurController.modifierNomJoueur();
//        joueurController.afficheDetailJoueur();
//        joueurController.creerJoueur();
//        joueurController.supprimerJoueur();
//        joueurController.modifierSexeJoueur();
//        tournoiController.afficheDetailTournoi();
//        tournoiController.creerTournoi();
//        tournoiController.supprimerTournoi();
//        scoreController.afficheDetailScore();
//        epreuveController.afficheDerniereEpreuve();
//        epreuveController.afficheRolandGarros();
        matchController.afficheDetailMatch();
    }
}
