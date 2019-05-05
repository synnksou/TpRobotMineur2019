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

import java.io.Serializable;

public abstract class Element implements Serializable {
    private Coordonnee coordonnee;
    private boolean isConnu;

    public Element(int x, int y,boolean isConnu) {
        coordonnee = new Coordonnee(x, y);
        this.isConnu=isConnu;
    }

    public void setConnu(boolean connu) {
        isConnu = connu;
    }

    public boolean isConnu() {
        return isConnu;
    }
    public String toString2(String message){
        return message;
    }

    @Override
    public String toString() {
        return "";
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }




}
