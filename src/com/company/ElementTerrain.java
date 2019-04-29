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

public class ElementTerrain  extends Element{



    public ElementTerrain(boolean s,int x,int y){
        super(x, y,s);
}

    @Override
    public Coordonnee getCoordonnee() {
        return super.getCoordonnee();
    }

    @Override
    public void setCoordonnee(Coordonnee coordonnee) {
        super.setCoordonnee(coordonnee);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}