package projet.vue;

import java.awt.*;

import projet.metier.Scores;

public class FenetreMenu extends Frame{  

    private Button bQuitter;
    private Button bLancer;
    private Button bHighscores;

    public FenetreMenu(){

        super("ACL - Menu");
        setSize(340,200);
        this.addWindowListener(new QuitterAppListener());
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        Scores.getInstance().load("scores.txt");
        
        bLancer = new Button("Lancer une partie");
        bLancer.setBounds(10,150,110,40);
        bLancer.addActionListener(new bLancerPartieFMenuListener());
        add(bLancer);

        bQuitter =new Button("Quitter");  
        bQuitter.setBounds(230,150,100,40);
        bQuitter.addActionListener(new bQuitterFMenuListener());
        add(bQuitter);

        bHighscores = new Button("Highscores");
        bHighscores.setBounds(125,150,100,40);
        bHighscores.addActionListener(new bHighscoresFMenuListener());
        add(bHighscores);

        Label titre = new Label("Super jeu");
        titre.setBounds(140, 55, 60, 60);
        add(titre);
        
        Panel background = new Panel();
        background.setBounds(0, 0, getWidth(), getHeight());
        background.add(new ComposantImageAWT("/projet/ressources/background-menu.png", 170, 170));
        add(background);
        
        this.revalidate();
        this.repaint();
    }
}
