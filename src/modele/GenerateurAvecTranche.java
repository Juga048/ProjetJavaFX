package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;


public class GenerateurAvecTranche extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/
    
    
    @Override
    public int genererUneTemperature() {
        int temperature = (int) round(0 + (Math.random() * (abs(super.getTrancheMinimum())+super.getTrancheMaximum() - 0))) - abs(super.getTrancheMinimum());

        return temperature;
    }
    

       
    
}
