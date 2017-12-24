/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import modele.Capteur;
import modele.CapteurTemporise;
import modele.GenerateurAleatoire;


/**
 *
 * @author admin
 */
public class ValidatorController implements MainController{


    @Override
    public void setValeur(int valeur){}

    @FXML
    Button Annuler;
    
    @FXML
    Button Valide;
    
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
                capteur = new CapteurTemporise(VilleSaisie.getText(),Long.parseLong(TempsSaisie.getText()),new GenerateurAleatoire());
                fermerFenetre();
            }
        }
    }



    @FXML
    public void initialize() {
        
    }
    
    
    
    
}
