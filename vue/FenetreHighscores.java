package projet.vue;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.util.Vector;

import projet.metier.PaireScoreNom;
import projet.metier.Scores;

public class FenetreHighscores extends Frame {
	
    private Label lScores;
    private TextArea tbScores;
    private Button bRetour;
    
    private Vector<PaireScoreNom> scores;
    
	public FenetreHighscores() {
		
		 super("ACL - Highscores");
	        setSize(340,300);
	        setLayout(null);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        setResizable(false);
	        this.addWindowListener(new FermerFenetreListener(this));
	        
	        lScores = new Label("Voici les 10 meilleurs scores :");
	        lScores.setBounds(60, 45, 210, 15);
	        lScores.setFont(new Font("Courier New", Font.BOLD, 15));
	        //lScores.setForeground(Color.BLUE);
	        add(lScores);
	        
	        scores = Scores.getInstance().getScores();
	        
	        tbScores = new TextArea("", 10, 1, TextArea.SCROLLBARS_NONE);
	        tbScores.setBounds(30, 70, 290, 170);
	        tbScores.setEditable(false);
	        int i = 1;
	        for (PaireScoreNom paire : scores) {
	        	tbScores.append("     " + i + " :\tScore = " + paire.score + "\tPseudo = " + paire.nom + "\n");
	        	i++;
	        }
	        add(tbScores);
	        
	        bRetour = new Button("Retour");
	        bRetour.setBounds(230,250,100,40);
	        bRetour.addActionListener(new bRetourListener(this));
	        add(bRetour);
	        
	        Panel background = new Panel();
	        background.setBounds(0, 0, getWidth(), getHeight());
	        background.add(new ComposantImageAWT("/projet/ressources/background-highscores.png", getWidth(), getHeight()));
	        add(background);
	        
	        this.revalidate();
	        this.repaint();
	}

}
