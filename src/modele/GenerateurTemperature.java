package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;

public class GenerateurTemperature{


    // Génération d'une température aléatoire entre 0 et 2000, on enlève ensuite 1000 pour générer entre -1000 et 1000.
    public void generationAleatoire(Capteur capteur){
        int max = 1000;
        int min = -1000;
        capteur.setValue(((int) round(0 + (Math.random() * (abs(min)+max - 0))) - abs(min)));
    }


    public void generationAleatoireAvecTranche(Capteur capteur,int tempMin, int tempMax){
        capteur.setValue(((int) round(0 + (Math.random() * (abs(tempMin)+tempMax - 0))) - abs(tempMin)));
    }

    public void generationEvolutive(Capteur capteur,int temp){

    }
}
