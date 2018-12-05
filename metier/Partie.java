package projet.metier;

import java.util.Vector;;

public class Partie{

    public static final int NBR_TOURS = 5;

    private Vector<Regle> regles;
    private Pioche paquet;
    private Scores scores;
    private Carte[][] tirage;
    
    private int tour = 0;
    private int score = 0;
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

    public int getNombreTour(){
        return tour;
    }

    public int getScore(){
        return score;
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
                score += regle.pointA_Ajouter(carte1, carte2);
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
        scores.addScore(score, pseudo);
        scores.save("scores.txt");
    }

}