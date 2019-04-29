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

import java.util.ArrayList;
import com.company.ColorByAntoine;
public class Base extends ElementTerrain{
   private int stock;
    public static final String ANSI_WHITE="\u001B[37m";
    public static final String ANSI_YELLOW="\u001B[33m";

    public Base(boolean c, int x, int y, int s){
       super(c,x,y);
       this.stock=s;
   }


    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return ANSI_YELLOW+"Base"+ANSI_WHITE;
    }

    @Override
    public String toString2(String message) {
        return message;
    }

    @Override
    public void setConnu(boolean connu) {
        super.setConnu(connu);
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}


