package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoGenerateurEvolutifController implements MainController{

    @FXML
    TextField temperature;

    @FXML
    TextField evolutiontemperature;

    @FXML
    Button annuler;

    @FXML
    Button valider;

    public int temperatureDeBase;
    public int evolution;

    @Override
    public void setValeur(int valeur) {}
    @Override
    public void initialize() {}


    public void verifChamps(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if ( temperature.getText().isEmpty() || evolutiontemperature.getText().isEmpty()) {
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();
        }

        else {
            // Début Expression régulière avec nombres négatifs
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher min = p.matcher(temperature.getText());
            Matcher max = p.matcher(evolutiontemperature.getText());
            boolean a = min.matches();
            boolean b = max.matches();

            if (!a || !b) {
                alert.setContentText("Erreur, que des chiffres !");
                alert.showAndWait();
            }

            else{

                temperatureDeBase = Integer.parseInt(temperature.getText());
                evolution = Integer.parseInt(evolutiontemperature.getText());

                fermerFenetre();
            }
        }


    }

    public void fermerFenetreInfo(ActionEvent actionEvent) {
        fermerFenetre();
    }

    public void fermerFenetre(){
        annuler.getScene().getWindow().hide();
    }
}
