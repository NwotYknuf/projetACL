package projet.vue;

import java.awt.event.*;

import projet.metier.Scores;

/*
 * Classe pour les evenements de fermeture de l'apli
 */

public class QuitterListener implements ActionListener{

    public QuitterListener(){

    }

    public void actionPerformed(ActionEvent e){
        Scores.getInstance().save("scores.txt");
        System.exit(0);
    }

}