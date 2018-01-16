package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;

/**
 * Classe GenerateurAvecTranche qui va permettre de générer une température aléatoirement entre deux intervalles
 * choisies par l'utilisateur.
 */
public class GenerateurAvecTranche extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/


    public int trancheMinimum;
    public int trancheMaximum;

    /**
     * Constructeur qui va attribuer la tranche minimum et maximum à l'objet
     * @param trancheMinimum Correspond au nombre inférieur de l'intervalle
     * @param trancheMaximum Correspond au nombre supérieur de l'intervalle
     */
    public GenerateurAvecTranche(int trancheMinimum, int trancheMaximum){
        this.trancheMinimum = trancheMinimum;
        this.trancheMaximum = trancheMaximum;
    }

    /**
     * Accesseur qui permet de récupérer la tranche minimum
     * @return La tranche minimum
     */
    public int getTrancheMinimum() {
        return trancheMinimum;
    }

    /**
     * Mutateur qui permet de modifier la tranche minimum
     * @param trancheMinimum La tranche minimum
     */
    public void setTrancheMinimum(int trancheMinimum) {
        this.trancheMinimum = trancheMinimum;
    }

    /**
     * Accesseur qui permet de récupérer la tranche maximum
     * @return La tranche maximum
     */
    public int getTrancheMaximum() {
        return trancheMaximum;
    }

    /**
     * Mutateur qui permet de modifier la tranche maximum
     * @param trancheMaximum La tranche maximum
     */
    public void setTrancheMaximum(int trancheMaximum) {
        this.trancheMaximum = trancheMaximum;
    }


    /**
     * Méthode qui va générer la température entre les deux tranches.
     * @return la valeur générée du Capteur
     */
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
