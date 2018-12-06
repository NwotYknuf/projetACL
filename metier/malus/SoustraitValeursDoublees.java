package projet.metier.malus;

import projet.metier.Carte;
import projet.metier.ConvertitHauteurValeur;
import projet.metier.Malus;

public class SoustraitValeursDoublees extends Malus {
	
	public int calculeValeur(Carte carte1, Carte carte2){
        return 
        -2 * (ConvertitHauteurValeur.convertit(carte1.getHauteur())
         + ConvertitHauteurValeur.convertit(carte2.getHauteur()));
    }
    
}