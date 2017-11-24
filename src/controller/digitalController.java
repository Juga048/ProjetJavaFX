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
import modele.ModeleTexte;

/**
 *
 * @author Axel
 */
public class digitalController implements mainController{
    
    
    @FXML
    Button quit;  
    
    
    
    

    @FXML
    private void initialize() {
        
    }
    
    @FXML
    private void quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
        
        
    }
}
