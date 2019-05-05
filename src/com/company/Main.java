/**
 * TP   ROBOT   MINEUR  2019
 * @author Heinrich Antoine
 * @groupe A2
 * @version V0.2
 * @commentaire : Pour l'inspection de la methode move du Diagrame de Sequence
 *                Methode Down(),up(),left(),right() dans la Classe Robot
 *                Methode DeplacementRobotUra() ou DeplacementRobotPlu() dans la classe PlateauDeJeu
 *                Methode OnPlateau() dans la classe PlateauDeJeu
 */

package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws Exception{
        boolean errorDejaOccuperExecption = false;
        boolean errorInputMismatchExecption = false;
        boolean errorMatriceExecption=false;
        boolean errorIllegaltArgument =false;
        PlateauDeJeu plateau=null;
        Main.affichageRegle();
        System.out.println("Voulez vous saisir une sauvegarde ? oui ou non " + ANSI_RED +"Attention il faut avoir une sauvegarde pour ça" + ANSI_WHITE);
        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
        String string3 = scanner.nextLine();

        switch (string3) {
            case "oui":
                plateau=demandeDeChargement(plateau);
                System.out.println(ANSI_GREEN+"CHARGEMENT EFFECTUER !" + ANSI_WHITE);
                break;
            case "non":
                boolean connu = choixDecouvert();
               plateau=PlateauDeJeu.creationMonde();
                plateau.iniMonde(connu);
                break;
        }

                do {
                    do {
                        try {
                            plateau.affichage(0);
                            boolean fin = false;
                            while (!fin) {
                                int d = Main.choixRobot();
                                boolean finRobot1 = false;
                                switch (d) {
                                    case 1:
                                        plateau.affichage(1);
                                        while (!finRobot1) {
                                            System.out.println();
                                            String string = Main.affichageChoixDeDeplacement();
                                            switch (string) {
                                                case "u":
                                                    plateau.depalcementRobotMura("u");
                                                    plateau.affichage(1);
                                                    break;
                                                case "d":
                                                    plateau.depalcementRobotMura("d");
                                                    plateau.affichage(1);
                                                    break;
                                                case "g":
                                                    plateau.depalcementRobotMura("g");
                                                    plateau.affichage(1);
                                                    break;
                                                case "b":
                                                    plateau.depalcementRobotMura("b");
                                                    plateau.affichage(1);
                                                    break;
                                                case "stop":
                                                    plateau.affichage(0);
                                                    finRobot1 = true;
                                                    break;
                                            }
                                        }
                                        break;
                                    case 2:
                                        plateau.affichage(2);
                                        while (!finRobot1) {
                                            System.out.println();
                                            String string = Main.affichageChoixDeDeplacement();
                                            switch (string) {
                                                case "u":
                                                    plateau.depalcementRobotPlu("u");
                                                    plateau.affichage(2);
                                                    break;
                                                case "d":
                                                    plateau.depalcementRobotPlu("d");
                                                    plateau.affichage(2);
                                                    break;
                                                case "g":
                                                    plateau.depalcementRobotPlu("g");
                                                    plateau.affichage(2);
                                                    break;
                                                case "b":
                                                    plateau.depalcementRobotPlu("b");
                                                    plateau.affichage(2);
                                                    break;
                                                case "stop":
                                                    plateau.affichage(0);
                                                    finRobot1 = true;
                                                    break;
                                            }
                                        }
                                        break;
                                    case 3:
                                        fin = true;
                                        plateau.save("firstesave",plateau);
                                        return;
                                }
                            }
                        } catch (DejaOccuperExecption dejaOccuperExecption) {
                            System.out.println(ANSI_RED + "Relancement du MONDE" + ANSI_WHITE);
                            errorDejaOccuperExecption = true;
                        } catch (IndexOutOfBoundsException n) {
                            System.out.println("Vous avez essayer de passer  " + ANSI_CYAN + "HORS DE LA MATRICE" + ANSI_WHITE);
                            errorMatriceExecption = true;
                        } catch (InputMismatchException n) {
                            errorInputMismatchExecption = true;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } while (errorMatriceExecption);
                } while (errorInputMismatchExecption);
    }

    public static void affichageRegle(){
        System.out.println("****************************************************");
        System.out.println(ANSI_GREEN + "Bonjour bienvenue sur Mon Robot Mineur" + ANSI_WHITE);
        System.out.println("Pour" + ANSI_GREEN + " Miner ou Deposer dans la base" + ANSI_WHITE + " Il vous faudra juste " + ANSI_RED + "etre cote a cote du depot ou Miner et aller vers sa direction :)" + ANSI_GREEN + " Bon jeu" + ANSI_WHITE);
        System.out.println("****************************************************");
        System.out.println("Il peut avoir des " + ANSI_RED + "EXEPCTION" + ANSI_WHITE + " qui peuve ce lancer");
        System.out.println("Il suffira de relancer l'application");
        System.out.println("****************************************************");
    }

    public static String affichageChoixDeDeplacement(){
        System.out.println("Saisir 'u' pour aller en haut, " +
                "'b' pour aller en bas, " +
                "'d' pour aller a droite ," +
                " 'g' pour aller a gauche , " +
                "pour fin saisir 'stop' ");

        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);

        Scanner scanner2 = new Scanner(System.in);
        String str = scanner2.nextLine();

        return str;

    }

    public static int choixRobot(){

        System.out.println("Saisir un numero pour savoir qu'elle est le  robot voulez utiliser ou saisir 3 pour fin");
        System.out.println("1 Robot Mineur Uranium | 2 Robot Mineur Plutonium | 3 pour fin");
        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        return x;

    }

    public static boolean choixDecouvert(){
        demandeDecouvert();
        boolean res = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
        int sc = scanner.nextInt();
        while (sc<=0 || sc>2){
            System.out.println(ANSI_RED+"Re saisir"+ANSI_WHITE);
            System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
            sc = scanner.nextInt();
        }
        if (sc==1){
            res=true;
        }else
        {
            res=false;
        }
        return res;
    }

    public static void demandeDecouvert(){
        System.out.println("****************************************************");
        System.out.println("Si vous voulez"+ANSI_GREEN+" le monde découvert "+ANSI_WHITE+"pour faciliter le test du programme");
        System.out.println("Taper "+ANSI_CYAN+"1"+ANSI_WHITE+" si pour non-découvert taper "+ANSI_RED+"2"+ANSI_WHITE);
        System.out.println("****************************************************");
    }

    public static PlateauDeJeu demandeDeChargement(PlateauDeJeu plateau) throws Exception{
        boolean errorMistmath=false;
        boolean res=false;
        System.out.println("Voulez vous saisir une Sauvegarde ? oui ou non");
        do {
            try {
                        System.out.println("Saisir le nom du fichier sans . ");
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
                        String string2 = scanner2.nextLine();
                        plateau=PlateauDeJeu.load(string2);

            } catch (InputMismatchException n) {
                errorMistmath = true;
            }
        }while (errorMistmath);
        return plateau;
    }
}


