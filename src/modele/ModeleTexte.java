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

    public void genererCapteurs() {
        lesCapteurs.add(new Capteur("Clermont-Ferrand",2000));
        lesCapteurs.add(new Capteur("Paris",2000));
        lesCapteurs.add(new Capteur("Marseille",2000));
        lesCapteurs.add(new Capteur("Toulouse",2000));
        lesCapteurs.add(new Capteur("Nice",2000));
        lesCapteurs.add(new Capteur("Strasbourg",2000));
    }
    
    public void ajouterCapteur(Capteur C){
        lesCapteurs.add(C);
    }

}
