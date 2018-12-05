package projet.vue;

import java.awt.event.*;

public class JouerListener implements ActionListener{

    private FenetreJeux fenetre;
    
    public JouerListener(FenetreJeux fenetre){
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){

        if(! fenetre.partieFinie()){
            fenetre.joueUnTour();
        }
    }
}