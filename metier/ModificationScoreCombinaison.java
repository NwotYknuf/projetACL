package projet.metier;

public class ModificationScoreCombinaison extends ModificationScore{

    private Combinaison combinaison;

    public ModificationScoreCombinaison(Combinaison c){
        super();
        combinaison = c;
    }

    public int calculeValeur(Carte carte1, Carte carte2){
        return combinaison.effectue(
            ConvertitHauteurValeur.convertit(carte1.getHauteur()),
            ConvertitHauteurValeur.convertit(carte2.getHauteur())
        );
    }

}