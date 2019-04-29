package com.company;

public class Vide extends ElementTerrain {

    public Vide(boolean s, int x, int y) {
        super(s, x, y);
    }

    @Override
    public Coordonnee getCoordonnee() {
        return super.getCoordonnee();
    }

    @Override
    public String toString() {
        return " . ";
    }

    @Override
    public String toString2(String message) {
        return super.toString2(message);
    }

}
