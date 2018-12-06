package projet.metier.regles;

import projet.metier.Carte;
import projet.metier.ConvertitFamilleCouleur;
import projet.metier.Malus;
import projet.metier.Regle;

public class DifferentesValeursMemeCouleurs extends Regle {
    public DifferentesValeursMemeCouleurs(Malus malus){
        super(malus);
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return ( 
        	   (carte1.getHauteur() != carte2.getHauteur()) // Différentes valeur
        		&& 
        	   ( ConvertitFamilleCouleur.convertit(carte1.getFamille()) == ConvertitFamilleCouleur.convertit(carte2.getFamille()) ) // Différentes couleurs
        	   ); 
    }

}
