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
import javafx.scene.control.*;

import java.util.*;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
public class capteurController implements mainController{

   
    
    @FXML
    Button quit;

    @FXML
    Stage stage = new Stage();
    
    
    @FXML
    private void Quit (ActionEvent e){

        quit.getScene().getWindow().hide();
    }
   
    @FXML
    ComboBox MenuAffichage;


    @FXML 
    private void CreateWindow(ActionEvent event) throws IOException{

        validatorController v = (validatorController) nouvelleFenetre("/ihm/ValidatorFXML.fxml", "Ajouter un capteur");

        Capteur c = v.getCapteur();
        if (c != null){
            leModele.get().AjouterCapteur(c);
        }



    }
    @FXML
    private void Valider(ActionEvent e) throws IOException {
        // Vérifie 2 condtions : Un capteur ET un affichage doivent être sélectionné
        if ( MenuAffichage.getValue() == null || listesDesCapteurs.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }

        else {
            if (MenuAffichage.getValue().equals("Digital")) {
                digitalController d = (digitalController) nouvelleFenetre("/ihm/DigitalFXML.fxml", "Affichage température digitale");
            }
            if (MenuAffichage.getValue().equals("Icone")) {
                iconeController i = (iconeController) nouvelleFenetre("/ihm/IconeFXML.fxml", "Affichage température icône");
            }
            if (MenuAffichage.getValue().equals("Thermomètre")) {
                thermometreController t = (thermometreController) nouvelleFenetre("/ihm/ThermometreFXML.fxml", "Affichage température thermomètre");
            }
        }



    }

    // méthode permettant d'éditer la vue avant le .show
    private void edit(mainController m){

        if (m.getClass().getName() == "controller.digitalController") {
            ((digitalController) m).chargeTemperature(Integer.parseInt(String.valueOf(listesDesCapteurs.getSelectionModel().getSelectedItem().getValue())));
        }
        if (m.getClass().getName() == "controller.iconeController") {
            ((iconeController) m).chargeImage(Integer.parseInt(String.valueOf(listesDesCapteurs.getSelectionModel().getSelectedItem().getValue())));
        }
        if (m.getClass().getName() == "controller.thermometreController") {
            ((thermometreController) m).chargeThermometre(Integer.parseInt(String.valueOf(listesDesCapteurs.getSelectionModel().getSelectedItem().getValue())));
        }
    }


    private mainController nouvelleFenetre(String nomDuFichierFXML, String titre) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nomDuFichierFXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        //Set the application title and icon
        stage.setTitle(titre);
        stage.getIcons().add(new Image("/img/thermometer_icon.png"));

        stage.setScene(scene);
        edit(loader.getController());
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
        else return;
        
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
                        textProperty().bind(item.NameProperty().concat(" (").concat(item.ValueProperty()).concat("°)"));
                        
                        
                                      
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }

            
            }
        );
    }

   

    
    
    
}
