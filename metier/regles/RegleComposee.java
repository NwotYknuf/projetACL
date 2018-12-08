package projet.metier.regles;

import projet.metier.Regle;
import projet.metier.Carte;

public class RegleComposee extends Regle{

    private Regle regle1;
    private Regle regle2;

    public RegleComposee(Regle regle1, Regle regle2){
        this.regle1 = regle1;
        this.regle2 = regle2;
    }

	public Regle getRegle1() {
		return regle1;
	}

	public Regle getRegle2() {
		return regle2;
	}

	public boolean respecte(Carte carte1, Carte carte2){
        return regle1.respecte(carte1, carte2) && regle2.respecte(carte1, carte2);
    }

}