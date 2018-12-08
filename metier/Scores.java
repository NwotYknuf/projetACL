package projet.metier;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Scores{

    private final int NB_SCORE = 10;

    private static Scores INSTANCE = null;
    private Vector<PaireScoreNom> scores;

    private Scores(){
        scores = new Vector<PaireScoreNom>();
    }
    
    public static Scores getInstance(){           
        if (INSTANCE == null){   
            INSTANCE = new Scores(); 
        }
        return INSTANCE;
    }

    public Vector<PaireScoreNom> getScores() {
		return scores;
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

        String str = "";
        File file = new File(path);
        try{
            FileWriter writer = new FileWriter(file);

            for(PaireScoreNom paire : scores){
                str += paire.score + " " + paire.nom + "\n";
            }

            writer.write(str);
            writer.close();
        }
        catch(Exception e){

        }        

    }

    public void load(String path){

        scores.clear();

        File file = new File(path);
        
        if (! file.exists()){ // Si le fichier n'existe pas, le créer
          try {
			file.createNewFile();
			System.out.println("Fichier : " + path + " créé.");
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
        }
        
        try{
            FileReader reader = new FileReader(file);

            char[] text = new char[1024];
            reader.read(text);
            Scanner scanner = new Scanner(String.valueOf(text));

            while(true){
                int score = scanner.nextInt();
                String nom = scanner.nextLine();
                nom = nom.trim();
                this.addScore(score, nom);
            }
        }
        catch(NoSuchElementException e){
            //Fin de la boucle
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


}