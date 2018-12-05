package projet.vue;

import java.awt.event.*;

/*
 * Classe pour les evenements de fermeture de l'apli
 */

public class QuitterListener implements ActionListener{

    public QuitterListener(){

    }

    public void actionPerformed(ActionEvent e){
        System.exit(0);
    }

}