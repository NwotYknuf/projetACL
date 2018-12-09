package projet.controles;

import java.awt.event.*;

import projet.metier.Scores;

/*
 * Classe pour les evenements de fermeture de l'apli
 */

public class bQuitterFMenuListener implements ActionListener{

    public bQuitterFMenuListener(){

    }

    public void actionPerformed(ActionEvent e){
        Scores.getInstance().save("scores.txt");
        System.exit(0);
    }

}