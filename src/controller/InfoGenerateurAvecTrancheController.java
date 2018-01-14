package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InfoGenerateurAvecTrancheController implements MainController {

    @FXML
    TextField temperatureMini;

    @FXML
    TextField temperatureMax;

    @FXML
    Button annuler;

    @FXML
    Button valider;

    public int trancheMini;
    public int trancheMax;

    @Override
    public void setValeur(int valeur) {}
    @Override
    public void initialize() {}

    public void verifChamps(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if ( temperatureMax.getText().isEmpty() || temperatureMini.getText().isEmpty()) {
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();
        }
        else {
            // Début Expression régulière avec nombres négatifs
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher min = p.matcher(temperatureMini.getText());
            Matcher max = p.matcher(temperatureMax.getText());
            boolean a = min.matches();
            boolean b = max.matches();

            if (!a || !b) {
                alert.setContentText("Erreur, que des chiffres !");
                alert.showAndWait();
            }

            else{

                if (Integer.parseInt(temperatureMini.getText()) >= Integer.parseInt(temperatureMax.getText())){
                    alert.setContentText("Erreur, température Mini doit être strictement inférieure à température Max !");
                    alert.showAndWait();
                }

                else{
                    trancheMini = Integer.parseInt(temperatureMini.getText());
                    trancheMax = Integer.parseInt(temperatureMax.getText());

                    fermerFenetre();
                }


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
