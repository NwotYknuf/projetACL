package projet.metier;

import java.util.Vector;
import java.util.Collections;

public class Pioche{

    private Vector<Carte> cartes;

    public Pioche(Vector<Carte> cartes){
        this.cartes = new Vector<Carte>(cartes);
    }

    public void melanger(){
        Collections.shuffle(cartes);
    }

    public Carte piocher(){

        if(!cartes.isEmpty()){
            Carte c = cartes.get(0);
            cartes.remove(0);
            return c;
        }
        else{
            return null;
        }
    }

}