/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class DigitalController implements MainController{

    public int val;
    @Override
    public void setValeur(int valeur){this.val = valeur;}
    
    
    @FXML
    Button quit;  
    
    @FXML
    Label AffichageDigital;
    
    

    @FXML
    public void initialize() {
        AffichageDigital.setText(String.valueOf(Integer.parseInt((String.valueOf(val))))+" °");
    }

  
    
    @FXML
    private void quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
    }
}
