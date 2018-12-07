package projet.metier;

import java.util.Vector;;

public class Partie{

    public static final int NBR_TOURS = 5;

    private Vector<PaireRegleModification> regles;
    private Pioche paquet;
    private Carte[][] tirage;
    
    private int tour = 0;
    private int scoreFinal = 0;
    private int scoreDuTour = 0;
    private String pseudo;
    private boolean partieFinie = false;

    public Partie(Pioche pioche, String nom){
        this.paquet = pioche;
        regles = new Vector<PaireRegleModification>();
        tirage = new Carte[NBR_TOURS][2];
        this.pseudo = nom;
    }

    public void ajouterRegle(Regle r, ModificationScore m){
        regles.add(new PaireRegleModification(r, m));
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

        for(PaireRegleModification paire : regles){
            if(paire.regle.respecte(carte1, carte2)){
            	scoreDuTour = paire.modif.calculeValeur(carte1, carte2);
                scoreFinal += scoreDuTour;
            }
        }

        paquet.rajouterCarte(carte1);
        paquet.rajouterCarte(carte2);
        paquet.melanger();

        if(tour == NBR_TOURS - 1){
            finDePartie();
        }
        tour ++;
    }

    public void debutDePartie(){
        
    }

    public void finDePartie(){
        partieFinie = true;
        Scores.getInstance().addScore(scoreFinal, pseudo);
    }

}