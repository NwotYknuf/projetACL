package projet.vue;

import java.awt.event.*;
import java.awt.*;

public class FermerWindowListener implements WindowListener{

    private Frame window;

    public FermerWindowListener(Frame window){
        this.window = window;
    }

    public void windowClosed(WindowEvent e){

    }

    public void windowDeiconified(WindowEvent e){

    }

    public void windowClosing(WindowEvent e){
        window.dispose();
    }

    public void windowOpened(WindowEvent e){

    }

    public void windowActivated(WindowEvent e){

    }

    public void windowDeactivated(WindowEvent e){

    }

    public void windowIconified(WindowEvent e){

    }

}