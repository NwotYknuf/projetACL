package projet.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmerListener implements ActionListener{

    private FenetrePseudo fenetrePseudo;

    public ConfirmerListener(FenetrePseudo fenetrePseudo){
        this.fenetrePseudo = fenetrePseudo;
    }

    public void actionPerformed(ActionEvent e){
    	
    	String pseudo = fenetrePseudo.getPseudo();
    	
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
    		fenetrePseudo.dispose();
    	}
    }
}