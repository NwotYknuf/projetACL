package projet.controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projet.vue.FenetreJeu;
import projet.vue.FenetrePseudo;

public class bConfirmerFPseudoListener implements ActionListener{

    private FenetrePseudo fenetre;

    public bConfirmerFPseudoListener(FenetrePseudo fenetre){
        this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
    	
    	String pseudo = fenetre.getPseudo();
    	
    	String regExpression = "[a-zA-Z_0-9]*"; 
        
        //Verifs sur le pseudo
    	if (pseudo.length() < 1 || pseudo.length() > 12) { // Test si le pseudo est nul ou supérieur à 12 caractères
    		System.out.println("Pseudo invalide");
    	}
    	else if (!pseudo.matches(regExpression)) { // Test si le pseudo contient autre chose que des lettres et numéro
    		System.out.println("Pseudo invalide");
    	}
    	else { //Le pseudo est correct, créer une nouvelle fenetre de jeux
    		new FenetreJeu(pseudo);
    		fenetre.dispose();
    	}
    }
}