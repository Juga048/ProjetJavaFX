/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package modele;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author jugachon1
 */
public class Capteur {
    
    private final SimpleIntegerProperty value = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    
    public void setValue(int valeur){value.set(valeur);}
    public int getValue(){return value.get();}
    public SimpleIntegerProperty ValueProperty(){return value;}
    
    public void setName(String nom){name.set(nom);}
    public String getName(){return name.get();}
    public StringProperty NameProperty(){return name;}
    
    
            
        public Capteur(String nom,int valeur) 
        {
            name.set(nom);
            value.set(valeur);
	}
        
        
        public String toString(Capteur A){
            return A.name + "(" + A.value + ")";
        }
            
           
          

   
}
