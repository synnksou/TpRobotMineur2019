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

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static com.company.Main.*;

public class PlateauDeJeu implements Serializable {
    private ArrayList<Element> elements;
    private ArrayList<Robot> robots;
    private int nbl;
    private int nbc;
    public Element[][] element;


    public PlateauDeJeu(int nbc, int nbl) {
        this.nbl = nbl;
        this.nbc = nbc;
        elements = new ArrayList<>();
        robots = new ArrayList<>();
        element = new Element[this.nbc][this.nbl];
    }


    public void iniMonde(boolean connu) throws DejaOccuperExecption{
       try {
           for (int i = 0; i < this.nbc; i++) {
               for (int j = 0; j < this.nbl; j++) {
                   this.element[i][j] =null;
               }
           }
           iniObstacle(connu);
           iniMinePlutonium(connu);
           iniMineUranium(connu);
           iniRobot();
           iniBase();
       }catch (DejaOccuperExecption  dejaOccuperExecption){
           robots.removeAll(robots);
           elements.removeAll(elements);
           iniMonde(connu);
       }
    }

    public void iniBase() throws DejaOccuperExecption {
        int x = choixRandom();
        Random r = new Random();
        Random r2 = new Random();
        int n = r.nextInt(x);
        int n2 = r2.nextInt(x);
        if (isOccuper(n, n2)) {

            Base base = new Base(true, n, n2, 0);
            element[n][n2] = base;
            elements.add(base);

        } else {
            throw new DejaOccuperExecption("Occuper");
        }
    }


    public void iniRobot() throws DejaOccuperExecption {
        int x = choixRandom();
        Random r = new Random();
        Random r2 = new Random();
        int n = r.nextInt(x);
        int n2 = r2.nextInt(x);

        Random r3 = new Random();
        Random r4 = new Random();
        int n3 = r3.nextInt(x);
        int n4 = r4.nextInt(x);


        if (isOccuper(n, n2) && isOccuper(n3, n4) || (isOccuper(n, n2) || isOccuper(n3, n4))) {

            RobotMPlu robotMPlu = new RobotMPlu(1, n, n2);
            RobotMUra robotMUra = new RobotMUra(2, n3, n4);
            element[n][n2] = robotMPlu;
            element[n3][n4] = robotMUra;
            robots.add(robotMPlu);
            robots.add(robotMUra);
        } else {
            throw new DejaOccuperExecption("Occuper");
        }
    }

    public int choixRandom(){
        if (this.nbl<this.nbc){
            return nbl;
        }else
        {
            return nbc;
        }
    }

    public void iniMinePlutonium(boolean connu) throws DejaOccuperExecption {

        int x = choixRandom();
        Random r = new Random();
        Random r2 = new Random();
        int n = r.nextInt(x);
        int n2 = r2.nextInt(x);

        Random r3 = new Random();
        Random r4 = new Random();
        int n3 = r3.nextInt(x);
        int n4 = r4.nextInt(x);

        Random r5 = new Random();
        Random r6 = new Random();
        int n5 = r5.nextInt(x);
        int n6 = r6.nextInt(x);


        if ((isOccuper(n, n2) && isOccuper(n3, n4) && (isOccuper(n5, n6))) ||
                isOccuper(n, n2) || isOccuper(n3, n4) && (isOccuper(n5, n6)) ||
                isOccuper(n, n2) || isOccuper(n3, n4) || (isOccuper(n5, n6))) {

            MinePlu minePlu = new MinePlu(connu,3, n, n2);
            MinePlu minePlu1 = new MinePlu(connu,3, n3, n4);
            MinePlu minePlu2 = new MinePlu(connu,3, n5, n6);
            element[n][n2] = minePlu;
            element[n3][n4] = minePlu1;
            element[n5][n6] = minePlu2;
            elements.add(minePlu);
            elements.add(minePlu1);
            elements.add(minePlu2);

        } else {
            throw new DejaOccuperExecption("Occuper");
        }

    }

