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

public class MinePlu extends Mine{

    public MinePlu(boolean c,int s, int x, int y) {
        super(c, s, x, y);
    }

    @Override
    public String toString() {
        return super.toString() + "Plu";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Mine){
            if (obj instanceof MinePlu){
                return this.getStock() == ((MinePlu) obj).getStock() && this.getCoordonnee().getX() == ((MinePlu) obj).getCoordonnee().getX() && this.getCoordonnee().getY() == ((MinePlu) obj).getCoordonnee().getY();
            }else{
                return false;
            }
        }else{
            return false;
        }

    }

    @Override
    public Coordonnee getCoordonnee() {
        return super.getCoordonnee();
    }
}
