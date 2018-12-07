package projet.metier.regles;

import projet.metier.*;

public class MemesCouleurs extends Regle{

    public MemesCouleurs(){
        
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return ConvertitFamilleCouleur.convertit(carte1.getFamille()).equals(
            ConvertitFamilleCouleur.convertit(carte2.getFamille())); // M�me couleurs
    }

}
