package projet.metier;

public abstract class Regle{

    private Malus malus;

    public Regle(Malus malus){
        this.malus = malus;
    }

    public abstract boolean respecte(Carte carte1, Carte carte2);

    public int pointA_Ajouter(Carte carte1, Carte carte2){
        return malus.calculeValeur(carte1, carte2);
    }

}