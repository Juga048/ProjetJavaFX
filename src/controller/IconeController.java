/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Capteur;

/**
 *
 * @author Axel
 */
public class IconeController implements MainController{
  
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
        
        ImageIcone.setImage(new Image("img/Weather1.png"));
    }

    

    
}
