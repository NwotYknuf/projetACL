package projet.vue;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.Vector;

import projet.metier.PaireScoreNom;
import projet.metier.Scores;

public class FenetreHighscores extends Frame {
	

    private Label lScores;
    private TextArea tbScores;
    private Button retour;
    
    private Vector<PaireScoreNom> scores;
    
	public FenetreHighscores() {
		
		 super("ACL - Highscores");
	        setSize(340,300);
	        setLayout(null);
	        setVisible(true);
	        setLocationRelativeTo(null);
	        this.addWindowListener(new FermerWindowListener(this));
	        
	        lScores = new Label("Voici les 10 meilleurs scores :");
	        lScores.setBounds(20, 50, 200, 10);
	        add(lScores);
	        
	        scores = Scores.getInstance().getScores();
	        
	        tbScores = new TextArea("", 10, 1, TextArea.SCROLLBARS_NONE);
	        tbScores.setBounds(40, 70, 270, 170);
	        tbScores.setEditable(false);
	        int i = 1;
	        for (PaireScoreNom paire : scores) {
	        	tbScores.append("     N�" + i + " : Score = " + paire.score + " ; Pseudo = " + paire.nom + "\n");
	        	i++;
	        }
	        add(tbScores);
	        
	        retour = new Button("Retour");
	        retour.setBounds(230,250,100,40);
	        retour.addActionListener(new RetourListener(this));
	        add(retour);
	}

}
