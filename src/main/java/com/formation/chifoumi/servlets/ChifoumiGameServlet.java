package com.formation.chifoumi.servlets;

import com.formation.chifoumi.models.Action;
import com.formation.chifoumi.models.Player;
import com.formation.chifoumi.services.ChifoumiService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.EnumSet;

@WebServlet(urlPatterns = {"/", "/game"})
public class ChifoumiGameServlet extends HttpServlet {

    Player player = new Player("player");
    Player computer = new Player("computer");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("username") == null) {
            req.setAttribute("askLog", "Please go log yourself to play");
        } else {
            EnumSet<Action> actions = EnumSet.allOf(Action.class);
            req.setAttribute("actions", actions);
        }

        req
                .getRequestDispatcher("/WEB-INF/game.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        player.setName((String) session.getAttribute("username"));

        player.setAction(Action.valueOf(req.getParameter("player-action")));
        computer.setRandomAction();

        Player winner = ChifoumiService.getWinner(player, computer);

        req.setAttribute("playerAction", player.getAction().toString());
        req.setAttribute("computerAction", computer.getAction().toString());
        req.setAttribute("winner", winner);


        if (winner != null) {
            if (winner.equals(player)) {
                player.increaseWins();
            } else {
                computer.increaseWins();
            }
        }

        req.setAttribute("playerTotWins", player.getNbOfWins());
        req.setAttribute("computerTotWins", computer.getNbOfWins());
        req.setAttribute("bigWinner", ChifoumiService.determineBigWinner(player, computer));
//        session.invalidate();


        req
                .getRequestDispatcher("/WEB-INF/result.jsp")
                .forward(req, resp);

//        resp.sendRedirect("/results");
    }


}
