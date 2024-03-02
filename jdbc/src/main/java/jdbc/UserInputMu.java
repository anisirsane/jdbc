package jdbc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
        import java.util.*;
public class UserInputMu{
        public static int choixMenu(){
            Scanner choice = new Scanner(System.in);
            //affichage des options de menu
            System.out.println ("Menu:choisir un des fonctionalites du CRUD");
            System.out.println ("1. creer un nouveau microcontrolleur: ");
            System.out.println ("2. modifier un microcontrolleur: ");
            System.out.println ("3. affichet touts les microcontrolleurs: ");
            System.out.println ("4. supprimer un microcontrolleur: ");
            System.out.println ("Entrez votre choix:");
            //recuperation de choix et les retourner
            int choix = choice.nextInt();   
            return choix;
            } 
        public static void insertObjet() throws Exception {
            Scanner sc = new Scanner(System.in);
                ObjetConnecte objcn = new ObjetConnecte();

                System.out.println("inserer le nom du microcontrolleur");
                objcn.nom = sc.nextLine();
                boolean checkNom = objcn.nom.matches(".*[a-zA-Z]+.*");
                //source : https://stackoverflow.com/questions/14278170/how-to-check-whether-a-string-contains-at-least-one-alphabet-in-java
                while(!checkNom){
                    System.out.println("erreur, ca doit contenir au moins une lettre, ressayer: ");
                    objcn.nom = sc.nextLine();
                    checkNom = objcn.nom.matches(".*[a-zA-Z]+.*");
                    if(checkNom){
                        break;
                    }
                }

                System.out.println("inserer l'etat du microcontrolleur");
                objcn.etat = sc.nextLine();
                boolean checketat = objcn.etat.matches(".*[a-zA-Z]+.*"); 
                while(!checketat){
                    System.out.println("erreur, ca doit contenir au moins une lettre, ressayer: ");
                    objcn.etat = sc.nextLine();
                    checketat = objcn.etat.matches(".*[a-zA-Z]+.*");
                    if(checketat){
                        break;
                    }
                }        
                try {
                    // https://stackoverflow.com/questions/19167349/postgresql-insert-from-select-returning-id
                     
                    String sql = "INSERT INTO ObjetConnecte (nom,etat) VALUES (?, ?) RETURNING objetconnecte_id";
                    try (PreparedStatement statement = CheckDb.con.prepareStatement(sql)) {
                        // statement.setInt(1, objcn.id);
                        statement.setString(1, objcn.nom);
                        statement.setString(2, objcn.etat);
                 
                    //ce code est pris de ce forum : https://stackoverflow.com/questions/1915166/how-to-get-the-insert-id-in-jdbc
                        ResultSet generatedKeys = statement.executeQuery();
                }} catch(SQLException e) {
                    System.out.println(e);
                    }
                } 
        public static void showObjet() throws Exception{

            //source : https://www.geeksforgeeks.org/java-program-to-retrieve-contents-of-a-table-using-jdbc-connection/
            try {
                String sql = "select * from Objetconnecte";
                ResultSet rs = CheckDb.con.prepareStatement(sql).executeQuery();
                System.out.println("objetconnecte_id\tnom\t\tetat");
     
                while (rs.next()) {
     
                    int objet_id = rs.getInt("objetconnecte_id");
                    String nom = rs.getString("nom");
                    String etat = rs.getString("etat");
                    System.out.println(objet_id + "\t\t" + nom+ "\t\t" + etat);
                }
            }
            catch (SQLException e) {
     
                System.out.println(e);
            }
        }
        public static void modifieobjet() throws Exception{
            //source : https://www.geeksforgeeks.org/how-to-update-contents-of-a-table-using-jdbc-connection/
            Scanner sc = new Scanner(System.in);

            System.out.println("entrer le nom du microcopntrolleur a modifier : ");
            String nom = sc.nextLine();
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
                String sql = "update objetconnecte set " + champ + "=" + "'" + entry + "'" + " where nom= " + nom; 
                CheckDb.con.prepareStatement(sql).execute(); 
            } 
            catch (SQLException e) { 
                System.out.println(e); 
            }
        }
        public static void supprimerobjet() throws Exception{
            // source : https://www.commandprompt.com/education/postgresql-delete-cascade-with-examples/
            Scanner sc = new Scanner(System.in);

            System.out.println("entrer le nom du microcontrolleur a supprimer : ");
            String nom = sc.nextLine();
            sc.nextLine();
            try { 
                String sql ="DELETE FROM objetconnecte WHERE nom ="+nom;
                CheckDb.con.prepareStatement(sql).execute(); 
            } 
            catch (SQLException e) { 
                System.err.println("l'objet n'existe pas");
                System.out.println(e); 
            }
        }}

        // public static String generateData(int rangeMin, int rangeMax) throws Exception {
        //     // ce code est prise d'ici : https://stackoverflow.com/questions/3680637/generate-a-random-double-in-a-range
        //     Random rnd = new Random();
        //     // https://www.geeksforgeeks.org/stack-class-in-java/
        //     Stack<String> stackValeurs = new Stack<String>();
        //     Stack<String> stackTime = new Stack<String>();
        //     for(int i=0; i<5; i++){
        //         stackValeurs.push(TheHttpHandler.requestBody);
        //         stackTime.push();
        //         // https://stackoverflow.com/questions/24104313/how-do-i-make-a-delay-in-java
        //         Thread.sleep(500);              
        //     }
        //     // https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java

        // }}
