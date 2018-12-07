package projet.metier;

public abstract class Regle{

    public Regle(){
        
    }

    public abstract boolean respecte(Carte carte1, Carte carte2);

}