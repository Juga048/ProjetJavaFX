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
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import modele.Capteur;


/**
 *
 * @author Axel
 */
public class ThermometreController implements Initializable{
    
    
    
    @FXML
    ProgressBar ProgressBar;
    
    @FXML
    ProgressIndicator ProgressIndi;
    
    @FXML
    Button quit;
    
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ProgressBar.setProgress(0.5);
        ProgressBar.setRotate(270);
        ProgressIndi.setProgress(0.5);
    }
    
    @FXML
    private void Quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
        
        
    }
}