    public void iniMineUranium(boolean connu) throws DejaOccuperExecption {
        int x = choixRandom();
        Random r = new Random();
        Random r2 = new Random();
        int n = r.nextInt(x);
        int n2 = r2.nextInt(x);

        Random r3 = new Random();
        Random r4 = new Random();
        int n3 = r3.nextInt(x);
        int n4 = r4.nextInt(x);

        Random r5 = new Random();
        Random r6 = new Random();
        int n5 = r5.nextInt(x);
        int n6 = r6.nextInt(x);


        if ((isOccuper(n, n2) && isOccuper(n3, n4) && (isOccuper(n5, n6))) ||
        isOccuper(n, n2) || isOccuper(n3, n4) && (isOccuper(n5, n6)) ||
                isOccuper(n, n2) && isOccuper(n3, n4) || (isOccuper(n5, n6))) {

            MineUra mineUra = new MineUra(connu,3, n, n2);
            MineUra mineUra1 = new MineUra(connu,3, n3, n4);
            MineUra mineUra2 = new MineUra(connu,3, n, n2);
            element[n][n2] = mineUra;
            element[n3][n4] = mineUra1;
            element[n5][n6] = mineUra2;
            elements.add(mineUra);
            elements.add(mineUra1);
            elements.add(mineUra2);

        } else {
            throw new DejaOccuperExecption("Occuper");
        }

    }

    public void iniObstacle(boolean connu) throws DejaOccuperExecption {
        int x = choixRandom();
        Random r = new Random();
        Random r2 = new Random();
        int n = r.nextInt(x);
        int n2 = r2.nextInt(x);

        Random r3 = new Random();
        Random r4 = new Random();
        int n3 = r3.nextInt(x);
        int n4 = r4.nextInt(x);

        Random r5 = new Random();
        Random r6 = new Random();
        int n5 = r5.nextInt(x);
        int n6 = r6.nextInt(x);

        Random r7 = new Random();
        Random r8 = new Random();
        int n7 = r7.nextInt(x);
        int n8 = r8.nextInt(x);

        Random r9 = new Random();
        Random r10 = new Random();
        int n9 = r9.nextInt(x);
        int n10 = r10.nextInt(x);

        Random r11 = new Random();
        Random r12 = new Random();
        int n11 = r11.nextInt(x);
        int n12 = r12.nextInt(x);

            Obstacle obstacle = new Obstacle(connu, n, n2);
            Obstacle obstacle1 = new Obstacle(connu, n3, n4);
            Obstacle obstacle2 = new Obstacle(connu, n5, n6);
            Obstacle obstacle3 = new Obstacle(connu, n7, n8);
            Obstacle obstacle4 = new Obstacle(connu, n9, n10);
            Obstacle obstacle5 = new Obstacle(connu, n11, n12);
            element[n][n2] = obstacle;
            element[n3][n4] = obstacle1;
            element[n5][n6] = obstacle2;
            element[n7][n8] = obstacle3;
            element[n9][n10] = obstacle4;
            element[n11][n12] = obstacle5;

    }


