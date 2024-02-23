package com.example;

public class Obj {
    String nom, typeObjet, etat;
    int id;
    public Obj(){

    }
    public Obj(int id, String nom, String typeObjet, String etat) {
        this.id = id;
        this.nom = nom;
        this.typeObjet = typeObjet;
        this.etat = etat;
    }  
}
