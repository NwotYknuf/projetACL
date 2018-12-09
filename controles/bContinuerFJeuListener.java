package projet.controles;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import projet.vue.ComposantImageAWT;
import projet.vue.FenetreJeu;

public class bContinuerFJeuListener implements ActionListener {
	
	private FenetreJeu fenetre;

    public bContinuerFJeuListener (FenetreJeu fenetre){
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
    	fenetre.setSize(340, 400);
    	fenetre.setLocationRelativeTo(null);
    	
    	fenetre.getTbReglesJeu().setVisible(false);
    	fenetre.getlConsigne1().setVisible(false);
    	fenetre.getlConsigne2().setVisible(false);
    	fenetre.getlTour().setVisible(false);
    	fenetre.getImageCarte1().setVisible(false);
    	fenetre.getImageCarte2().setVisible(false);
    	fenetre.getlRegleAppliquee().setVisible(false);
    	fenetre.getlPointsTour().setVisible(false);
    	fenetre.getlScore().setVisible(false);
    	
    	//afficher félicitations
    	Panel pBravo = new Panel();
    	pBravo.setBounds(45, 110, 260, 120);
    	pBravo.add(new ComposantImageAWT("/projet/ressources/bravo.jpg", 260, 120));
        fenetre.add(pBravo);
    	
    	/*
    	Label lFelicitation = new Label("Félicitations !");
		lFelicitation.setBounds(60, 120, 100, 40);
		fenetre.add(lFelicitation);
    	
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("/projet/ressources/Caruban.ttf"))).getFamily(), Font.BOLD, 35);
			ge.registerFont(font);
			lFelicitation.setFont(font);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (FontFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
    	
    	//afficher scorefinal
        Label lScore = new Label("Votre score final est de : ");
        lScore.setFont(new Font("Courier New", Font.PLAIN, 12));
        lScore.setBounds(60, 250, 200, 15);
    	fenetre.add(lScore);
    	
    	Label lScoreFinal = new Label(fenetre.getPartie().getScoreFinal() + " points.");
    	lScoreFinal.setBounds(140, 265, 100, 40);
    	lScoreFinal.setFont(new Font("Times New Roman", Font.BOLD, 20));
    	lScoreFinal.setForeground(Color.BLUE);
    	fenetre.add(lScoreFinal);
    	
    	fenetre.getbRetour().setEnabled(true);
    	fenetre.getbContinuer().setVisible(false);
    	
    	Panel background = fenetre.getpBackGround();
    	background.remove(0);
    	fenetre.remove(background);
    	background.setBounds(0, 0, fenetre.getWidth(), fenetre.getHeight());
    	background.add(new ComposantImageAWT("/projet/ressources/background-jeu-termine.png", fenetre.getWidth(), fenetre.getHeight()));
    	fenetre.add(background);
    	
    	fenetre.revalidate();
    	fenetre.repaint();
    }

}
