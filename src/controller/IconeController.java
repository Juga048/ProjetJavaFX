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


public class IconeController implements MainController{

    public int val;
    @Override
    public void setValeur(int valeur){this.val = valeur;}
    
  
    @FXML
    ImageView imageIcone;
    
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
        if ( val <= -20 ) {
            imageIcone.setImage(new Image("img/Weather4.png"));
        }
        else if (val > -20 && val <= 0) {
            imageIcone.setImage(new Image("img/Weather2.png"));
        }
        else if (val > 0 && val < 20){
            imageIcone.setImage(new Image("img/Weather3.png"));
        }
        else if (val >= 20) {
            imageIcone.setImage(new Image("img/Weather1.png"));
        }
    }

    

    
}
