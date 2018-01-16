package modele;

/**
 * Classe GenerateurEvolutif qui va permettre de générer une température et qui va ensuite évoluer
 * de x degrès en fonction du choix de l'utilisateur.
 */
public class GenerateurEvolutif extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/
    public int valeurIntiale;
    public int valeurAjoutee;

    /**
     * Constructeur qui va attribuer la valeur initiale en retirant la valeur ajoutée au Capteur initialement.
     * @param valeurIntiale Valeur de base
     * @param valeurAjoutee La valeur de l'évolution à chaque intervalle de temps
     */
    public GenerateurEvolutif(int valeurIntiale, int valeurAjoutee){
        this.valeurIntiale = valeurIntiale;
        this.valeurAjoutee = valeurAjoutee;
        this.valeurIntiale = this.valeurIntiale - this.valeurAjoutee; // On retire une fois la valeur ajoutée sinon le capteur est crée de base avec la valeur ajoutée en trop
    }

    /**
     * Accesseur qui permet de récuperer la valeur initiale
     * @return La valeur initiale
     */
    public int getValeurIntiale() {
        return valeurIntiale;
    }

    /**
     * Mutateur qui permet de modifier la valeur initiale
     * @param valeurIntiale La nouvelle valeur initiale
     */
    public void setValeurIntiale(int valeurIntiale) {
        this.valeurIntiale = valeurIntiale;
    }

    /**
     * Accesseur qui permet de récuperer la valeur ajoutée
     * @return La valeur ajoutée
     */
    public int getValeurAjoutee() {
        return valeurAjoutee;
    }

    /**
     * Mutateur qui permet de modifier la valeur ajoutée
     * @param valeurAjoutee La nouvelle valeur ajoutée
     */
    public void setValeurAjoutee(int valeurAjoutee) {
        this.valeurAjoutee = valeurAjoutee;
    }

    /**
     * Méthode qui va générer une températeur en ajoutant à chaque fois la valeur ajoutée à la valeur initiale
     * @return la nouvelle valeur initiale
     */
    @Override
    public int genererUneTemperature() {
        int temperature;
        valeurIntiale = (getValeurIntiale()+getValeurAjoutee());
        temperature = valeurIntiale;
        return temperature;
    }
}
