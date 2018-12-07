package projet.vue;

import projet.metier.*;
import projet.metier.regles.*;

import java.awt.*;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.util.Collections;

public class FenetreJeu extends Frame {

    private Button retour;
    private Button jouer;
    private String pseudo;
    private Partie partie;
    
    private JLabel imageCarte1;
    private JLabel imageCarte2;

    private boolean partieFinie = false;

    public FenetreJeu(String pseudo){    
    	
        super("ACL - Jeu");
        setSize(340,300);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        this.addWindowListener(new FermerWindowListener(this));
        
        this.pseudo = pseudo;
        Label nomJoueur = new Label("Pseudo : " + pseudo);
        nomJoueur.setBounds(80, 30, 180, 20);
        add(nomJoueur);
        
        Border border = BorderFactory.createLineBorder(Color.BLUE, 3);
        
        imageCarte1 = new JLabel(new ImageIcon());
        imageCarte1.setBounds(30, 60, 120, 176);
        imageCarte1.setBorder(border);
        this.add(imageCarte1);
        
        imageCarte2 = new JLabel(new ImageIcon());
        imageCarte2.setBounds(190, 60, 120, 176);
        imageCarte2.setBorder(border);
        this.add(imageCarte2);

        retour = new Button("Retour");
        retour.setBounds(230,250,100,40);
        retour.addActionListener(new RetourListener(this));
        add(retour);

        jouer = new Button("Jouer");
        jouer.setBounds(10,250,100,40);
        jouer.addActionListener(new JouerListener(this));
        add(jouer);
        
        Vector<Carte> cartes = new Vector<Carte>();
        InititialiserPioche(cartes);

        Collections.shuffle(cartes);

        Pioche paquet = new Pioche(cartes);

        partie = new Partie(paquet, pseudo);
        
        ModificationScore somme = new ModificationScore(new Combinaison(1,1));
        ModificationScore retireSomme = new ModificationScore(new Combinaison(-1, -1));
        ModificationScore retireDoubleSomme = new ModificationScore(new Combinaison(-2, -2));

        Regle memesCouleurs = new MemesCouleurs();
        Regle memesValeurs = new MemesValeurs();
        Regle differentesCouleurs = new Inverse(memesCouleurs);
        Regle differentesValeurs = new Inverse(memesValeurs);

        Regle differentesValeursMemesCouleurs = new RegleCompose(differentesValeurs, memesCouleurs);
        Regle differentesValeursDifferentesCouleurs = new RegleCompose(differentesValeurs, differentesCouleurs);
        Regle memesValeursDifferentesCouleurs = new RegleCompose(memesValeurs, differentesCouleurs);
        Regle memesValeursMemesCouleurs = new RegleCompose(memesCouleurs, memesValeurs);

        partie.ajouterRegle(differentesValeursMemesCouleurs, somme); // D�pareill� en valeur mais m�me couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(differentesValeursDifferentesCouleurs, somme); // D�pareill� en valeur et en couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(memesValeursDifferentesCouleurs, retireSomme); // M�me valeur mais d�pareill� en couleur : Soustrait de la somme des valeurs
        partie.ajouterRegle(memesValeursMemesCouleurs, retireDoubleSomme); // M�me valeur et m�me couleur : Soustrait le double de la somme des valeurs

    }

    public boolean partieFinie(){
        return partie.finie();
    }

    public void joueUnTour(){
        partie.jouerUnTour();
        Carte[][] tirage = partie.getTirage();
        int tour = partie.getNumeroTour();
        
        System.out.println("tour : " + tour);
        System.out.println("Carte 1 : " + tirage[tour-1][0]);
        System.out.println("Carte 2 : " + tirage[tour-1][1]);
        System.out.println("Points du tour : " + partie.getScoreDuTour());
        System.out.println("score : " + partie.getScoreFinal());
        
        
        // ne fonctionne pas
        imageCarte1.setIcon(new ImageIcon("projet/ressources/" + tirage[tour-1][0].getHauteur() + "-" + tirage[tour-1][0].getFamille() + ".png"));
        imageCarte2.setIcon(new ImageIcon("projet/ressources/" + tirage[tour-1][1].getHauteur() + "-" + tirage[tour-1][1].getFamille() + ".png"));
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