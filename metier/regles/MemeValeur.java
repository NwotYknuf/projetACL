package projet.metier.regles;

import projet.metier.*;

public class MemeValeur extends Regle{

    public MemeValeur(Malus malus){
        super(malus);
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return carte1.getHauteur() == carte2.getHauteur();
    }

}