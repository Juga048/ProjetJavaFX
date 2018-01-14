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
    TextField TemperatureMini;

    @FXML
    TextField TemperatureMax;

    @FXML
    Button Annuler;

    @FXML
    Button Valider;

    public int TrancheMini;
    public int TrancheMax;

    @Override
    public void setValeur(int valeur) {}
    @Override
    public void initialize() {}

    public void verifChamps(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if ( TemperatureMax.getText().isEmpty() || TemperatureMini.getText().isEmpty()) {
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();
        }
        else {
            // Début Expression régulière avec nombres négatifs
            Pattern p = Pattern.compile("-?[0-9]+");
            Matcher min = p.matcher(TemperatureMini.getText());
            Matcher max = p.matcher(TemperatureMax.getText());
            boolean a = min.matches();
            boolean b = max.matches();

            if (!a || !b) {
                alert.setContentText("Erreur, que des chiffres !");
                alert.showAndWait();
            }

            else{

                if (Integer.parseInt(TemperatureMini.getText()) >= Integer.parseInt(TemperatureMax.getText())){
                    alert.setContentText("Erreur, température Mini doit être strictement inférieure à température Max !");
                    alert.showAndWait();
                }

                else{
                    TrancheMini = Integer.parseInt(TemperatureMini.getText());
                    TrancheMax = Integer.parseInt(TemperatureMax.getText());

                    fermerFenetre();
                }


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
