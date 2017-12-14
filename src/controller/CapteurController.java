/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import modele.Capteur;
import modele.CapteurTemporise;
import modele.ModeleListeCapteur;


import javax.xml.validation.Validator;

/**
 *
 * @author jugachon1
 */
public class CapteurController implements MainController{



    @Override
    public void setValeur(int valeur){}

    @FXML
    Button quit;

    @FXML
    Stage stage = new Stage();
    
    
    @FXML
    private void quit (ActionEvent e){
        quit.getScene().getWindow().hide();
    }
   
    @FXML
    ComboBox MenuAffichage;



    @FXML 
    private void creerFenetreValidation(ActionEvent event) throws IOException{

        ValidatorController v = (ValidatorController) nouvelleFenetre("/ihm/ValidatorFXML.fxml", "Ajouter un capteur");

        Capteur c = v.getCapteur();
        if (c != null){
            leModele.get().ajouterCapteur(c);
        }



    }
    @FXML
    private void creerFenetreObservation(ActionEvent e) throws IOException {
        // Vérifie 2 condtions : Un capteur ET un affichage doivent être sélectionné
        if ( MenuAffichage.getValue() == null || listesDesCapteurs.getSelectionModel().getSelectedIndex() == -1) {
            return;
        }

        else {
            if (MenuAffichage.getValue().equals("Digital")) {
                DigitalController d = (DigitalController) nouvelleFenetre("/ihm/DigitalFXML.fxml", "Affichage température digitale");
            }
            if (MenuAffichage.getValue().equals("Icone")) {
                IconeController i = (IconeController) nouvelleFenetre("/ihm/IconeFXML.fxml", "Affichage température icône");
            }
            if (MenuAffichage.getValue().equals("Thermomètre")) {
                ThermometreController t = (ThermometreController) nouvelleFenetre("/ihm/ThermometreFXML.fxml", "Affichage température thermomètre");
            }
        }



    }

    // méthode permettant d'éditer la vue avant le .show
    private void editerNouvelleFenetre(MainController m) {
        if (!(m.getClass().getName().toString() == "controller.ValidatorController")){
            m.setValeur(Integer.parseInt(String.valueOf(listesDesCapteurs.getSelectionModel().getSelectedItem().getValue())));
            m.initialize();
        }
        return;
    }


    private MainController nouvelleFenetre(String nomDuFichierFXML, String titre) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource(nomDuFichierFXML));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        //Set the application title and icon
        stage.setTitle(titre);
        stage.getIcons().add(new Image("/img/thermometer_icon.png"));

        stage.setScene(scene);
        editerNouvelleFenetre(loader.getController());
        stage.showAndWait();

        return loader.getController();
        
    }
    
    // Permet de supprimer l'élément sélectionné
    @FXML
    private void retirerCapteur(ActionEvent e){
        
        if ( listesDesCapteurs != null )
        {
            listesDesCapteurs.getItems().remove(listesDesCapteurs.getSelectionModel().getSelectedItem());
        }
        else return;
        
    }
   
    
    @FXML
    private ListView<Capteur> listesDesCapteurs;
    
    public ObjectProperty<ModeleListeCapteur> leModele = new SimpleObjectProperty<>(new ModeleListeCapteur());
        public ModeleListeCapteur getLeModele(){return leModele.get();}
        public ObjectProperty<ModeleListeCapteur> leModeleProperty(){return leModele;}


    @FXML
    public void initialize() {
        leModele.get().genererCapteurs();

        listesDesCapteurs.setCellFactory(param -> 
            new ListCell<Capteur>(){
                
                @Override
                protected void updateItem(Capteur item, boolean empty) {
                    super.updateItem(item, empty);
                    if (!empty) {
                        textProperty().bind(item.nameProperty().concat(" (").concat(item.valueProperty()).concat("°)"));
                        
                        
                                      
                    } else {
                        textProperty().unbind();
                        setText("");
                    }
                }

            
            }
        );
    }

   

    
    
    
}
