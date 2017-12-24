package modele;

public class GenerateurEvolutif extends Generateur{
    
    /*static{
        Generateur.enregistrer(GenerateurAleatoire.class);
    }*/
    
    
    @Override
    public int genererUneTemperature() {
        super.setValeurIntiale(super.getValeurIntiale()+super.getValeurAjoutee());
        return super.getValeurIntiale();
    }
}
