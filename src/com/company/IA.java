package com.company;

class IA <T extends Robot> {
    private PlateauDeJeu plateauDeJeu;
    private Element[] coordonneesMine;

    public IA(T r) {

    }

    // Rercherche des Mines
    public void rechercheMine() {
        for (int i = 0; i < plateauDeJeu.getNbc(); i++) {
            for (int j = 0; j < plateauDeJeu.getNbl(); j++) {
                if (plateauDeJeu.element[i][j] instanceof Mine) {
                    coordonneesMine[i] = plateauDeJeu.element[i][j];
                }
            }
        }
    }

    // On reprend l'algo mais pour le Robot d'uranium l'indice des mineUranieum dans CORDONNERMINE
    public int[] forMineUranium() {
        int[] tabDeI = new int[2];
        for (int i = 0; i < coordonneesMine.length; i++) {
            if (coordonneesMine[i] instanceof MineUra) {
                tabDeI[i] = i;
            }
        }
        return tabDeI;
    }

    public double distance(Coordonnee a, Coordonnee b) {
        return Math.sqrt(Math.pow((b.getX() - a.getX()), 2.0)) + Math.pow((b.getY() - a.getY()), 2);
    }

    public int[] distancev2(Coordonnee actualPoint, Coordonnee nextPoint) {
        // 1 HAUT 2 DROITE 3 BAS 4 GAUCHE
        int[] nextPointDIstance = new int[4];

        int d = actualPoint.getY() - nextPoint.getX();
        int d2 = actualPoint.getY() - nextPoint.getX();
        // pour savoir combient de mouvement a droite ou a gauche
        if (actualPoint.getX() < nextPoint.getX()) {
            // Le mouvement
            nextPointDIstance[0] = 2;
            //la somme total du mouvent a reproduire
            nextPointDIstance[1] = d;
        } else {
            nextPointDIstance[0] = 4;
            nextPointDIstance[1] = d;
        }
        if (actualPoint.getY() < nextPoint.getY()) {
            nextPointDIstance[2] = 3;
            nextPointDIstance[3] = d2;
        } else {
            nextPointDIstance[2] = 1;
            nextPointDIstance[3] = d2;
        }
        return nextPointDIstance;
    }


    public void IaMove(int[] nextPoint, Robot robot) throws DejaOccuperExecption {
        Coordonnee nextCoordonne = new Coordonnee(robot.getCoordonnee().getX(), robot.getCoordonnee().getY());
        Coordonnee coordonnee = new Coordonnee(robot.getCoordonnee().getX(), robot.getCoordonnee().getY());

        coordonnee = robot.getCoordonnee();
        nextCoordonne = robot.getCoordonnee();

        String string = new String("");

        int i = robot.getCoordonnee().getX();
        int j = robot.getCoordonnee().getY();

        if (nextPoint[0] == 2) {
            string = "d";
            //Mouvement de droite
            for (int x = 0; x < nextPoint[1]; x++) {
                //On repete le nombre de fois l'itération
                if (plateauDeJeu.element[i][j] == null) {
                    plateauDeJeu.choixDeDeplacement(string, robot, coordonnee, nextCoordonne);
                } else if (plateauDeJeu.element[i][j] instanceof Obstacle) {
                    // On le detourne
                }
            }
        } else {
            string = "g";
            //Mouvement de gauche
            for (int x = 0; x < nextPoint[1]; x++) {
                //On repete le nombre de fois l'itération
                if (plateauDeJeu.element[i][j] == null) {
                    plateauDeJeu.choixDeDeplacement(string, robot, coordonnee, nextCoordonne);
                } else if (plateauDeJeu.element[i][j] instanceof Obstacle) {
                    // On le detourne
                }
            }

            if (nextPoint[2] == 1) {
                string = "h";
                //Mouvement de haut
                for (int x = 0; x < nextPoint[3]; x++) {
                    if (plateauDeJeu.element[i][j] == null) {
                        plateauDeJeu.choixDeDeplacement(string, robot, coordonnee, nextCoordonne);
                    } else if (plateauDeJeu.element[i][j] instanceof Obstacle) {
                        // On le detourne
                    }
                }
            } else {
                string = "b";
                //Mouvement de bas
                for (int x = 0; x < nextPoint[3]; x++) {
                    //On repete le nombre de fois l'itération
                    if (plateauDeJeu.element[i][j] == null) {
                        plateauDeJeu.choixDeDeplacement(string, robot, coordonnee, nextCoordonne);
                    } else if (plateauDeJeu.element[i][j] instanceof Obstacle) {
                        // On le detourne
                    }
                }
            }
        }
    }

    // fonction de detournement

    public void detournement(Robot robot, Coordonnee nextCoordonnee) {

        int i = robot.getCoordonnee().getX();
        int j = robot.getCoordonnee().getY();


    }
}
