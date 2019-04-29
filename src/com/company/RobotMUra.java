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

import static com.company.Main.ANSI_RED;
import static com.company.Main.ANSI_WHITE;

public class RobotMUra extends Robot{

    public RobotMUra(int id,int x,int y){
        super(id,x,y);
    }

    @Override
    public int getIdRobot() {
        return super.getIdRobot();
    }

    @Override
    public int getStock() {
        return super.getStock();
    }

    public String toString() {
        return super.toString() + "Ura";
    }

    public String toString2(String message) {
        return message;
    }
    @Override

    public void setConnu(boolean connu) {
        super.setConnu(connu);
    }

    public void decharger(Base base) {
        int temporyStock = this.getStock();
        temporyStock += base.getStock();
        base.setStock(temporyStock);
        temporyStock = 0;
        this.setStock(temporyStock);
    }
    @Override
    public void miner(Mine mine) {
        int temporyStock = mine.getStock();
        if (!mine.stockIsNull()) {
            mine.setStock(--temporyStock);
            this.setStock(1 + this.getStock());
        }else
        {
            System.out.println(ANSI_RED+"Le stocks est egale a zero il n'est plus possible de miner :)"+ANSI_WHITE);
        }
    }
}