package modele;

import java.util.ArrayList;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe CapteurSuper
 */
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

    /**
     * Constructeur qui va attribuer un nom et une valeur
     * @param nom Correspond au nom du CapteurSuper
     */
    public CapteurSuper(String nom) {
        name.set("(S) - "+nom);
        this.setValue(calculerValeur());
    }

    /**
     * Methode qui permet d'ajouter un capteur à la liste des capteurs du CapteurSuper,
     * la valeur du CapteurSuper se met à jour avec l'ajout.
     * @param capteur Correspond au capteur que l'on ajoute à la liste
     */
    public void ajouterSousCapteurs(Capteur capteur){
        lesSousCapteurs.add(capteur);
        this.setValue(calculerValeur());
    }

    /**
     * Methode qui permet de calculer la valeur du CapteurSuper en fonction de la valeur
     * des capteurs contenues dans sa liste.
     * @return Retourne le total des valeurs des Capteurs
     */
    private int calculerValeur() {
        int longueur = lesSousCapteurs.size();
        int i, total = 0;
        for (i = 0; i < longueur; i++ ){
            total += lesSousCapteurs.get(i).getValue();
        }

        return total;
    }

}