    public void affichage(int x) {
        ColorByAntoine colorByAntoine= new ColorByAntoine();
        ColorByAntoine colorByAntoine1 = new ColorByAntoine();
        ColorByAntoine colorByAntoine2 = new ColorByAntoine();
        System.out.print("");
        for (int i = 0; i <nbc; i++) {
            System.out.println(" :  ");
            for (int j = 0; j < nbl; j++) {
                if (element[i][j] == null) {
                    System.out.print(" :  ");
                } else {
                    if (element[i][j].isConnu()) {
                        if (element[i][j] instanceof RobotMUra && x==1){
                            System.out.print(element[i][j].toString2(colorByAntoine.getColorRed()+ element[i][j].toString()+colorByAntoine1.getColorWhite()));
                        } else if (element[i][j] instanceof MineUra && x==1){
                           System.out.print(element[i][j].toString2(colorByAntoine2.getColorGreen()+element[i][j].toString()+colorByAntoine1.getColorWhite()));
                        }else if (element[i][j] instanceof RobotMPlu && x==2){
                            System.out.print(element[i][j].toString2(colorByAntoine2.getColorCyan()+element[i][j].toString()+colorByAntoine1.getColorWhite()));
                        }else if (element[i][j] instanceof MinePlu && x==2) {
                            System.out.print(element[i][j].toString2(colorByAntoine2.getColorPurple()+ element[i][j].toString() + colorByAntoine1.getColorWhite()));
                        }else {
                            System.out.print(element[i][j].toString());
                        }
                    } else {
                        System.out.print(" :  ");
                    }
                }
            }
        }

        Base base = (Base) elements.get(6);
        RobotMUra robotMUra = (RobotMUra) robots.get(1);
        RobotMPlu robotMPlu = (RobotMPlu) robots.get(0);
        System.out.println(" :  ");
        System.out.println("****************************************************");
        System.out.println(colorByAntoine.ANSI_GREEN+"Inventaire"+colorByAntoine1.getColorWhite());
        System.out.println("Minerai en stock a la base  : " + colorByAntoine.ANSI_RED + base.getStock()                         +colorByAntoine1.getColorWhite() );
        System.out.println("Minerai dans le robot Uranium : "+ colorByAntoine.ANSI_RED + robotMUra.getStock()                    +colorByAntoine1.getColorWhite() );
        System.out.println("Minerai dans le robot Plutonium : "+ colorByAntoine.ANSI_RED + robotMPlu.getStock()                    +colorByAntoine1.getColorWhite() );
        System.out.println("****************************************************");
    }

    public boolean isOccuper(int nbc, int nbl) {
        return element[nbc][nbl] == null;
    }

    public Element rechercheElement(Element element){
        Element temporyElement = null;
        for (int i = 0 ; i<elements.size(); i++){
            if (elements.get(i).equals(element)){
                temporyElement=element;
            }
        }
        return temporyElement;
    }


    public boolean estMinePlu(Coordonnee coordonnee) {
        return element[coordonnee.getX()][coordonnee.getY()] instanceof MinePlu;
    }

    public boolean estMineUra(Coordonnee coordonnee) {
        return element[coordonnee.getX()][coordonnee.getY()] instanceof MineUra;
    }

    public boolean estBase(Coordonnee coordonnee) {
        return element[coordonnee.getX()][coordonnee.getY()] instanceof Base;
    }

    public boolean estObstacle(Coordonnee coordonnee) {
        return element[coordonnee.getX()][coordonnee.getY()] instanceof Obstacle;
    }

    public String getNature(Coordonnee coordonnee) {
        if (estBase(coordonnee)) {
            return "base";
        }
        if (estMinePlu(coordonnee)) {
            return "minePlu";
        }
        if (estObstacle(coordonnee)) {
            return "obstacle";
        }
        if (estMineUra(coordonnee)) {
            return "mineUra";
        }
        return "error";
    }

    public boolean choisi(int x){
        return x == 1;
    }

    ///*************************************************************************************************************************************************************
    //**************************************************** Code DEPLACEMENT ROBOT MURA ******************************************************************************
    public void depalcementRobotMura(String d) throws DejaOccuperExecption,IndexOutOfBoundsException{
        Robot robotMUra = robots.get(1);
        Coordonnee coordonnee = robotMUra.getCoordonnee();
        Coordonnee nextCoordonne = new Coordonnee(coordonnee.getX(), coordonnee.getY());
        choisi(1);
        choixDeDeplacement(d, robotMUra, coordonnee, nextCoordonne);
    }


    public void depalcementRobotPlu(String d) throws DejaOccuperExecption,IndexOutOfBoundsException{
        Robot robotPlu = robots.get(0);
        Coordonnee coordonnee = robotPlu.getCoordonnee();
        Coordonnee nextCoordonne = new Coordonnee(coordonnee.getX(), coordonnee.getY());
        choixDeDeplacement(d, robotPlu, coordonnee, nextCoordonne);
    }

