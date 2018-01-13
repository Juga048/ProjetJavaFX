package modele;

public class GenerateurEvolutif extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/
    public int valeurIntiale;
    public int valeurAjoutee;

    public int getValeurIntiale() {
        return valeurIntiale;
    }

    public void setValeurIntiale(int valeurIntiale) {
        this.valeurIntiale = valeurIntiale;
    }

    public int getValeurAjoutee() {
        return valeurAjoutee;
    }

    public void setValeurAjoutee(int valeurAjoutee) {
        this.valeurAjoutee = valeurAjoutee;
    }

    @Override
    public int genererUneTemperature() {
        valeurIntiale = (getValeurIntiale()+getValeurAjoutee());
        return valeurIntiale;
    }
}
