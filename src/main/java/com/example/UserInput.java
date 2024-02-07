package com.example;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserInput implements AutoCloseable{
        public static int choixMenu(){
            Scanner choice = new Scanner(System.in);
            //affichage des options de menu
            System.out.println ("Menu:choisir unde des fonctionalites du CRUD");
            System.out.println ("1. creer un nouveau appareil: ");
            System.out.println ("2. modifier un appareil: ");
            System.out.println ("3. affichet touts les appareils: ");
            System.out.println ("4. supprimer un appareil: ");
            System.out.println ("Entrez votre choix:");
            //recuperation de choix et les retourner
            int choix = choice.nextInt();   
            return choix;
            } 
        public static void insertObjet() throws Exception {
            Scanner sc = new Scanner(System.in);
            System.out.println("inserer le type d'objet");

            System.out.println("1 pour capteur et 2 pour actuateur");
            int choicedevice = sc.nextInt();
            sc.nextLine();  
            while(choicedevice!=1 && choicedevice!=2){
                System.out.println("ressayer, ce n'est pas valide : ");
                choicedevice = sc.nextInt();
                sc.nextLine();  
                if(choicedevice==1 || choicedevice == 2){
                    break;
                }
            }
            if (choicedevice == 1){
                Capteur cpt = new Capteur();
                cpt.typeObjet="capteur";
                System.out.println("inserer l'id d'objet'");
                cpt.id= sc.nextInt();
                sc.nextLine();
                System.out.println("inserer le nom du capteur");
                cpt.nom = sc.nextLine();
                System.out.println("inserer l'id du capteur");
                cpt.idCapteur = sc.nextInt();
                sc.nextLine();
                System.out.println("inserer l'etat du capteur");
                cpt.etat = sc.nextLine(); 
                System.out.println("inserer l'unite de mesure");
                cpt.uniteMesure = sc.nextLine();
                System.out.println("inserer les donnees capturees");
                cpt.donneeCapturee= sc.nextLine(); 
                System.out.println("inserer le type du capteur");
                cpt.typeCapteur = sc.nextLine();           
                try {
                     
                    String sql = "INSERT INTO ObjetConnecte (objet_id, nom,etat,objet_type) VALUES (?, ?, ?, ?)";
                    String sql2  = "INSERT INTO Capteur (objet_id, capteur_id, unite_mesure, donnee_captee,type_capteur) VALUES (?, ?, ?, ?,?)";
                    try (PreparedStatement statement = CheckDb.con.prepareStatement(sql)) {
                        statement.setInt(1, cpt.id);
                        statement.setString(2, cpt.nom);
                        statement.setString(3, cpt.typeObjet);
                        statement.setString(4, cpt.etat);
        
                        // Exécution de la requête
                        int rowsAffected = statement.executeUpdate();
                        System.out.println(rowsAffected + " ligne(s) insérée(s) avec succès.");

                    }
                    try (PreparedStatement statement2 = CheckDb.con.prepareStatement(sql2)) {
                        statement2.setInt(1, cpt.id);
                        statement2.setInt(2, cpt.idCapteur);
                        statement2.setString(3, cpt.uniteMesure);
                        statement2.setString(4, cpt.donneeCapturee);
                        statement2.setString(5, cpt.typeCapteur);
                         // Exécution de la requête
                        int rowsAffected2 = statement2.executeUpdate();
                        System.out.println(rowsAffected2 + " ligne(s) insérée(s) avec succès.");
                    }
                } catch (SQLException e) {
                    System.err.println("Erreur, : " + e.getMessage());
                }
            }else{                
                Actuateur act = new Actuateur();
                act.typeObjet="actuateur";
                System.out.println("inserer l'id d'objet'");
                act.id= sc.nextInt();
                sc.nextLine();
                System.out.println("inserer le nom du l'actuateur ");                      
                act.nom = sc.nextLine();
                System.out.println("inserer l'id du l'actuateur ");
                act.idActuateur  = sc.nextInt();
                sc.nextLine();
                System.out.println("inserer l'etat du l'actuateur ");
                act.etat = sc.nextLine(); 
                System.out.println("inserer le type du l'actuateur ");
                act.typeActuateur  = sc.nextLine();           
                try {
                    //source :https://www.geeksforgeeks.org/simplifying-crud-operation-with-jdbc/
                    
                     
                    String sql = "INSERT INTO ObjetConnecte (objet_id, nom,etat,objet_type) VALUES (?, ?, ?, ?)";
                    String sql2  = "INSERT INTO Actuateur (actuateur_id,objet_id,action ,type_actuateur) VALUES (?, ?, ?,?)";
                    try (PreparedStatement statement = CheckDb.con.prepareStatement(sql)) {
                        statement.setInt(1, act.id);
                        statement.setString(2, act.nom);
                        statement.setString(3, act.typeObjet);
                        statement.setString(4, act.etat);
                        statement.executeUpdate();

                    }
                    try (PreparedStatement statement2 = CheckDb.con.prepareStatement(sql2)) {
                        statement2.setInt(1, act.idActuateur);
                        statement2.setInt(2, act.id);
                        statement2.setString(3, act.action);
                        statement2.setString(4, act.typeActuateur);
                        statement2.executeUpdate();
                    }
                } catch (SQLException e) {
                    System.err.println("Erreur : " + e.getMessage());
                }
            }

            }
        public static void showObjet() throws Exception{

            //source : https://www.geeksforgeeks.org/java-program-to-retrieve-contents-of-a-table-using-jdbc-connection/
            try {
                String sql = "select * from ObjetConnecte";
                ResultSet rs = CheckDb.con.prepareStatement(sql).executeQuery();
                System.out.println("objet_id\tnom\t\tetat\t\tobjet_type");
     
                while (rs.next()) {
     
                    int objet_id = rs.getInt("objet_id");
                    String nom = rs.getString("nom");
                    String etat = rs.getString("etat");
                    String objet_type = rs.getString("objet_type");
                    System.out.println(objet_id + "\t\t" + nom+ "\t\t" + etat+ "\t\t" +objet_type);
                }
            }
     
            catch (SQLException e) {
     
                System.out.println(e);
            }
        }
        public static void modifieobjet() throws Exception{
            //source : https://www.geeksforgeeks.org/how-to-update-contents-of-a-table-using-jdbc-connection/
            Scanner sc = new Scanner(System.in);
            System.out.println("entrer la table : ");
            String nomtable = sc.nextLine();
            while(!nomtable.equals("Capteur") && !nomtable.equals("Actuateur") && !nomtable.equals("ObjetConnecte")){
                System.out.println("ressayer, ce n'est pas valide : ");
                nomtable = sc.nextLine();
                if(nomtable.equals("Capteur") || nomtable.equals("Actuateur") || nomtable.equals("ObjetConnecte")){
                    break;
                }
            }
            System.out.println("entrer l'id de l'objet a modifier : ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("entrer le champ a modifier : ");
            String champ = sc.nextLine();
            System.out.println("saisie la nouvelle entree : ");
            String entry = sc.nextLine(); 
            System.out.println("voulez vous encore modifier?1-oui| 2-non : ");
            int choice = sc.nextInt();
            sc.nextLine();
            while(choice!=1 && choice!=2){
                System.out.println("ressayer, ce n'est pas valide : ");
                choice = sc.nextInt();
                sc.nextLine();  
                if(choice==1 || choice==2){
                    break;
                }
            }
           
            try { 
                String sql = "update " + nomtable + " set " + champ + "=" + "'" + entry + "'" + " where objet_id= " + id; 
                CheckDb.con.prepareStatement(sql).execute(); 
            } 
            catch (SQLException e) { 
                System.out.println(e); 
            }
        }
        public static void supprimerobjet() throws Exception{
            // source : https://www.commandprompt.com/education/postgresql-delete-cascade-with-examples/
            Scanner sc = new Scanner(System.in);
            System.out.println("entrer la table : ");
            String nomtable = sc.nextLine();
            while(!nomtable.equals("Capteur") && !nomtable.equals("Actuateur") && !nomtable.equals("ObjetConnecte")){
                System.out.println("ressayer, ce n'est pas valide : ");
                nomtable = sc.nextLine();
                if(nomtable.equals("Capteur") || nomtable.equals("Actuateur") || nomtable.equals("ObjetConnecte")){
                    break;
                }
            }
            System.out.println("entrer l'id de l'objet a supprimer : ");
            int id = sc.nextInt();
            sc.nextLine();
            try { 
                String sql ="DELETE FROM " + nomtable + " WHERE objet_id ="+id;
                CheckDb.con.prepareStatement(sql).execute(); 
            } 
            catch (SQLException e) { 
                System.out.println(e); 
            }
        }
        @Override
        public void close() throws Exception {
            throw new UnsupportedOperationException("fermeture des ressources");
        }}