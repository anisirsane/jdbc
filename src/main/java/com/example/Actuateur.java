package com.example;

public class Actuateur extends Obj{
    String action;
    String typeActuateur;
    int idActuateur;

    public Actuateur() {
        super();
    }
    public Actuateur(int id, int idActuateur,String nom, String typeObjet, String etat, String action, String typeActuateur) {
        super(id,nom, etat, typeObjet); 
        this.idActuateur = idActuateur;
        this.action = action;
        this.typeActuateur = typeActuateur;
    }
}