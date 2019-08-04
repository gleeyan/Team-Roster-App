package com.codingdojo.web.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Player;
import com.codingdojo.web.models.Team;

/**
 * Servlet implementation class AddPlayer
 */
@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPlayer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		HttpSession session = request.getSession();
		ArrayList<Team> teams = (ArrayList<Team>)session.getAttribute("teams");
		Team thisTeam = teams.get(id);
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		int age = Integer.parseInt(request.getParameter("age"));
		Player newPlayer = new Player(first, last, age);
		ArrayList<Player> players = thisTeam.getPlayers();
		players.add(newPlayer);
		thisTeam.setPlayers(players);
		teams.set(id, thisTeam);
		session.setAttribute("teams", teams);
		response.sendRedirect("/TeamRoster/TeamDetails?id=" + id);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String first = request.getParameter("first");
		String last = request.getParameter("last");
		int age = Integer.parseInt(request.getParameter("age"));
		if (first.length() < 2 || last.length() < 2) {
			request.setAttribute("id", id);
			request.setAttribute("err","Player first and last names must be at least 2 characters long..."); 
            RequestDispatcher view = request.getRequestDispatcher("players.jsp");
            view.forward(request, response);
		} else if (age < 18) {
			request.setAttribute("id", id);
			request.setAttribute("err","Player must be at least 18 years or older..."); 
            RequestDispatcher view = request.getRequestDispatcher("players.jsp");
            view.forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
