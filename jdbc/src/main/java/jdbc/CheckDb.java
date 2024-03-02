package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


          // pour la verification de l'existance de la base de donnee j'ai utilise ce lien :
            // https://stackoverflow.com/questions/12414596/how-to-check-if-a-particular-database-in-mysql-already-exists-using-java
public class CheckDb {
    public static Connection con, con2;
    Statement stmt, stmt2;
    String dbName="appareil";
    boolean databaseexiste = false;
    String host="jdbc:postgresql://localhost:5432/postgres";
    String hostDB =  "jdbc:postgresql://localhost:5432/appareil";
    String username = "postgres";//+ dbName
    String password = "admin";

    public void check(){
        try {

            con = DriverManager.getConnection( host, username, password );

            stmt = CheckDb.con.createStatement();
            ResultSet resultSet = con.getMetaData().getCatalogs();

            //ce code est pris de: https://www.enterprisedb.com/postgres-tutorials/how-use-java-create-table-postgresql#:~:text=If%20you%20want%20to%20create%20an%20object%20or,PostgreSQL%20JDBC%20driver%20and%20classpath%20files%2C%20for%20example%3A 
            // et est modifie selon les besoins 

            while (resultSet.next()) {
                String databaseName = resultSet.getString(1);
                if(databaseName.equals(dbName)) {
                    databaseexiste=true;
                }
                }

            resultSet.close();
            if(databaseexiste == false){
                stmt.executeUpdate("CREATE DATABASE APPAREIL");
                databaseexiste=true;
            }
            //source de cette logique : https://stackoverflow.com/questions/2225221/closing-database-connections-in-java
        }catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        if(databaseexiste==true){
            try{
                con = DriverManager.getConnection( hostDB, username, password );
                stmt = CheckDb.con.createStatement();
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Obj (objet_id SERIAL PRIMARY KEY,objetcon_id SERIAL, nom VARCHAR(100),etat VARCHAR(20),objet_type VARCHAR(50),FOREIGN KEY (objetcon_id) REFERENCES Objetconnecte(objetconnecte_id) ON DELETE CASCADE);");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Capteur (capteur_id SERIAL PRIMARY KEY,objet_id SERIAL,unite_mesure VARCHAR(20),donnee_captee VARCHAR(1000),type_capteur VARCHAR(50),FOREIGN KEY (objet_id) REFERENCES Obj(objet_id) ON DELETE CASCADE);");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Actuateur (actuateur_id SERIAL PRIMARY KEY,objet_id SERIAL, action VARCHAR(255),type_actuateur VARCHAR(50),FOREIGN KEY (objet_id) REFERENCES Obj(objet_id) ON DELETE CASCADE);");
                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Objetconnecte (objetconnecte_id SERIAL PRIMARY KEY,nom VARCHAR(255),etat VARCHAR(50));");

            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        
  
}
}
