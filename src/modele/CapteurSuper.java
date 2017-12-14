package modele;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CapteurSuper implements Capteur{

    private ArrayList<Capteur> lesSousCapteurs = new ArrayList<>();
    public SimpleIntegerProperty value = new SimpleIntegerProperty();
    public StringProperty name = new SimpleStringProperty();

    public void setValue(int valeur){value.set(valeur);}
    public int getValue(){return value.get();}
    public SimpleIntegerProperty valueProperty(){return value;}

    public void setName(String nom){name.set(nom);}
    public String getName(){return name.get();}
    public StringProperty nameProperty(){return name;}


    public CapteurSuper(String nom) {
        name.set("super - "+nom);
        this.setValue(calculerMoyennePonderee());
    }

    public void ajouterSousCapteurs(Capteur c){
        lesSousCapteurs.add(c);
        this.setValue(calculerMoyennePonderee());
    }

    private int calculerMoyennePonderee() {
        int longueur = lesSousCapteurs.size();
        int i, total = 0;
        for (i = 0; i < longueur; i++ ){
            total += lesSousCapteurs.get(i).getValue();
        }

        return total;
    }
}