package projet.vue;

import java.awt.event.*;

public class ConfirmerListener implements ActionListener{

    private FenetrePseudo fenetrePseudo;

    public ConfirmerListener(FenetrePseudo fenetrePseudo){
        this.fenetrePseudo = fenetrePseudo;
    }

    public void actionPerformed(ActionEvent e){
    	
    	String pseudo = fenetrePseudo.getPseudo();
        //Verifs sur le pseudo
    	if (pseudo.length() < 1 || pseudo.length() > 20) {
    		System.out.println("Pseudo invalide");
    	}
    	else { //Creer une nouvelle fenetre de jeux
    		new FenetreJeux(pseudo);
    		fenetrePseudo.dispose();
    	}
    }
}