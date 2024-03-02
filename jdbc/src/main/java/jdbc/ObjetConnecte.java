package jdbc;

public class ObjetConnecte {
    int id;
    String nom;
    String etat;
    public ObjetConnecte(){

    }
    public ObjetConnecte(int id, String nom, String etat) {
        this.id = id;
        this.nom = nom;
        this.etat = etat;
    }    
}
