package projet.vue;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

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
    	
    	//afficher felicitation
    	
    	Label lFelicitation = new Label("Félicitations !");
		lFelicitation.setBounds(60, 120, 100, 40);
		fenetre.add(lFelicitation);
    	
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Font font = new Font(Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("/projet/ressources/Black-Melody.otf"))).getFamily(), Font.BOLD, 35);
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
		}
    	
    	//afficher scorefinal
    	Label lScoreFinal = new Label("Votre score final est de : " + fenetre.getPartie().getScoreFinal() + " points.");
    	lScoreFinal.setBounds(60, 180, 300, 40);
    	fenetre.add(lScoreFinal);
    	
    	fenetre.getbRetour().setEnabled(true);
    	fenetre.getbContinuer().setVisible(false);
    }

}