    public void choixDeDeplacement(String d, Robot robotPlu, Coordonnee coordonnee, Coordonnee nextCoordonne) throws DejaOccuperExecption {
        Vide vide;
        Element temporyElement;
        if (d.equals("d")) {
            int y = nextCoordonne.getY() + 1;
            nextCoordonne.setY(y);
            if (nextCoordonne.getY() < nbc || nextCoordonne.getY() < nbl){
                if (isOccuper(coordonnee.getX(), coordonnee.getY() + 1)) {
                    temporyElement = robotPlu;
                    robotPlu.left();
                    element[coordonnee.getX()][coordonnee.getY()-1] = null;
                    element[nextCoordonne.getX()][nextCoordonne.getY()] = temporyElement;
                } else {
                    detectOnPlateau(robotPlu, nextCoordonne);
                }
            }else{
                System.out.println("Vous avvez essayer de passer au de la matrice !! ");
                throw new IndexOutOfBoundsException();
            }

        }else if(d.equals("g")){
            int y = nextCoordonne.getY() - 1;
            nextCoordonne.setY(y);
            if (nextCoordonne.getY()>=0){
                if (isOccuper(coordonnee.getX(), coordonnee.getY() - 1)) {
                    temporyElement = robotPlu;
                    robotPlu.right();
                    element[coordonnee.getX()][coordonnee.getY()+1] = null;
                    element[nextCoordonne.getX()][nextCoordonne.getY()] = temporyElement;
                } else {
                    detectOnPlateau(robotPlu, nextCoordonne);
                }
            }else{
                System.out.println("Vous avvez essayer de passer au de la matrice !! ");
                throw new IndexOutOfBoundsException();
            }
        }else if(d.equals("u")) {

            int x = nextCoordonne.getX()-1;
            nextCoordonne.setX(x);
            if (nextCoordonne.getX() >= 0 || nextCoordonne.getX() < nbl) {
                if (isOccuper(coordonnee.getX()-1, coordonnee.getY())) {
                    temporyElement = robotPlu;
                    robotPlu.up();
                    element[coordonnee.getX()+1][coordonnee.getY()] = null;
                    element[nextCoordonne.getX()][nextCoordonne.getY()] = temporyElement;
                } else {
                    detectOnPlateau(robotPlu, nextCoordonne);
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        }else{
            int x = nextCoordonne.getX()+1;
            nextCoordonne.setX(x);
            if (nextCoordonne.getX() >= 0 || nextCoordonne.getX() < nbl) {
                if (isOccuper(coordonnee.getX()+1, coordonnee.getY())) {
                    temporyElement = robotPlu;
                    robotPlu.down();
                    element[coordonnee.getX()-1][coordonnee.getY()] = null;
                    element[nextCoordonne.getX()][nextCoordonne.getY()] = temporyElement;
                } else {
                    detectOnPlateau(robotPlu, nextCoordonne);
                }
            } else {
                System.out.println("Vous avvez essayer de passer au de la matrice !! ");
                throw new IndexOutOfBoundsException();
            }

        }
    }


    public void detectOnPlateau(Robot robotMUra, Coordonnee nextCoordonne) {
        ColorByAntoine colorByAntoine=new ColorByAntoine();
        if (getNature(nextCoordonne) == "obstacle") {
            if (!element[nextCoordonne.getX()][nextCoordonne.getY()].isConnu()) {
                element[nextCoordonne.getX()][nextCoordonne.getY()].setConnu(true);
                System.out.println("Obstacle");
            } else {
                System.out.println("Obstacle");
            }
        } else if (getNature(nextCoordonne) == "base") {
            System.out.println("Vous etes sur la base ac");
                robotMUra.decharger((Base) elements.get(6));
                System.out.println(informationGameMura());
        } else if (getNature(nextCoordonne) == "minePlu") {
            if (!element[nextCoordonne.getX()][nextCoordonne.getY()].isConnu()) {
                element[nextCoordonne.getX()][nextCoordonne.getY()].setConnu(true);
                if (robotMUra instanceof RobotMPlu) {
                    System.out.println(colorByAntoine.ANSI_RED + "Vous etes sur la mine de Plutonium vous pouvez miner" + colorByAntoine.ANSI_WHITE);
                    MinageOnPlateau(robotMUra, nextCoordonne);
                } else {
                    System.out.println("Vous ne pouvez pas miner avec le" + colorByAntoine.ANSI_RED + " un robot d'uranium" +
                            "une mine de Plutonium" + colorByAntoine.ANSI_WHITE);
                }
            }else {
                    if (robotMUra instanceof RobotMPlu) {
                        System.out.println(colorByAntoine.ANSI_RED + "Vous etes sur la mine de Plutonium vous pouvez miner" + colorByAntoine.ANSI_WHITE);
                        MinageOnPlateau(robotMUra, nextCoordonne);
                    } else {
                        System.out.println("Vous ne pouvez pas miner avec le" + colorByAntoine.ANSI_RED + " un robot d'uranium" +
                                "une mine de Plutonium" + colorByAntoine.ANSI_WHITE);
                }
            }
        } else if (getNature(nextCoordonne) == "mineUra") {
            if (!element[nextCoordonne.getX()][nextCoordonne.getY()].isConnu()) {
                element[nextCoordonne.getX()][nextCoordonne.getY()].setConnu(true);
                if (robotMUra instanceof RobotMUra) {
                    System.out.println(colorByAntoine.ANSI_RED + "Vous etes sur la mine de Uranium vous pouvez miner" + colorByAntoine.ANSI_WHITE);
                    MinageOnPlateau(robotMUra, nextCoordonne);
                } else {
                    System.out.println("Vous ne pouvez pas miner avec le" + colorByAntoine.ANSI_RED + " un robot d'uranium" +
                            "une mine de Plutonium" + colorByAntoine.ANSI_WHITE);
                }
            }else {
                if (robotMUra instanceof RobotMUra) {
                    System.out.println(colorByAntoine.ANSI_RED + "Vous etes sur la mine de Uranium vous pouvez miner" + colorByAntoine.ANSI_WHITE);
                    MinageOnPlateau(robotMUra, nextCoordonne);
                } else {
                    System.out.println("Vous ne pouvez pas miner avec le" + colorByAntoine.ANSI_RED + " un robot d'uranium" +
                            "une mine de Plutonium" + colorByAntoine.ANSI_WHITE);
                }
                }
        }

    }

    public void MinageOnPlateau(Robot robotMUra, Coordonnee nextCoordonne) {
        Mine mineUraTempory;
        if (element[nextCoordonne.getX()][nextCoordonne.getY()] instanceof MineUra) {
            mineUraTempory = (MineUra) elements.get(quelleMine(nextCoordonne));
                robotMUra.miner(mineUraTempory);
        }else{
            mineUraTempory = (MinePlu) elements.get(quelleMine(nextCoordonne));
                robotMUra.miner(mineUraTempory);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
// Methode pour savoir la mine au coordonnée voulue
///////////////////////////////////////////////////////////////////////////
    public int quelleMine(Coordonnee coordonnee){
        if (element[coordonnee.getX()][coordonnee.getY()].equals(elements.get(0))){
            return 0;
        } else if (element[coordonnee.getX()][coordonnee.getY()].equals(elements.get(1))){
            return 1;
        }else if(element[coordonnee.getX()][coordonnee.getY()].equals(elements.get(2))){
            return 2;
        }
        else if (element[coordonnee.getX()][coordonnee.getY()].equals(elements.get(3))){
            return 3;
        }else if(element[coordonnee.getX()][coordonnee.getY()].equals(elements.get(4))){
            return 4;
        }else {
            return 5;
        }
    }

    public String informationGameMura(){
        Base temporyBase = (Base) elements.get(6);
        return "Vous avez actuellement " + robots.get(1).getStock() + " minerai dans le robot"
                +"Vous avez actuellemnt " + temporyBase.getStock() +" dans la base ";
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public static PlateauDeJeu creationMonde() throws InputMismatchException {

        System.out.println("Choix nombre de" + ANSI_RED + " colonne" + ANSI_WHITE);
        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
        Scanner scanner3 = new Scanner(System.in);
        if (!(scanner3.hasNextInt())) {
            throw new InputMismatchException();
        }
        Integer nbc = scanner3.nextInt();

        System.out.println("Choix nombre de" + ANSI_RED + " ligne" + ANSI_WHITE);
        System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
        Scanner scanner4 = new Scanner(System.in);
        int nbl = scanner4.nextInt();

        if (nbc <= 10 || nbc >= 15) {
            while (nbc <= 10 || nbc >= 15) {
                System.out.println(ANSI_RED + "Vous avez essayer de prendre un x>15 ou x<10 resaisir colonne" + ANSI_WHITE);
                System.out.println("Choix nombre de" + ANSI_RED + " colonne" + ANSI_WHITE);
                System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
                scanner3 = new Scanner(System.in);
                nbc = scanner3.nextInt();
            }
        }
        if (nbl <= 10 || nbl >= 15) {
            while (nbl <= 10 || nbl >= 15) {
                System.out.println(ANSI_RED + "Vous avez essayer de prendre un x>15 ou x<10 resaisir ligne" + ANSI_WHITE);
                System.out.println("Choix nombre de" + ANSI_RED + " ligne" + ANSI_WHITE);
                System.out.print(ANSI_CYAN + "> " + ANSI_WHITE);
                scanner4 = new Scanner(System.in);
                nbl = scanner4.nextInt();
            }
        }
        return new PlateauDeJeu(nbc, nbl);
    }

    ///////////////////////////////////////////////////////////////////////////
    // Function for save and load                                            //
    ///////////////////////////////////////////////////////////////////////////

    public static boolean save(String string, PlateauDeJeu plateauDeJeu) throws Exception{
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("/Users/heinrichano/Documents/cheat/DUT INFO/M2103 - Bases de la programmation orientée objet/TP/TpRobotMineur2019/save/"+string+".ser");
          final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(plateauDeJeu);
        objectOutputStream.close();
        return true;
        } catch (NotSerializableException n){
            n.printStackTrace();
            return false;
        } catch (IOException n){
            n.printStackTrace();
            return false;
        }
    }

    public static PlateauDeJeu load(String string) throws Exception {
        PlateauDeJeu plateauDeJeu = new PlateauDeJeu(0,0);
        try {
            FileInputStream fileInputStream = new FileInputStream("/Users/heinrichano/Documents/cheat/DUT INFO/M2103 - Bases de la programmation orientée objet/TP/TpRobotMineur2019/save/" + string + ".ser");
            final ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object object = objectInputStream.readObject();

                plateauDeJeu = (PlateauDeJeu) object;
                System.out.println(ANSI_GREEN + "CHARGEMENT EFFECTUER !" + ANSI_WHITE);

        } catch (FileNotFoundException n){
            n.printStackTrace();
            n.getMessage();
        } catch (IOException n){
            n.printStackTrace();
        }
        return plateauDeJeu;
    }

    public int getNbc() {
        return nbc;
    }

    public int getNbl() {
        return nbl;
    }

    public void setElement(Element[][] element) {
        this.element = element;
    }

    public void setElements(ArrayList<Element> elements) {
        this.elements = elements;
    }

    public void setNbc(int nbc) {
        this.nbc = nbc;
    }

    public void setNbl(int nbl) {
        this.nbl = nbl;
    }

    public void setRobots(ArrayList<Robot> robots) {
        this.robots = robots;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public ArrayList<Robot> getRobots() {
        return robots;
    }

    public Element[][] getElement() {
        return element;
    }

}