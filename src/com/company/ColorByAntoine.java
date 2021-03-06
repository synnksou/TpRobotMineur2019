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

import java.awt.*;

public class ColorByAntoine{

    public final static String ANSI_RESET = "\u001B[0m";
    public final static String  ANSI_BLACK = "\u001B[30m";
    public final static String ANSI_RED = "\u001B[31m";
    public final static String ANSI_GREEN = "\u001B[32m";
    public final static String ANSI_YELLOW = "\u001B[33m";
    public final static String ANSI_BLUE = "\u001B[34m";
    public final static String ANSI_PURPLE = "\u001B[35m";
    public final static String ANSI_CYAN = "\u001B[36m";
    public final static String ANSI_WHITE = "\u001B[37m";



    public String getColorPurple(){
        return ANSI_PURPLE;
    }
    public String getColorBlack(){
        return ANSI_BLACK;
    }

    public String getColorRed(){
        return ANSI_RED;
    }
    public String getColorGreen(){
        return ANSI_GREEN;
    }

    public String getColorYellow(){
        return ANSI_YELLOW;
    }
    public String getColorBlue(){
        return ANSI_BLUE;
    }

    public String getColorWhite(){
        return ANSI_WHITE;
    }

    public String getColorCyan() {
        return ANSI_CYAN;
    }
}
