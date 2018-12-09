package projet.controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projet.vue.FenetreHighscores;

public class bHighscoresFMenuListener implements ActionListener {
    
    public bHighscoresFMenuListener(){
    }

    public void actionPerformed(ActionEvent e){
    	new FenetreHighscores();
    }
}
