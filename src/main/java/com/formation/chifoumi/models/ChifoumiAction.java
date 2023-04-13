package com.formation.chifoumi.models;

import java.lang.Math;

public class ChifoumiAction {

    // chi = pierre
    // fou = feuille
    // mi = ciseaux ?


    private Action action;
    private String player;

    public Action getAction() {
        return action;
    }

    public String getPlayer() {
        return player;
    }

    public ChifoumiAction(Action action, String player) {
        this.action = action;
        this.player = player;
    }

    public static String getWinner(ChifoumiAction action1, ChifoumiAction action2) {
        if (action1.action == action2.action) {
            return "No winner";
        }

        switch (action1.action) {
            case CHI -> {
                if (action2.action.equals(Action.MI)) {
                    return action1.player;
                } else {return action2.player;}
            }
            case FOU -> {
                if (action2.action.equals(Action.CHI)) {
                    return action1.player;
                } else {return action2.player;}
            }
            case MI -> {
                if (action2.action.equals(Action.FOU)) {
                    return action1.player;
                } else {return action2.player;}
            }
            default -> {
                return "No winner";
            }
        }

    }

    public static ChifoumiAction computerAction() {

        double random = Math.random();
        if (random < 0.33) {
            return new ChifoumiAction(Action.CHI, "computer");
        } else if (random <= 0.66) {
            return new ChifoumiAction(Action.FOU, "computer");
        } else {
            return new ChifoumiAction(Action.MI, "computer");
        }

    }



}
