package com.example;

public class Capteur extends ObjetConnecte {
    String uniteMesure;
    String donneeCapturee;
    String typeCapteur;
    int idCapteur;
    public Capteur() {
        super();
    }
    Capteur(int id,int idCapteur,String nom, String typeObjet, String etat, String uniteMesure, String donneeCapturee, String typeCapteur){
        super(id,nom, etat, typeObjet);
        this.idCapteur = idCapteur;
        this.uniteMesure = uniteMesure;
        this.donneeCapturee = donneeCapturee;
        this.typeCapteur = typeCapteur;
    }

}
