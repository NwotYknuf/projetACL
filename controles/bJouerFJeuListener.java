package projet.controles;

import java.awt.event.*;

import projet.vue.FenetreJeu;

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