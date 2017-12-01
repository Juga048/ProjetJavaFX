/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import modele.Capteur;
import modele.ModeleTexte;

/**
 *
 * @author admin
 */
public class ValidatorController implements mainController{


    @Override
    public void setValeur(int valeur){}

    @FXML
    Button Annuler;
    
    @FXML
    Button Valide;
    
    @FXML
    private TextField VilleSaisie;

    @FXML
    ComboBox MenuGenerateur;

    private Capteur capteur;

    public Capteur getCapteur() {
        return capteur;
    }

    @FXML
    public void fermerFenetreValidation(ActionEvent e){
        fermerFenetre();
    }

    public void fermerFenetre(){
        Annuler.getScene().getWindow().hide();
    }
    // + Ajouter la vérification en cas d'insertion de caractères pour la température


    // Vérifie info et remplis le capteur
    @FXML
    public void verificationInfoSaisie(ActionEvent e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Erreur");

        if (VilleSaisie.getText().isEmpty() || MenuGenerateur.getSelectionModel().getSelectedItem() == null){
            alert.setContentText("Erreur, remplissez les champs !");
            alert.showAndWait();

        }
        else {
            capteur = new Capteur(VilleSaisie.getText(),2000);
            fermerFenetre();
        }
    }



    @FXML
    public void initialize() {
        
    }
    
    
    
    
}
