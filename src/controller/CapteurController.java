/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.util.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.ListCell;
import javafx.scene.control.SelectionMode;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modele.Capteur;
import modele.ModeleTexte;

/**
 *
 * @author jugachon1
 */
public class CapteurController implements Initializable{

   
    
    @FXML
    Button quit;
    
   
    @FXML
    Stage stage = new Stage();
    
    
    @FXML
    private void Quit (ActionEvent e){
        quit.getScene().getWindow().hide();
    }
   
    
    
    @FXML 
    private void CreateWindow(ActionEvent event) throws IOException{
       
        // Permet de récupérer l'ID du bouton cliqué
       Button btn = (Button) event.getSource();
       String id = btn.getId();
       
       if ( id.equals("ajouter"))
       {
           Parent root = FXMLLoader.load(getClass().getResource("/ihm/ValidatorFXML.fxml"));
           Scene scene = new Scene(root);
           
           //Set the application title and icon
           stage.setTitle("Ajouter un capteur");
           stage.getIcons().add(new Image("/img/thermometer_icon.png"));
           
           stage.setScene(scene);
           stage.showAndWait();
          
       }
       
       if ( id.equals("icone"))
       {
           Parent root = FXMLLoader.load(getClass().getResource("/ihm/IconeFXML.fxml"));
           Scene scene = new Scene(root);
           
           //Set the application title and icon
           stage.setTitle("Affichage température icône");
           stage.getIcons().add(new Image("/img/thermometer_icon.png"));
           
           stage.setScene(scene);
           stage.showAndWait();
       }
       
       if ( id.equals("digital"))
       {
           Parent root = FXMLLoader.load(getClass().getResource("/ihm/DigitalFXML.fxml"));
           Scene scene = new Scene(root);
           
           //Set the application title and icon
           stage.setTitle("Affichage température digitale");
           stage.getIcons().add(new Image("/img/thermometer_icon.png"));
           
           stage.setScene(scene);
           stage.showAndWait();
           
          
       }
       
       if ( id.equals("thermometre"))
       {
           Parent root = FXMLLoader.load(getClass().getResource("/ihm/ThermometreFXML.fxml"));
           Scene scene = new Scene(root);
           
           //Set the application title and icon
           stage.setTitle("Affichage température thermomètre");
           stage.getIcons().add(new Image("/img/thermometer_icon.png"));
           
           stage.setScene(scene);
           stage.showAndWait();
       }
       
          
    }
    
    // Permet de supprimer l'élément sélectionné
    @FXML
    private void Remove(ActionEvent e){ 
        
        if ( listesDesCapteurs != null )
        {
            listesDesCapteurs.getItems().remove(listesDesCapteurs.getSelectionModel().getSelectedItem());
        }
        
    }
   
    
    @FXML
    private ListView<Capteur> listesDesCapteurs;
    
    public ObjectProperty<ModeleTexte> leModele = new SimpleObjectProperty<>(new ModeleTexte());
        public ModeleTexte getLeModele(){return leModele.get();}
        public ObjectProperty<ModeleTexte> leModeleProperty(){return leModele;}
  
  
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        leModele.get().GenererCapteurs();
        
        
        listesDesCapteurs.setCellFactory(param -> 
            new ListCell<Capteur>(){
                
                @Override
                protected void updateItem(Capteur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        textProperty().bind(item.NameProperty());
                        
                        
                                      
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }

            
            }
        );
    }

   

    
    
    
}
