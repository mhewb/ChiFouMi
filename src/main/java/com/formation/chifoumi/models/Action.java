package com.formation.chifoumi.models;

public enum Action {

    CHI("Pierre"),
    FOU("Feuille"),
    MI("Ciseaux"),
    ;

    public final String label;
    private Action(String label) {
        this.label = label;
    }
}
