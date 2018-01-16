package modele;

public abstract class Generateur {
    
    /*public static ArrayList<Class<? extends Generateur>> listeGenerateur;
    
    static void enregistrer(Class<? extends Generateur> sousClasse){
        listeGenerateur.add(sousClasse);
    }*/


    /**
     * Méthode qui va générer une température en fonction du générateur lié au Capteur.
     */
    public abstract int genererUneTemperature();
}
