/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package modele;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;


/**
 *
 * @author jugachon1
 */
public class CapteurTemporise implements Capteur, Runnable{

    public SimpleIntegerProperty value = new SimpleIntegerProperty();
    public StringProperty name = new SimpleStringProperty();
    private long temps;
    private Generateur generateur;
    private boolean isRunning = false;


    public void setTemps(long time){temps=time;}
    public long getTemps(){return temps;}

    public void setValue(int valeur){value.set(valeur);}
    public int getValue(){return value.get();}
    public SimpleIntegerProperty valueProperty(){return value;}

    public void setName(String nom){name.set(nom);}
    public String getName(){return name.get();}
    public StringProperty nameProperty(){return name;}


    public CapteurTemporise(String nom, long temps, Generateur generateur){
        this.setName(nom);
        this.generateur = generateur;
        this.setValue(generateur.genererUneTemperature());

        this.setTemps(temps);
        isRunning = true;
        new Thread(this).start();
    }

    public void ArreterThread(){
        this.isRunning = false;
    }

    @Override
    public void run(){

        while(isRunning){

            try
            {
                Thread.sleep(temps);
            }
            catch (InterruptedException ex)
            {
                Logger.getLogger(Capteur.class.getName()).log(Level.SEVERE, null, ex);
                Thread.currentThread().interrupt();
            }
            Platform.runLater(()-> this.setValue(this.generateur.genererUneTemperature()));
        }
        

    }
}
