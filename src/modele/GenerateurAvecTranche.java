package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;


public class GenerateurAvecTranche extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/

    public int trancheMinimum;
    public int trancheMaximum;

    public GenerateurAvecTranche(int trancheMinimum, int trancheMaximum){
        this.trancheMinimum = trancheMinimum;
        this.trancheMaximum = trancheMaximum;
    }

    public int getTrancheMinimum() {
        return trancheMinimum;
    }

    public void setTrancheMinimum(int trancheMinimum) {
        this.trancheMinimum = trancheMinimum;
    }

    public int getTrancheMaximum() {
        return trancheMaximum;
    }

    public void setTrancheMaximum(int trancheMaximum) {
        this.trancheMaximum = trancheMaximum;
    }

    
    @Override
    public int genererUneTemperature() {
        int temperature;

        if ( getTrancheMinimum() < 0 && getTrancheMaximum() < 0) {
            temperature = (int) round(0 + (Math.random() * (abs(getTrancheMinimum()) + getTrancheMaximum() - 0))) - abs(getTrancheMinimum());
        }
        else {
            temperature = (int)( Math.random()*( getTrancheMaximum() - getTrancheMinimum() + 1 ) ) + getTrancheMinimum();
        }

        return temperature;
    }
    

       
    
}
