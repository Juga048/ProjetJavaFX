/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import modele.ModeleTexte;

/**
 *
 * @author Axel
 */
public class DigitalController implements mainController{
    
    
    @FXML
    Button quit;  
    
    @FXML
    Label AffichageDigital;
    
    

    @FXML
    private void initialize() {

    }

    public void chargerTemperature(int value){
        AffichageDigital.setText(String.valueOf(Integer.parseInt((String.valueOf(value))))+" °");
    }
    
    @FXML
    private void quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
    }
}
