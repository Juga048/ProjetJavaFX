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
public class CapteurController implements MainController{

   
    
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
          ValidatorController v = (ValidatorController) nouvelleFenetre("/ihm/ValidatorFXML.fxml", "Ajouter un capteur");
          
       }
       
       if ( id.equals("icone"))
       {
           nouvelleFenetre("/ihm/IconeFXML.fxml", "Affichage température icône");
       }
       
       if ( id.equals("digital"))
       {
           nouvelleFenetre("/ihm/DigitalFXML.fxml","Affichage température digitale");
       
           
          
       }
       
       if ( id.equals("thermometre"))
       {
           nouvelleFenetre("/ihm/ThermometreFXML.fxml","Affichage température thermomètre");
           
       }
       
          
    }

    private MainController nouvelleFenetre(String nomDuFichierFXML, String titre) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nomDuFichierFXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        //Set the application title and icon
        stage.setTitle(titre);
        stage.getIcons().add(new Image("/img/thermometer_icon.png"));
        
        stage.setScene(scene);
        stage.showAndWait();
        
        return loader.getController();
        
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
  
  
    @FXML
    public void initialize() {
        
        leModele.get().GenererCapteurs();
       
        
        listesDesCapteurs.setCellFactory(param -> 
            new ListCell<Capteur>(){
                
                @Override
                protected void updateItem(Capteur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        textProperty().bind(item.NameProperty().concat(" (").concat(item.ValueProperty()).concat(")"));
                        
                        
                                      
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }

            
            }
        );
    }

   

    
    
    
}
