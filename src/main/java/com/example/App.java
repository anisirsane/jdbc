//this code was taken from a tutorial on : geeksforgeeks website with some minor moddifications
package com.example;
public class App {

	public static void main(String[] args) throws Exception{

        CheckDb check = new CheckDb();
        check.check();
        switch (UserInput.choixMenu()) {
                case 1:
                UserInput.insertObjet();
                        break;
                case 2:
                UserInput.modifieobjet();
                        break;
                case 3:
                UserInput.showObjet();

                        break;
                case 4:
                UserInput.supprimerobjet();
                        break;

                default:
                        break;
        }
        }
}