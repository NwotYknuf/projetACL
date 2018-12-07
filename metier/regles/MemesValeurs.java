package projet.metier.regles;

import projet.metier.*;

public class MemesValeurs extends Regle{

    public MemesValeurs(){
        
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return carte1.getHauteur().equals(carte2.getHauteur());
        //ConvertitFamilleCouleur.convertit(carte1.getFamille()) == ConvertitFamilleCouleur.convertit(carte2.getFamille()) ) // M�me couleurs
    }

}
