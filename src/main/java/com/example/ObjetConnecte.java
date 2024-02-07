package com.example;

public class ObjetConnecte {
    String nom, typeObjet, etat;
    int id;
    public ObjetConnecte(){

    }
    public ObjetConnecte(int id, String nom, String typeObjet, String etat) {
        this.id = id;
        this.nom = nom;
        this.typeObjet = typeObjet;
        this.etat = etat;
    }  
}
