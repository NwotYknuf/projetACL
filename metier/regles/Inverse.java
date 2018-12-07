package projet.metier.regles;

import projet.metier.*;

public class Inverse extends Regle{

    private Regle regle;

    public Inverse(Regle regle){
        this.regle = regle;
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return ! regle.respecte(carte1, carte2);
    }

}