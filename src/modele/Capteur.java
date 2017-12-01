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

import static java.lang.StrictMath.round;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;


/**
 *
 * @author jugachon1
 */
public class Capteur extends GenerateurTemperature implements Runnable{
    
    private final SimpleIntegerProperty value = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private long temps;
    
    public void setValue(int valeur){value.set(valeur);}
    public int getValue(){return value.get();}
    public SimpleIntegerProperty ValueProperty(){return value;}
    
    public void setName(String nom){name.set(nom);}
    public String getName(){return name.get();}
    public StringProperty NameProperty(){return name;}


    
    

        public Capteur(String nom, long temps){
            name.set(nom);
            generationAleatoire(this);
            this.temps = temps;
            new Thread(this).start();      
        }


        public String toString(Capteur A){
            return A.name + "(" + A.value + ")";
        }
            
        
        public void run(){
            while(true){
                
            
            try 
            {
                Thread.sleep(temps);
            } 
            catch (InterruptedException ex) 
            {
                Logger.getLogger(Capteur.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
            Platform.runLater(()-> generationAleatoire(this));
            }

        }           
}
