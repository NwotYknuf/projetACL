package projet.metier.malus;

import projet.metier.Carte;
import projet.metier.ConvertitHauteurValeur;
import projet.metier.Malus;

public class SoustraitValeurs extends Malus {
	
	public int calculeValeur(Carte carte1, Carte carte2){
        return 
        - (ConvertitHauteurValeur.convertit(carte1.getHauteur())
         + ConvertitHauteurValeur.convertit(carte2.getHauteur()));
    }
    
}
