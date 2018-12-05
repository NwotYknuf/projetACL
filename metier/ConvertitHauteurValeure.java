package projet.metier;

public class ConvertitHauteurValeure{

    public static int convertit(String hauteur){
        if(hauteur.equals("A")){
            return 11;
        }
        if(hauteur.equals("K")){
            return 4;
        }
        if(hauteur.equals("D")){
            return 3;
        }
        if(hauteur.equals("V")){
            return 2;
        }
        if(hauteur.equals("10")){
            return 10;
        }
        return 0;
    }

}