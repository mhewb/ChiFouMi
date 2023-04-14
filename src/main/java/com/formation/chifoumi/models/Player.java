package com.formation.chifoumi.models;

public class Player {

    private String name;
    private int nbOfWins;
    private Action action;

    public Player(String name) {
        this.name = name;
        this.nbOfWins = 0;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name;}

    public int getNbOfWins() {
        return nbOfWins;
    }

    public void increaseWins() {
        this.nbOfWins++;
    }

    public void resetWins() {
        this.nbOfWins = 0;
    }

    public Action getAction() {
        return this.action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    // chi = pierre
    // fou = feuille
    // mi = ciseaux ?

    public void setRandomAction() {

        double random = Math.random();
        if (random < 0.33) {
            this.setAction(Action.CHI);
        } else if (random <= 0.66) {
            this.setAction(Action.FOU);
        } else {
            this.setAction(Action.MI);
        }

    }


}


