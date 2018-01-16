package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;

/**
 * Classe GenerateurAleatoire qui va permettre de générer une température aléatoirement
 */
public class GenerateurAleatoire extends Generateur{

    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/

    /**
     * Méthode qui va générer la température aléatoirement entre -1000 et 1000
     * @return la valeur générée du Capteur
     */
    @Override
    public int genererUneTemperature() {
        int min = -1000;
        int max = 1000;
        int temperature;

        if ( min < 0 && max < 0) {
            // Genere que si les 2 sont positifs ou 2 négatifs
            temperature = (int) round(0 + (Math.random() * (abs(min) + max - 0))) - abs(min);
        }
        else{
            // Genere que si un seul est négatif
            temperature = (int)( Math.random()*( max - min + 1 ) ) + min;
        }

        return temperature;
    }
}
