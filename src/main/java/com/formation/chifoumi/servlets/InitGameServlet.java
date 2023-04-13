package com.formation.chifoumi.servlets;

import com.formation.chifoumi.models.EnumActions;
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

@WebServlet(urlPatterns = {"/"})
public class InitGameServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session.isNew()) {
            System.out.println("New session");
            System.out.println(session.getId());
        }
        else {
            System.out.println("Old session");
            System.out.println(session.getId());
        }

        EnumSet<EnumActions> actions = EnumSet.allOf(EnumActions.class);

        req.setAttribute("actions", actions);

        req
                .getRequestDispatcher("/WEB-INF/game.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        // TODO: make player on new session only
            Player player = new Player("player");
            Player computer = new Player("computer");


        player.setAction(EnumActions.valueOf(req.getParameter("player-action")));
        computer.setRandomAction();

        Player winner = ChifoumiService.getWinner(player, computer);

        req.setAttribute("playerAction", player.getAction().toString());
        req.setAttribute("computerAction", computer.getAction().toString());


        if (winner != null) {
            if (winner.equals(player)) {
                player.increaseWins();
            }
            else {
                computer.increaseWins();
            }
        }

        req.setAttribute("playerTotWins", player.getNbOfWins());
        req.setAttribute("computerTotWins", computer.getNbOfWins());
        req.setAttribute("bigWinner", ChifoumiService.determineBigWinner(player, computer));


        req
                .getRequestDispatcher("/WEB-INF/result.jsp")
                .forward(req, resp);

//        resp.sendRedirect("/results");
    }


}
