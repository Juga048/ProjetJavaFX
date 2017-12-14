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

public class ModeleListeCapteur {

    private ObservableList<Capteur> lesCapteursObs = FXCollections.observableArrayList();

    private final ListProperty<Capteur> lesCapteurs = new SimpleListProperty<>(lesCapteursObs);
        public void setLesCapteurs(ObservableList<Capteur> value) {lesCapteurs.set(value);}
        public ObservableList<Capteur> getLesCapteurs() {return lesCapteurs.get();}
        public ListProperty<Capteur> lesCapteursProperty() {return lesCapteurs;}

    public void genererCapteurs() {
        lesCapteurs.add(new CapteurTemporise("Clermont-Ferrand",2000,new GenerateurAleatoire()));
        lesCapteurs.add(new CapteurTemporise("Paris",2000,new GenerateurAleatoire()));
        lesCapteurs.add(new CapteurTemporise("Marseille",2000,new GenerateurAleatoire()));
        lesCapteurs.add(new CapteurTemporise("Toulouse",2000,new GenerateurAleatoire()));
        lesCapteurs.add(new CapteurTemporise("Nice",2000,new GenerateurAleatoire()));
        lesCapteurs.add(new CapteurTemporise("Strasbourg",2000,new GenerateurAleatoire()));

        CapteurSuper c = new CapteurSuper("AAA");
        c.ajouterSousCapteurs(lesCapteurs.get(1));
        c.ajouterSousCapteurs(lesCapteurs.get(2));
        lesCapteurs.add(c);
    }
    
    public void ajouterCapteur(Capteur C){
        lesCapteurs.add(C);
    }

}
