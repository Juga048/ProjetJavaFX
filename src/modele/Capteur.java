package modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Interface Capteur
 */
public interface Capteur {
    /**
     * Mutateur qui permet de modifier la valeur du capteur
     * @param valeur La valeur du capteur
     */
    public void setValue(int valeur);
    /**
     * Accesseur qui permet de récupérer la valeur d'un capteur
     * @return La valeur du capteur
     */
    public int getValue();
    /**
     * Propriété qui va permettre le binding de la valeur du capteur
     */
    public SimpleIntegerProperty valueProperty();

    /**
     * Mutateur qui permet de modifier le nom du capteur
     * @param nom Le nom du capteur
     */
    public void setName(String nom);
    /**
     * Accesseur qui permet de récupérer le nom d'un capteur
     * @return Le nom du capteur
     */
    public String getName();
    /**
     * Propriété qui va permettre le binding du nom du capteur
     */
    public StringProperty nameProperty();

    


}
