package projet.metier;

import java.util.Vector;;

public class Partie{

    public static final int NBR_TOURS = 5;

    private Vector<Regle> regles;
    private Pioche paquet;
    private Scores scores;
    private Carte[][] tirage;
    
    private int tour = 0;
    private int scoreFinal = 0;
    private int scoreDuTour = 0;
    private String pseudo;
    private boolean partieFinie = false;

    public Partie(Pioche pioche, String nom){
        this.paquet = pioche;
        regles = new Vector<Regle>();
        tirage = new Carte[NBR_TOURS][2];
        this.pseudo = nom;
        scores = new Scores();//A bouger
    }

    public void ajouterRegle(Regle r){
        regles.add(r);
    }

    public int getNumeroTour(){
        return tour;
    }

    public int getScoreFinal(){
        return scoreFinal;
    }
    
    public int getScoreDuTour() {
    	return scoreDuTour;
    }
    
    public Carte[][] getTirage() {
    	return tirage;
    }

    public boolean finie(){
        return partieFinie;
    }

    public void jouerUnTour(){

        Carte carte1 = paquet.piocher();
        Carte carte2 = paquet.piocher();

        tirage[tour][0] = carte1;
        tirage[tour][1] = carte2;

        for(Regle regle : regles){
            if(regle.respecte(carte1, carte2)){
            	scoreDuTour = regle.pointA_Ajouter(carte1, carte2);
                scoreFinal += scoreDuTour;
            }
        }

        if(tour == NBR_TOURS - 1){
            finDePartie();
        }
        tour ++;
    }

    public void debutDePartie(){
        scores.load("scores.txt");
    }

    public void finDePartie(){
        partieFinie = true;
        scores.addScore(scoreFinal, pseudo);
        scores.save("scores.txt");
    }

}