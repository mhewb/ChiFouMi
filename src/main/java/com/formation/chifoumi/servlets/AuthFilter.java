package com.formation.chifoumi.servlets;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();

        // Here tu public rtoute accesible w/o connexion
        if (request.getRequestURI().equals(request.getContextPath() + "/") || request.getRequestURI().equals(request.getContextPath() + "/login")) {
            chain.doFilter(req, resp); // La page / reste accessible
        } else {
            if (session.getAttribute("username") == null) {
                // If no username: go to login page
                response.sendRedirect(request.getContextPath() + "/login");
            } else {
                // Continue la chaine des filtres/navigations
                chain.doFilter(req, resp);
            }
        }

    }
}
