/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModeleTexte {

    private ObservableList<Capteur> lesCapteursObs = FXCollections.observableArrayList();

    private final ListProperty<Capteur> lesCapteurs = new SimpleListProperty<>(lesCapteursObs);
        public void setLesCapteurs(ObservableList<Capteur> value) {lesCapteurs.set(value);}
        public ObservableList<Capteur> getLesCapteurs() {return lesCapteurs.get();}
        public ListProperty<Capteur> lesCapteursProperty() {return lesCapteurs;}

    public void GenererCapteurs() {
        lesCapteurs.add(new Capteur("Clermont-Ferrand",15));
        lesCapteurs.add(new Capteur("Paris",0));
        lesCapteurs.add(new Capteur("Marseille",30));
        lesCapteurs.add(new Capteur("Toulouse",1));
        lesCapteurs.add(new Capteur("Nice",20));
        lesCapteurs.add(new Capteur("Strasbourg",10));
    }
    
    public void AjouterCapteur(Capteur C){
        lesCapteurs.add(C);
    }

}
