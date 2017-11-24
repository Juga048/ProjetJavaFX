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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modele.Capteur;
import modele.ModeleTexte;

/**
 *
 * @author admin
 */
public class validatorController implements mainController{
    
    
    @FXML
    Button Annuler;
    
    @FXML
    Button Valide;
    
    @FXML
    private TextField VilleSaisie;
    
    @FXML
    private TextField TempératureSaisie;
    
    @FXML
    private void Cancel(ActionEvent e){

        Annuler.getScene().getWindow().hide();
    }
          
    @FXML
    public Capteur Valide() {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, there was an error!");

        if (VilleSaisie.getText().isEmpty() || TempératureSaisie.getText().isEmpty()){
            alert.showAndWait();
            return null;
        }

        Capteur C = new Capteur(VilleSaisie.getText(),Integer.parseInt(TempératureSaisie.getText()));
        TempératureSaisie.getScene().getWindow().hide();
        return C;    
    }

    @FXML
    public void initialize() {
        
    }
    
    
    
    
}
