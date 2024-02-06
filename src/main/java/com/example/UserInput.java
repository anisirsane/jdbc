// package com.example;
// import java.util.Scanner;

// public class UserInput {
//         public static int choixMenu(){
//             Scanner choice = new Scanner(System.in);
//             //affichage des options de menu
//             System.out.println ("Menu:choisir unde des fonctionalites du CRUD");
//             System.out.println ("1. creer un nouveau appareil: ");
//             System.out.println ("2. modifier un appareil: ");
//             System.out.println ("3. affichet touts les appareils: ");
//             System.out.println ("4. supprimer un appareil: ");
//             System.out.println ("Entrez votre choix:");
//             //recuperation de choix et les retourner
//             int choix = choice.nextInt();   
//             return choix;
//             } 
//         public static String createtableStatement(){
//             return("CREATE TABLE Appareil (id SERIAL PRIMARY KEY, nom VARCHAR(50), type VARCHAR(50), etat VARCHAR(50));");
//         }
//         // static String dbname="appareil";
//         public static String ManageDb() throws Exception{
            

//             Scanner sc = new Scanner(System.in);
//             CheckDb check = new CheckDb();

//             boolean checked = check.check();
//             System.out.println(checked);
//             if (checked==false){
//                 return ("CREATE DATABASE appareil" );
//             }else{
//                     choixMenu();
//                     return "";








//                 }

//             // switch (choixMenu()) {
//             //     case 1:

//             //         break;
//             //     case 2:
//             //         System.out.println("on retourne au menu principale et choisissez si vous voulez modifier une table ou bien les donnees");
//             //         break;
//             //     case 3:
//             //         if(checked){

//             //             return("SELECT * FROM "+ dbname);
//             //         }else{
//             //             System.out.println("cette db nexiste pas");

//             //         }
//             //         break;
//             //     case 4:
//             //     System.out.println("etes vous sur que vous voulez supprimer cette BD? 1-oui/2-non : ");
//             //     int choixdel = sc.nextInt();
                
//             //     if(choixdel == 1){
//             //         return ("DROP DATABASE " + dbname);
//             //     }else{
//             //         if(choixdel == 2){

//             //             System.out.println("retourne au menu principale");

//             //         }else{

//             //             System.out.println("cette saisie n'est pas valide, retourne au menu principale");


//             //         }
//             //     }

//             //     default:
//             //         System.out.println("cette saisie n'est pas valide, ressayez : ");
//             //         choixMenu();
//             //         return "";
//             // }
//             // return "";
// }

// }
