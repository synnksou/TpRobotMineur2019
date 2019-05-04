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

public class Mine extends ElementTerrain{
    private int stock;

    public Mine(boolean e,int x,int y,int s) {
        super(e, x, y);
        this.stock = s;
    }

    @Override
    public String toString() {
        return "M";
    }

    @Override
    public void setCoordonnee(Coordonnee coordonnee) {
        super.setCoordonnee(coordonnee);
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
}

    @Override
    public Coordonnee getCoordonnee() {
        return super.getCoordonnee();
    }

    @Override
    public boolean isConnu() {
        return super.isConnu();
    }

    public boolean stockIsNull(){
        return this.stock == 0;
    }
}
