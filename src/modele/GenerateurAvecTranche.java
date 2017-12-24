package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;

public class GenerateurAvecTranche extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/
    
    
    @Override
    public int genererUneTemperature() {
        int max = 5;
        int min = -5;
        int temperature = (int) round(0 + (Math.random() * (abs(min)+max - 0))) - abs(min);

        return temperature;
       
    }
}
