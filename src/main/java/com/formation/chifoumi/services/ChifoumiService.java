package com.formation.chifoumi.services;

import com.formation.chifoumi.models.EnumActions;
import com.formation.chifoumi.models.Player;

public class ChifoumiService {

    public static Player determineBigWinner(Player player1, Player player2) {
        if (player1.getNbOfWins() == 3) {
            player1.resetWins();
            player2.resetWins();
            return player1;
        } else if (player2.getNbOfWins() == 3) {
            player1.resetWins();
            player2.resetWins();
            return player2;
        } else {
            return null;
        }
    }

    public static Player getWinner(Player player1, Player player2) {
        if (player1.getAction() == player2.getAction()) {
            return null;
        }

        switch (player1.getAction()) {
            case CHI -> {
                if (player2.getAction().equals(EnumActions.MI)) {
                    return player1;
                } else {
                    return player2;
                }
            }
            case FOU -> {
                if (player2.getAction().equals(EnumActions.CHI)) {
                    return player1;
                } else {
                    return player2;
                }
            }
            case MI -> {
                if (player2.getAction().equals(EnumActions.FOU)) {
                    return player1;
                } else {
                    return player2;
                }
            }
            default -> {
                return null;
            }
        }

    }
}
