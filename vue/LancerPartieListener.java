package projet.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LancerPartieListener implements ActionListener {
    
    public LancerPartieListener(){
    }

    public void actionPerformed(ActionEvent e){
    	new FenetrePseudo();
        
    }
}
