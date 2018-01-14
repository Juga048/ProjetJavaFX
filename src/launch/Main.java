package launch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Classe Main qui permet de démarrer le programme
 * @author Axel B
 */

public class Main extends Application {

    /**
     * Permet d'afficher la fenêtre principale de l'application
     * @param primaryStage Le stage de la fenêtre principale
     * @exception IOException Exception si la fenêtre ne peut pas être affiché correctement
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/MainFXML.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Capteur de Température");
        primaryStage.getIcons().add(new Image("/img/thermometer_icon.png"));

        primaryStage.setScene(scene);
        primaryStage.show();       
    }

    /**
     * Méthode appelée au lancement du programme, démarre l'application
     * @param args Tableau de chaînes de caractères
     */
    public static void main(String args[]) {
        Application.launch(args);
    }
}

