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



public class MineUra extends Mine{

    public MineUra(boolean c,int s, int x, int y)

    {
        super(c,s,x,y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mine) {
            if (obj instanceof MineUra) {
                return this.getStock() == ((MineUra) obj).getStock() && this.getCoordonnee().getX() == ((MineUra) obj).getCoordonnee().getX() && this.getCoordonnee().getY() == ((MineUra) obj).getCoordonnee().getY();
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    @Override
    public void setStock(int stock) {
        super.setStock(stock);
    }

    @Override
    public int getStock() {
        return super.getStock();
    }

    @Override
    public String toString2(String message) {
        return message;
    }

    @Override
    public String toString() {
        return super.toString() + "Ura";
    }
}