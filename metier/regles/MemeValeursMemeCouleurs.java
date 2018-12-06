package projet.metier.regles;

import projet.metier.*;

public class MemeValeursMemeCouleurs extends Regle{

    public MemeValeursMemeCouleurs(Malus malus){
        super(malus);
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return ( 
         	   (carte1.getHauteur() == carte2.getHauteur()) // M�me valeur
         		&& 
         	   ( ConvertitFamilleCouleur.convertit(carte1.getFamille()) == ConvertitFamilleCouleur.convertit(carte2.getFamille()) ) // M�me couleurs
         	   );
    }

}
