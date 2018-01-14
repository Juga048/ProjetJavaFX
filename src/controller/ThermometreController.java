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
import javafx.scene.control.ProgressBar;



public class ThermometreController implements MainController{
    
    public int val;
    @Override
    public void setValeur(int valeur){this.val = valeur;}
    
    
    @FXML
    ProgressBar progressBar;

    @FXML
    Button quit;

    @FXML
    Label indicateurThermometre;
   

    @FXML
    public void initialize() {
        // en supposant que température entre 0 et 50, 50 donne 1 -> barre au max
        if ( val < 0 ){
            progressBar.setProgress(0);
        }
        else{
            progressBar.setProgress((((double) val)/50));
        }
        indicateurThermometre.setText(String.valueOf(Integer.parseInt((String.valueOf(val))))+" °");    
    }


    @FXML
    private void Quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
        
        
    }
}
