package projet.metier;

public class Carte{

    private String hauteur;
    private String famille;


    public Carte(String hauteur, String famille){
        this.hauteur = hauteur;
        this.famille = famille;
    }

    public String getHauteur(){
        return hauteur;
    }

    public String getFamille(){
        return famille;
    }

	@Override
	public String toString() {
		return "Carte [hauteur=" + hauteur + ", famille=" + famille + "]";
	}


}