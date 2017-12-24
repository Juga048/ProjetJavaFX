package modele;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public interface Capteur {


    public void setValue(int valeur);
    public int getValue();
    public SimpleIntegerProperty valueProperty();

    public void setName(String nom);
    public String getName();
    public StringProperty nameProperty();

    


}
