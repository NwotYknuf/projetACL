package projet.metier;

public class ConvertitFamilleCouleur{

    public static String convertit(String famille){
        if(famille.equals("coeur") || famille.equals("carreau")){
            return "rouge";
        }
        else{
            return "noir";
        }

    }

}