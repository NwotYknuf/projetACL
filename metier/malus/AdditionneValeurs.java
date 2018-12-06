package projet.metier.malus;

import projet.metier.*;

public class AdditionneValeurs extends Malus{

    public int calculeValeur(Carte carte1, Carte carte2){
        return 
        ConvertitHauteurValeur.convertit(carte1.getHauteur())
         + ConvertitHauteurValeur.convertit(carte2.getHauteur());
    }
    
}