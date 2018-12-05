package projet.metier;

public class PaireScoreNom implements Comparable{

    public int score;
    public String nom;

    public PaireScoreNom(int score, String nom){
        this.score = score;
        this.nom = nom;
    }

    
    public int compareTo(Object o){

        PaireScoreNom paire = (PaireScoreNom)o;

        if(this.score < paire.score){
            return -1;
        }

        if(this.score > paire.score){
            return 1;
        }

        return 0;

    }
    
}