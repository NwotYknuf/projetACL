package projet.metier;

public class Combinaison{

    private int coeff1;
    private int coeff2;

    public Combinaison(int coeff1, int coeff2){
        this.coeff1 = coeff1;
        this.coeff2 = coeff2;
    }

    public int effectue(int i, int j){
        return i * coeff1 + j * coeff2;
    }

}