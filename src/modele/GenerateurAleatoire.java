package modele;

import static java.lang.StrictMath.abs;
import static java.lang.StrictMath.round;

public class GenerateurAleatoire extends Generateur{

    @Override
    public int genererUneTemperature() {
        int max = 1000;
        int min = -1000;
        int temperature = (int) round(0 + (Math.random() * (abs(min)+max - 0))) - abs(min);

        return temperature;
    }
}
