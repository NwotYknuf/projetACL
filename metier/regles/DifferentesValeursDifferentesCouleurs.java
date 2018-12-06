package projet.metier.regles;

import projet.metier.*;

public class DifferentesValeursDifferentesCouleurs extends Regle{

    public DifferentesValeursDifferentesCouleurs(Malus malus){
        super(malus);
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return ( 
        	   (carte1.getHauteur() != carte2.getHauteur()) // Différentes valeur
        		&& 
        	   ( ConvertitFamilleCouleur.convertit(carte1.getFamille()) != ConvertitFamilleCouleur.convertit(carte2.getFamille()) ) // Différentes couleurs
        	   ); 
    }

}