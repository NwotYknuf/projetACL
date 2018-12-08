package projet.vue;

import java.awt.*;

import projet.metier.Scores;

public class FenetreMenu extends Frame{  

    private Label titre;
    private Button bQuitter;
    private Button bLancer;
    private Button bHighscores;

    public FenetreMenu(){

        super("ACL - Menu");
        setSize(340,200);
        this.addWindowListener(new QuitterAppListener());
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

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

        titre = new Label("Super jeu de cartes");
        titre.setBounds(100, 50, 150, 50);
        add(titre);

        Scores.getInstance().load("scores.txt");
    }
}
