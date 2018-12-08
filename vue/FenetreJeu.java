package projet.vue;

import projet.metier.*;
import projet.metier.regles.*;

import java.util.Vector;
import java.awt.Button;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;

public class FenetreJeu extends Frame {

    private Button retour;
    private Button jouer;
    private Partie partie;
    
    private Label lConsigne1, lConsigne2, lTour, lPointsTour, lScore;
    private Panel imageCarte1;
    private Panel imageCarte2;

    public FenetreJeu(String pseudo){    
    	
        super("ACL - Jeu");
        setSize(340,400);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        this.addWindowListener(new FermerWindowListener(this));
        
        //Label Pseudo
        Label lNomJoueur = new Label("Joueur : " + pseudo);
        lNomJoueur.setBounds(30, 40, 180, 10);
        add(lNomJoueur);
        
        //Label comment jouer
        lConsigne1 = new Label("Appuyez sur \"Jouer\" pour piocher deux cartes !");
        lConsigne1.setBounds(50, 60, 270, 10);
        add(lConsigne1);
        lConsigne2 = new Label("Vous avez 5 tours pour faire le meilleur score (négatif) !");
        lConsigne2.setBounds(20, 75, 320, 10);
        add(lConsigne2);
        
        // Label numéro du tour
        lTour = new Label("Tour n°0 : ");
        lTour.setBounds(145, 100, 100, 10);
        add(lTour);
        
        // Panel image de la carte 1
        imageCarte1 = new Panel();
        imageCarte1.setBounds(30, 110, 120, 180);
        imageCarte1.add(new ComposantImageAWT("/projet/ressources/0.png", 120, 175));
        add(imageCarte1);
        
        // Panel image de la carte 2
        imageCarte2 = new Panel();
        imageCarte2.setBounds(190, 110, 120, 180);
        imageCarte2.add(new ComposantImageAWT("/projet/ressources/0.png", 120, 175));
        add(imageCarte2);

        // Label Points du tour
        lPointsTour = new Label("");
        lPointsTour.setBounds(50, 310, 220, 20);
        add(lPointsTour);
        
        // Label Score du joueur
        lScore = new Label("Votre score : 0 point");
        lScore.setBounds(50, 330, 180, 20);
        add(lScore);
        
        //Bouton Retour
        retour = new Button("Retour");
        retour.setBounds(230,350,100,40);
        retour.addActionListener(new RetourListener(this));
        add(retour);

        // Bouton Jouer
        jouer = new Button("Jouer");
        jouer.setBounds(10,350,100,40);
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

        partie.ajouterRegle(differentesValeursMemesCouleurs, somme); // Dï¿½pareillï¿½ en valeur mais mï¿½me couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(differentesValeursDifferentesCouleurs, somme); // Dï¿½pareillï¿½ en valeur et en couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(memesValeursDifferentesCouleurs, retireSomme); // Mï¿½me valeur mais dï¿½pareillï¿½ en couleur : Soustrait de la somme des valeurs
        partie.ajouterRegle(memesValeursMemesCouleurs, retireDoubleSomme); // Mï¿½me valeur et mï¿½me couleur : Soustrait le double de la somme des valeurs

        
    }

    public boolean partieFinie(){
        return partie.finie();
    }

    public void joueUnTour(){
        partie.jouerUnTour();      
        
        //Affiche le tour
        
        int tour = partie.getNumeroTour();
        lTour.setText("Tour n°" + tour + " : ");
        
        //Affiche les cartes
        
        Carte[][] tirage = partie.getTirage();
        
        String pathImage1 = "/projet/ressources/" + tirage[tour-1][0].getHauteur() + "-" + tirage[tour-1][0].getFamille() + ".png";
        String pathImage2 = "/projet/ressources/" + tirage[tour-1][1].getHauteur() + "-" + tirage[tour-1][1].getFamille() + ".png";
        
        imageCarte1.remove(0);
        imageCarte1.add(new ComposantImageAWT(pathImage1, 120, 175));
        
        imageCarte2.remove(0);
        imageCarte2.add(new ComposantImageAWT(pathImage2, 120, 175));
        
        //Affiche la règle appliquée
        
        //Affiche les points du tour
        lPointsTour.setText("Vous remportez sur ce tour : " + partie.getScoreDuTour() + " points.");
        
        //Affiche les scores
        lScore.setText("Votre score : " + partie.getScoreFinal() + " points.");
        
        //Met à jour les composants sur la fenêtre
        this.revalidate();
        this.repaint();
        
        
        System.out.println("Tour n°" + tour + " : ");
        System.out.println("Carte 1 : " + tirage[tour-1][0]);
        System.out.println("Carte 2 : " + tirage[tour-1][1]);
        System.out.println("Points du tour : " + partie.getScoreDuTour());
        System.out.println("score : " + partie.getScoreFinal());
        
        
        if (partieFinie()) {
        	//afficher felicitation
        	
        	Label lFelicitation = new Label("Félicitations !");
			lFelicitation.setBounds(60, 120, 100, 40);
			add(lFelicitation);
        	
			try {
				GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Font font = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("/projet/ressources/Black-Melody.otf"))).getFamily(), Font.BOLD, 35);
				ge.registerFont(font);
				lFelicitation.setFont(font);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	//afficher scorefinal
        	Label lScoreFinal = new Label("Votre score final est de : " + partie.getScoreFinal() + " points.");
        	lScoreFinal.setBounds(60, 180, 300, 40);
        	add(lScoreFinal);
        	
        	
        	lConsigne1.setVisible(false);
        	lConsigne2.setVisible(false);
        	lTour.setVisible(false);
        	imageCarte1.setVisible(false);
        	imageCarte2.setVisible(false);
        	lPointsTour.setVisible(false);
        	lScore.setVisible(false);
        	
        	jouer.setEnabled(false);
        }
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