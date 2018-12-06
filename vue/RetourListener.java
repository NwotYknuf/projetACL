package projet.vue;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RetourListener implements ActionListener {
	
    private Frame fenetre;
    
    public RetourListener(Frame fenetre){
    	this.fenetre = fenetre;
    }

    public void actionPerformed(ActionEvent e){
    	fenetre.dispose();
    }
}
