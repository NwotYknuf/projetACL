package projet.metier;

public class PaireRegleModification{

	public int numero;
    public Regle regle;
    public ModificationScore modif;

    public PaireRegleModification(int num, Regle regle, ModificationScore modif){
    	this.numero = num;
        this.regle = regle;
        this.modif = modif;
    }    
    
}