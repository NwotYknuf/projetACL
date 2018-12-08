package projet.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bHighscoresFMenuListener implements ActionListener {
    
    public bHighscoresFMenuListener(){
    }

    public void actionPerformed(ActionEvent e){
    	new FenetreHighscores();
    }
}
