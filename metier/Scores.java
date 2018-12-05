package projet.metier;

import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Scores{

    private final int NB_SCORE = 10;

    private Vector<PaireScoreNom> scores;

    public Scores(){
        scores = new Vector<PaireScoreNom>();
    }
    
    public void addScore(int score, String nom){

        PaireScoreNom paire = new PaireScoreNom(score, nom);
        scores.add(paire);
        Collections.sort(scores);

        if(scores.size() > NB_SCORE){
            scores.remove(NB_SCORE);
        }

    }

    public void save(String path){

        File file = new File(path);
        try{
            FileWriter writer = new FileWriter(file);

            for(PaireScoreNom paire : scores){
                writer.write(paire.score + " " + paire.nom);
            }

            writer.close();
        }
        catch(Exception e){

        }        

    }

    public void load(String path){

        scores.clear();

        File file = new File(path);

        try{
            FileReader reader = new FileReader(file);

            char[] ligne = new char[256];

            while(reader.read(ligne)>0){
                Scanner scanner = new Scanner(String.valueOf(ligne));

                int score = scanner.nextInt();
                String nom = scanner.next();
                nom.trim();

                scores.add(new PaireScoreNom(score, nom));
            }
        }
        catch(Exception e){

        }
    }


}