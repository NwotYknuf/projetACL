package projet.metier.regles;

import projet.metier.Regle;
import projet.metier.Carte;

public class RegleCompose extends Regle{

    private Regle regle1;
    private Regle regle2;

    public RegleCompose(Regle regle1, Regle regle2){
        this.regle1 = regle1;
        this.regle2 = regle2;
    }

    public boolean respecte(Carte carte1, Carte carte2){
        return regle1.respecte(carte1, carte2) && regle2.respecte(carte1, carte2);
    }

}