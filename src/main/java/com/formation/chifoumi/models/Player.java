package com.formation.chifoumi.models;

public class Player {

    private String name;
    private int nbOfWinning;

    public Player(String name) {
        this.name = name;
        this.nbOfWinning = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNbOfWinning() {
        return nbOfWinning;
    }

    public void setNbOfWinning(int nbOfWinning) {
        this.nbOfWinning = nbOfWinning;
    }
}
