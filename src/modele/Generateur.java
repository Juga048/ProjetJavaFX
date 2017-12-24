package modele;

import java.util.ArrayList;

public abstract class Generateur {
    
    /*public static ArrayList<Class<? extends Generateur>> listeGenerateur;
    
    static void enregistrer(Class<? extends Generateur> sousClasse){
        listeGenerateur.add(sousClasse);
    }*/
    
    public abstract int genererUneTemperature();
    private int valeurIntiale;
    private int valeurAjoutee;
    private int trancheMaximum;
    private int trancheMinimum;

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
}
