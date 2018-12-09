package projet.controles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import projet.vue.FenetrePseudo;

public class bLancerPartieFMenuListener implements ActionListener {
    
    public bLancerPartieFMenuListener(){
    }

    public void actionPerformed(ActionEvent e){
    	new FenetrePseudo();
        
    }
}
