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

public abstract class Robot extends Element implements InterfacePlay{
   private int idRobot;
    private int stock;

   public Robot(int id,int x,int y){
       super(x, y,true);
       this.idRobot=id;
       this.stock=0;
   }

    public int getStock() {
        return stock;
    }

    public int getIdRobot(){
        return idRobot;
    }

    @Override
    public String toString() {
        return "R";
    }



    public void left(){
        {
            Coordonnee coordonnee = this.getCoordonnee();
            int x = coordonnee.getX();
            int y = coordonnee.getY() + 1;
            coordonnee.setY(y);
            coordonnee.setX(x);
            this.setCoordonnee(coordonnee);
        }
    }

    public void right(){
        {
            Coordonnee coordonnee = this.getCoordonnee();
            int x = coordonnee.getX();
            int y = coordonnee.getY() - 1;
            coordonnee.setY(y);
            coordonnee.setX(x);
            this.setCoordonnee(coordonnee);
        }
    }

    public void up(){
        {
            Coordonnee coordonnee = this.getCoordonnee();
            int x = coordonnee.getX()-1;
            int y = coordonnee.getY();
            coordonnee.setY(y);
            coordonnee.setX(x);
            this.setCoordonnee(coordonnee);
        }
    }
    public void down(){
        {
            Coordonnee coordonnee = this.getCoordonnee();
            int x = coordonnee.getX() + 1;
            int y = coordonnee.getY();
            coordonnee.setY(y);
            coordonnee.setX(x);
            this.setCoordonnee(coordonnee);
        }
    }
    public abstract void miner(Mine mine);

    public void setStock(int stock) {
        this.stock = stock;
    }

    public abstract void decharger(Base base);


}


