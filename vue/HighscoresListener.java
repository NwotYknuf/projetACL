package projet.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighscoresListener implements ActionListener {
    
    public HighscoresListener(){
    }

    public void actionPerformed(ActionEvent e){
    	new FenetreHighscores();
    }
}
