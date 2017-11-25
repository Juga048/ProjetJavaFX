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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Axel
 */
public class iconeController implements mainController{
  
    @FXML
    ImageView ImageIcone;
    
    @FXML
    Button quit;
    
    @FXML
    Label content;
    
    
    @FXML
    private void Quit(ActionEvent e){
        
        quit.getScene().getWindow().hide();
        
        
    }

    public void chargeImage(int value){

        if ( value >= 0 ){
            ImageIcone.setImage(new Image("img/Weather4.png"));
            if ( value >= 10 ){
                ImageIcone.setImage(new Image("img/Weather2.png"));
                if ( value >= 20 ){
                    ImageIcone.setImage(new Image("img/Weather3.png"));
                    if ( value >= 30 ){
                        ImageIcone.setImage(new Image("img/Weather1.png"));
                    }
                }
            }
        }
    }

    @FXML
    public void initialize() {
        

    }

    

    
}
