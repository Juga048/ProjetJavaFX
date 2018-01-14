package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import launch.Main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfoGenerateurEvolutifController implements MainController{

    @FXML
    TextField Temperature;

    @FXML
    TextField Evolution;

    @FXML
    Button Annuler;

    @FXML
    Button Valider;

    public int temperatureDeBase;
    public int evolution;

    @Override
    public void setValeur(int valeur) {}
    @Override
    public void initialize() {}


    public void verifChamps(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if ( Temperature.getText().isEmpty() || Evolution.getText().isEmpty()) {
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();
        }

        else {
            // Début Expression régulière avec nombres négatifs
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher min = p.matcher(Temperature.getText());
            Matcher max = p.matcher(Evolution.getText());
            boolean a = min.matches();
            boolean b = max.matches();

            if (!a || !b) {
                alert.setContentText("Erreur, que des chiffres !");
                alert.showAndWait();
            }

            else{

                temperatureDeBase = Integer.parseInt(Temperature.getText());
                evolution = Integer.parseInt(Evolution.getText());

                fermerFenetre();
            }
        }


    }

    public void fermerFenetreInfo(ActionEvent actionEvent) {
        fermerFenetre();
    }

    public void fermerFenetre(){
        Annuler.getScene().getWindow().hide();
    }
}
