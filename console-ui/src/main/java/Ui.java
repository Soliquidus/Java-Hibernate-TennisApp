import com.pazdev.tennis.controller.JoueurController;
import com.pazdev.tennis.controller.TournoiController;

public class Ui {
    public static void main(String[] args) {
        JoueurController joueurController = new JoueurController();
        TournoiController tournoiController = new TournoiController();
        joueurController.modifierNomJoueur();
//        joueurController.afficheDetailJoueur();
//        joueurController.creerJoueur();
//        tournoiController.afficheDetailTournoi();
//        tournoiController.creerTournoi();
    }
}
