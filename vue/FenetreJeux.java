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

        super("ACL - Jeu");
        setSize(340,200);
        setLayout(null);
        setVisible(true);
        this.addWindowListener(new FermerWindowListener(this));

        retour = new Button("Retour");
        retour.setBounds(230,150,100,40);
        add(retour);

        jouer = new Button("Jouer");
        jouer.setBounds(10,150,100,40);
        add(jouer);
        jouer.addActionListener(new JouerListener(this));

        Vector<Carte> cartes = new Vector<Carte>();
        InititialiserPioche(cartes);

        Collections.shuffle(cartes);

        Pioche paquet = new Pioche(cartes);

        partie = new Partie(paquet, "Jean Bono");
        
        partie.ajouterRegle(new DifferentesValeursMemeCouleurs(new AdditionneValeurs())); // Dépareillé en valeur mais même couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(new DifferentesValeursDifferentesCouleurs(new AdditionneValeurs())); // Dépareillé en valeur et en couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(new MemeValeursDifferentesCouleurs(new SoustraitValeurs())); // Même valeur mais dépareillé en couleur : Soustrait de la somme des valeurs
        partie.ajouterRegle(new MemeValeursMemeCouleurs(new SoustraitValeursDoublees())); // Même valeur et même couleur : Soustrait le double de la somme des valeurs

    }

    public boolean partieFinie(){
        return partie.finie();
    }

    public void joueUnTour(){
        partie.jouerUnTour();
        System.out.println("tour : " + partie.getNombreTour());
        System.out.println("score : " + partie.getScore());
    }
    
    public void InititialiserPioche(Vector<Carte> cartes) {
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

        cartes.add(new Carte("V", "pique"));
        cartes.add(new Carte("V", "carreau"));
        cartes.add(new Carte("V", "coeur"));
        cartes.add(new Carte("V", "trefle"));

        cartes.add(new Carte("10", "pique"));
        cartes.add(new Carte("10", "carreau"));
        cartes.add(new Carte("10", "coeur"));
        cartes.add(new Carte("10", "trefle"));

        cartes.add(new Carte("9", "pique"));
        cartes.add(new Carte("9", "carreau"));
        cartes.add(new Carte("9", "coeur"));
        cartes.add(new Carte("9", "trefle"));

        cartes.add(new Carte("8", "pique"));
        cartes.add(new Carte("8", "carreau"));
        cartes.add(new Carte("8", "coeur"));
        cartes.add(new Carte("8", "trefle"));

        cartes.add(new Carte("7", "pique"));
        cartes.add(new Carte("7", "carreau"));
        cartes.add(new Carte("7", "coeur"));
        cartes.add(new Carte("7", "trefle"));
    }

}