package modele;

import java.util.ArrayList;

public abstract class Generateur {
    
    /*public static ArrayList<Class<? extends Generateur>> listeGenerateur;
    
    static void enregistrer(Class<? extends Generateur> sousClasse){
        listeGenerateur.add(sousClasse);
    }*/
    
    public abstract int genererUneTemperature();
}
