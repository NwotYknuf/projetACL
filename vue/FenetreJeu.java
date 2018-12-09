package projet.vue;

import projet.metier.*;
import projet.metier.regles.*;

import java.util.Vector;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.Collections;

public class FenetreJeu extends Frame {

    private Partie partie;
    
    private Button bRetour, bJouer, bContinuer;
    private Label lConsigne1, lConsigne2, lTour, lRegleAppliquee, lPointsTour, lScore;
    private Panel imageCarte1, imageCarte2;
    private Panel pBackground;
    private TextArea tbReglesJeu;

    public FenetreJeu(String pseudo){    
    	
        super("ACL - Jeu");
        setSize(640,400);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        this.addWindowListener(new FermerFenetreListener(this));
        
        //Label Pseudo
        Label lNomJoueur = new Label("Joueur : " + pseudo);
        lNomJoueur.setBounds(30, 40, 130, 15);
        add(lNomJoueur);
        
        //Label comment jouer
        lConsigne1 = new Label("Appuyez sur \"Jouer\" pour piocher deux cartes !");
        lConsigne1.setBounds(50, 60, 270, 15);
        add(lConsigne1);
        lConsigne2 = new Label("Vous avez 5 tours pour faire le meilleur score (négatif) !");
        lConsigne2.setBounds(20, 75, 305, 15);
        add(lConsigne2);
        
        // Label numéro du tour
        lTour = new Label("Tour n°0 : ");
        lTour.setBounds(145, 100, 50, 15);
        lTour.setForeground(Color.BLUE);
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
        
        // Label Regle Appliquée
        lRegleAppliquee = new Label("");
        lRegleAppliquee.setBounds(50, 295, 200, 15);
        add(lRegleAppliquee);

        // Label Points du tour
        lPointsTour = new Label("");
        lPointsTour.setBounds(50, 310, 220, 15);
        add(lPointsTour);
        
        // Label Score du joueur
        lScore = new Label("Votre score : 0 point");
        lScore.setBounds(50, 330, 180, 15);
        lScore.setForeground(Color.BLUE);
        add(lScore);
        
        //Bouton Retour
        bRetour = new Button("Retour");
        bRetour.setBounds(230,350,100,40);
        bRetour.addActionListener(new bRetourListener(this));
        add(bRetour);

        // Bouton Jouer
        bJouer = new Button("Jouer");
        bJouer.setBounds(10,350,100,40);
        bJouer.addActionListener(new bJouerFJeuListener(this));
        add(bJouer);
        
        // Bouton Continuer pour visualiser le score après le jeu
        bContinuer = new Button("Continuer");
    	bContinuer.setBounds(10,350,100,40);
    	bContinuer.addActionListener(new bContinuerFJeuListener(this));
    	bContinuer.setVisible(false); // Non visible au départ
        add(bContinuer);
        
        // TextArea Explication des règles
        tbReglesJeu = new TextArea("", 20, 1, TextArea.SCROLLBARS_NONE);
        tbReglesJeu.setBounds(335, 35, 295, 355);
        tbReglesJeu.setFont(new Font("Courier New", Font.PLAIN, 11));
        tbReglesJeu.setEditable(false);
        tbReglesJeu.append("  Voici les règles du jeu :\n\n");
        tbReglesJeu.append("  A chaque tour de jeu, deux cartes seront piochées, celles-ci vous rapporteront des points en fonctions du tirage selon le schéma suivant : \n");
        tbReglesJeu.append("     1 - Les deux cartes n'ont pas la même valeur et/ou n'ont pas la même couleur = Ajout de la valeur des 2 cartes. \n");
        tbReglesJeu.append("     2 - Les deux cartes ont la même valeur mais n'ont pas la même couleur = Retrait de la valeur des 2 cartes. \n");
        tbReglesJeu.append("     3 - Les deux cartes ont la même valeur et ont la même couleur = Retrait 2 fois de la valeur des 2 cartes. \n\n");
        tbReglesJeu.append("  Vient enfin la valeur des cartes : \n");
        tbReglesJeu.append("     - As : 11 points\n");
        tbReglesJeu.append("     - 10 : 10 points\n");
        tbReglesJeu.append("     - Roi : 4 points\n");
        tbReglesJeu.append("     - Dame : 3 points\n");
        tbReglesJeu.append("     - Valet : 2 points\n");
        tbReglesJeu.append("     - 9 : 0 point\n");
        tbReglesJeu.append("     - 8 : 0 point\n");
        tbReglesJeu.append("     - 7 : 0 point\n\n");
        tbReglesJeu.append("  Le but étant d'avoir le nombre de points le plus faible !\n  Bon jeu !");
        add(tbReglesJeu);
        
        pBackground = new Panel();
        pBackground.setBounds(0, 0, getWidth(), getHeight());
        pBackground.add(new ComposantImageAWT("/projet/ressources/background-jeu.png", getWidth(), getHeight()));
        add(pBackground);
        
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

        RegleComposee differentesValeursMemesCouleurs = new RegleComposee(differentesValeurs, memesCouleurs);
        RegleComposee differentesValeursDifferentesCouleurs = new RegleComposee(differentesValeurs, differentesCouleurs);
        RegleComposee memesValeursDifferentesCouleurs = new RegleComposee(memesValeurs, differentesCouleurs);
        RegleComposee memesValeursMemesCouleurs = new RegleComposee(memesCouleurs, memesValeurs);

        partie.ajouterRegle(1, differentesValeursMemesCouleurs, somme); // Dï¿½pareillï¿½ en valeur mais mï¿½me couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(1, differentesValeursDifferentesCouleurs, somme); // Dï¿½pareillï¿½ en valeur et en couleur : Ajout de la somme des valeurs
        partie.ajouterRegle(2, memesValeursDifferentesCouleurs, retireSomme); // Mï¿½me valeur mais dï¿½pareillï¿½ en couleur : Soustrait de la somme des valeurs
        partie.ajouterRegle(3, memesValeursMemesCouleurs, retireDoubleSomme); // Mï¿½me valeur et mï¿½me couleur : Soustrait le double de la somme des valeurs

        this.revalidate();
        this.repaint();
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
        int regleAppliquee = partie.getRegleDuTour();
        lRegleAppliquee.setText("Grâce à la règle numéro " + regleAppliquee + " ;");
        
        //Affiche les points du tour
        lPointsTour.setText("Vous optenez sur ce tour : " + partie.getScoreDuTour() + " points.");
        
        //Affiche les scores
        lScore.setText("Votre score : " + partie.getScoreFinal() + " points.");
        
        System.out.println("Tour n°" + tour + " : ");
        System.out.println("Carte 1 : " + tirage[tour-1][0]);
        System.out.println("Carte 2 : " + tirage[tour-1][1]);
        System.out.println("Points du tour : " + partie.getScoreDuTour());
        System.out.println("score : " + partie.getScoreFinal());
        
        if (partieFinie()) {
        	bJouer.setVisible(false);
        	bRetour.setEnabled(false);
        	
        	bContinuer.setVisible(true);
        }
        
        //Met à jour les composants sur la fenêtre
        this.revalidate();
        this.repaint();
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

	public Label getlConsigne1() {
		return lConsigne1;
	}

	public Label getlConsigne2() {
		return lConsigne2;
	}

	public Label getlTour() {
		return lTour;
	}

	public Label getlRegleAppliquee() {
		return lRegleAppliquee;
	}

	public Label getlPointsTour() {
		return lPointsTour;
	}

	public Label getlScore() {
		return lScore;
	}

	public TextArea getTbReglesJeu() {
		return tbReglesJeu;
	}

	public Panel getImageCarte1() {
		return imageCarte1;
	}

	public Panel getImageCarte2() {
		return imageCarte2;
	}

	public Panel getpBackGround() {
		return pBackground;
	}
	
	public Partie getPartie() {
		return partie;
	}

	public Button getbRetour() {
		return bRetour;
	}

	public Button getbJouer() {
		return bJouer;
	}
	
	public Button getbContinuer() {
		return bContinuer;
	}
}