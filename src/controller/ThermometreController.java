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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import modele.Capteur;


/**
 *
 * @author Axel
 */
public class ThermometreController implements MainController{
    
    public int val;
    @Override
    public void setValeur(int valeur){this.val = valeur;}
    
    
    @FXML
    ProgressBar ProgressBar;
    
    @FXML
    ProgressIndicator ProgressIndi;
    
    @FXML
    Button quit;

    @FXML
    Label indicateurThermometre;
   

    @FXML
    public void initialize() {
        // en supposant que température entre 0 et 50, 50 donne 1 -> barre au max
        ProgressBar.setProgress((((double) val)/50));
        indicateurThermometre.setText(String.valueOf(Integer.parseInt((String.valueOf(val))))+" °");    
    }


    @FXML
    private void Quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
        
        
    }
}
