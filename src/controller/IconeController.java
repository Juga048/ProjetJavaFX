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
public class IconeController implements mainController{
    
    public int val;
    
    public void setValeur(int valeur){this.val = valeur;}
    
  
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

    
    @FXML
    public void initialize() {
        if ( val >= 0 ){
            ImageIcone.setImage(new Image("img/Weather4.png"));
            if ( val >= 10 ){
                ImageIcone.setImage(new Image("img/Weather2.png"));
                if ( val >= 20 ){
                    ImageIcone.setImage(new Image("img/Weather3.png"));
                    if ( val >= 30 ){
                        ImageIcone.setImage(new Image("img/Weather1.png"));
                    }
                }
            }
        }

    }

    

    
}
