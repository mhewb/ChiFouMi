package com.formation.chifoumi.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("username") != null) {
            req.setAttribute("alreadyLogged", "You are already logged !");
        } else {
            req.setAttribute("username", session.getAttribute("username"));
        }

        req
            .getRequestDispatcher("/WEB-INF/login.jsp")
            .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.equals("admin") && password.equals("admin")) {

            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            resp.sendRedirect(req.getContextPath() + "/game");

        } else {
            req.setAttribute("LoginError", true);
            req
                .getRequestDispatcher("/WEB-INF/login.jsp")
                .forward(req, resp);
            resp.sendRedirect(req.getContextPath() + "/login");


        }

    }
}