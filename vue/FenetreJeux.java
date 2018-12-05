package projet.vue;

import projet.metier.*;
import projet.metier.malus.*;
import projet.metier.regles.*;

import java.awt.*;
import java.util.Vector;
import java.util.Collections;

public class FenetreJeux extends Frame{

    private Button retour;
    private Button jouer;

    private Partie partie;

    private boolean partieFinie = false;

    public FenetreJeux(String pseudo){    

        super("ACL");
        setSize(340,200);
        setLayout(null);
        setVisible(true);
        this.addWindowListener(new FermerWindowListener(this));

        retour = new Button("Retour");
        retour.setBounds(230,150,100,40);
        add(retour);

        jouer = new Button("Joueur");
        jouer.setBounds(10,150,100,40);
        add(jouer);
        jouer.addActionListener(new JouerListener(this));

        Vector<Carte> cartes = new Vector<Carte>();
        cartes.add(new Carte("A", "pique"));
        cartes.add(new Carte("A", "carreau"));
        cartes.add(new Carte("A", "coeur"));
        cartes.add(new Carte("A", "trefle"));        
        cartes.add(new Carte("K", "pique"));
        cartes.add(new Carte("K", "carreau"));
        cartes.add(new Carte("K", "coeur"));
        cartes.add(new Carte("K", "trefle"));
        cartes.add(new Carte("Q", "pique"));
        cartes.add(new Carte("Q", "carreau"));
        cartes.add(new Carte("Q", "coeur"));
        cartes.add(new Carte("Q", "trefle"));

        Collections.shuffle(cartes);

        Pioche paquet = new Pioche(cartes);

        partie = new Partie(paquet, "Jean Bono");
        partie.ajouterRegle(new MemeValeur(new SommeValeures()));

    }

    public boolean partieFinie(){
        return partie.finie();
    }

    public void joueUnTour(){
        partie.jouerUnTour();
        System.out.println("tour : " + partie.getNombreTour());
        System.out.println("score : " + partie.getScore());
    }

}