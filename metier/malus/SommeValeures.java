package projet.metier.malus;

import projet.metier.*;

public class SommeValeures extends Malus{

    public int calculeValeur(Carte carte1, Carte carte2){
        return ConvertitHauteurValeure.convertit(carte1.getHauteur()) + ConvertitHauteurValeure.convertit(carte2.getHauteur());
    }
    
}