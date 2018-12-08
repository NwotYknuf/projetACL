package projet.vue;

import java.awt.event.*;

public class bJouerFJeuListener implements ActionListener{

    private FenetreJeu fenetre;
    
    public bJouerFJeuListener(FenetreJeu fenetre){
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){

        if(! fenetre.partieFinie()){
            fenetre.joueUnTour();
        }
    }
}