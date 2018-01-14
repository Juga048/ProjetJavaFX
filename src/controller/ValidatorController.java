/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modele.*;


public class ValidatorController implements MainController{


    @Override
    public void setValeur(int valeur){}

    @FXML
    Stage stage = new Stage();

    @FXML
    Button Annuler;
    
    @FXML
    Button Valider;
    
    @FXML
    private TextField VilleSaisie;

    @FXML
    private TextField TempsSaisie;

    @FXML
    ComboBox MenuGenerateur;

    private Capteur capteur;

    public Capteur getCapteur() {
        return capteur;
    }

    public void fermerFenetreValidation(ActionEvent e){
        fermerFenetre();
    }

    public void fermerFenetre(){
        Annuler.getScene().getWindow().hide();
    }



    // Vérifie info et remplis le capteur
    @FXML
    public void verificationInfoSaisie(ActionEvent e) throws IOException {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if (VilleSaisie.getText().isEmpty() || TempsSaisie.getText().isEmpty() || MenuGenerateur.getSelectionModel().getSelectedItem() == null){
            
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();
            
        }
        
        else {
            
            // Début Expression régulière
            Pattern p = Pattern.compile("[0-9]+");
            Matcher m = p.matcher(TempsSaisie.getText());
            boolean b = m.matches();
            
            if (!b){         
                alert.setContentText("Erreur, Que des chiffres pour le temps !");
                alert.showAndWait();
            }
            
            else{

                switch(MenuGenerateur.getSelectionModel().getSelectedItem().toString()){
                    case "Génération évolutive":
                        InfoGenerateurEvolutifController j = (InfoGenerateurEvolutifController) nouvelleFenetre("/ihm/InfoGenerateurEvolutif.fxml");
                        if (j.temperatureDeBase != 0 && j.evolution != 0){
                            capteur = new CapteurTemporise(VilleSaisie.getText(),Long.parseLong(TempsSaisie.getText()), new GenerateurEvolutif(j.temperatureDeBase,j.evolution));
                            fermerFenetre();
                        }
                        break;

                    case "Génération entre x et y":
                        InfoGenerateurAvecTrancheController i = (InfoGenerateurAvecTrancheController) nouvelleFenetre("/ihm/InfoGenerateurAvecTranche.fxml");
                        if (i.trancheMini != 0 && i.trancheMax != 0) {
                            capteur = new CapteurTemporise(VilleSaisie.getText(), Long.parseLong(TempsSaisie.getText()), new GenerateurAvecTranche(i.trancheMini, i.trancheMax));
                            fermerFenetre();
                        }
                        break;
                    case "Génération Aléatoire":
                        capteur = new CapteurTemporise(VilleSaisie.getText(),Long.parseLong(TempsSaisie.getText()),new GenerateurAleatoire());
                        fermerFenetre();
                        break;
                }
            }
        }
    }

    public MainController nouvelleFenetre(String nomDuFichierFXML) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(nomDuFichierFXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        //Set the application title and icon
        stage.setTitle("Infos Complémentaires");
        stage.getIcons().add(new Image("/img/thermometer_icon.png"));
        stage.setScene(scene);
        stage.showAndWait();

        return loader.getController();

    }



    @FXML
    public void initialize() {
        
    }
    
    
    
    
}
