package projet.vue;

import java.awt.*;

public class FenetreMenu extends Frame{  

    private Label titre;
    private Button quitter;
    private Button lancer;
    private Button scores;

    public FenetreMenu(){

        super("ACL - Menu");
        setSize(340,200);
        this.addWindowListener(new QuitterWindowListener());
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);

        lancer = new Button("Lancer une partie");
        lancer.setBounds(10,150,100,40);
        lancer.addActionListener(new LancerPartieListener());
        add(lancer);

        quitter =new Button("Quitter");  
        quitter.setBounds(230,150,100,40);
        quitter.addActionListener(new QuitterListener());
        add(quitter);

        scores = new Button("Highscores");
        scores.setBounds(120,150,100,40);
        add(scores);

        titre = new Label("Super jeu de cartes");
        titre.setBounds(100, 50, 150, 50);
        add(titre);

        //charger les scores

    }
}
