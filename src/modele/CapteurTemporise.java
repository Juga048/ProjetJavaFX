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
 * Classe CapteurTemporise
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

    /**
     * Constructeur qui va attribuer un nom, une valeur de temps et un generateur
     * @param nom Correspond au nom du CapteurTemporise
     * @param temps Correspond à l'intervalle de temps à laquelle la valeur du Capteur va se mettre à jour
     * @param generateur Correspond à la méthode de génération de valeur choisie
     */
    public CapteurTemporise(String nom, long temps, Generateur generateur){
        this.setName(nom);
        this.generateur = generateur;
        this.setValue(generateur.genererUneTemperature());

        this.setTemps(temps);
        isRunning = true;
        new Thread(this).start();
    }

    /**
     * Méthode qui aurait le but de stopper les threads lorsque le programme est fermé.
     */
    public void ArreterThread(){
        this.isRunning = false;
    }

    /**
     * Méthode qui permet de mettre à jour la valeur des Capteurs à l'intervalle de temps choisie.
     * La valeur est générée par le generateur du Capteur.
     */
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
