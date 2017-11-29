package launch;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        setUserAgentStylesheet(STYLESHEET_CASPIAN);
        Parent root = FXMLLoader.load(getClass().getResource("/ihm/MainFXML.fxml"));
        Scene scene = new Scene(root);
        
        //Set the application title and icon
        primaryStage.setTitle("Capteur de Température");
        primaryStage.getIcons().add(new Image("/img/thermometer_icon.png"));

        primaryStage.setScene(scene);
        primaryStage.show();       
    }
    
    public static void main(String args[]) {
        Application.launch(args);
    }
}

// Ajouter ThreadManager pour gérer les thread et les stopper à la fermeture