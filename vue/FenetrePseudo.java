package projet.vue;

import java.awt.*;

public class FenetrePseudo extends Frame{

    private Label lPseudo;
    private TextField tfChampPseudo;
    private Button bRetour;
    private Button bConfirmer;

    public FenetrePseudo(){

        super("ACL - Options");
        setSize(340,200);
        setLayout(null);
        setVisible(true);
        setLocationRelativeTo(null);
        this.addWindowListener(new FermerFenetreListener(this));

        lPseudo = new Label("Entrez votre pseudo");
        lPseudo.setBounds(60, 50, 120, 50);
        add(lPseudo);

        tfChampPseudo = new TextField(20);
        tfChampPseudo.setBounds(180, 62, 100, 25);
        tfChampPseudo.setText("");
        add(tfChampPseudo);

        bRetour = new Button("Retour");
        bRetour.setBounds(230,150,100,40);
        bRetour.addActionListener(new bRetourListener(this));
        add(bRetour);

        bConfirmer = new Button("Confirmer");
        bConfirmer.setBounds(10,150,100,40);
        bConfirmer.addActionListener(new bConfirmerFPseudoListener(this));
        add(bConfirmer);


    }

    public String getPseudo(){
        return tfChampPseudo.getText();
    }

}