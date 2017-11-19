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
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import modele.Capteur;
import modele.ModeleTexte;

/**
 *
 * @author admin
 */
public class ValidatorController implements Initializable{
    
    
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
    public void Valide(Event e) {
                
                System.out.println(" " + VilleSaisie.getText() + TempératureSaisie.getText());
               
       
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
    
    
    
}
