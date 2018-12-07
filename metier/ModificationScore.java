package projet.metier;

public class ModificationScore{

    private Combinaison combinaison;

    public ModificationScore(Combinaison c){
        combinaison = c;
    }

    public int calculeValeur(Carte carte1, Carte carte2){
        return combinaison.effectue(
            ConvertitHauteurValeur.convertit(carte1.getHauteur()),
            ConvertitHauteurValeur.convertit(carte2.getHauteur())
        );
    }

}