package projet.vue;

import java.awt.*;

public class FenetrePseudo extends Frame{

    private Label labelPseudo;
    private TextField champPseudo;
    private Button retour;
    private Button confirmer;

    public FenetrePseudo(){

        super("ACL - Options");
        setSize(340,200);
        setLayout(null);
        setVisible(true);
        this.addWindowListener(new FermerWindowListener(this));

        labelPseudo = new Label("Entrez votre pseudo");
        labelPseudo.setBounds(60, 50, 120, 50);
        add(labelPseudo);

        champPseudo = new TextField(20);
        champPseudo.setBounds(180, 62, 100, 25);
        add(champPseudo);

        retour = new Button("Retour");
        retour.setBounds(230,150,100,40);
        add(retour);

        confirmer = new Button("Confirmer");
        confirmer.setBounds(10,150,100,40);
        add(confirmer);


    }

    public String getPseudo(){
        return champPseudo.getText();
    }

}