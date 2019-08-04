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
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		check session for created teams then add them to teams list
		HttpSession session = request.getSession();
		ArrayList<Team> sessTeams = (ArrayList<Team>)session.getAttribute("teams");
		
//		create teams list
		ArrayList<Team> teams = new ArrayList<Team>();
		
//		if session teams list doesnt exist
		if (sessTeams == null) {
//			create teams
			Team ninja = new Team("Ninjas");
			Team samurai = new Team("Samurai");
			Team knight = new Team("Knights");
			
//			create players
			Player nin1 = new Player("Nancy", "Ninja", 31);
			Player nin2 = new Player("Norman", "Ninja", 35);
			Player sam1 = new Player("Sally", "Samurai", 24);
			Player sam2 = new Player("Simon", "Samurai", 30);
			Player sam3 = new Player("Samurai", "Sam", 18);
			Player sam4 = new Player("Stephanie", "Samurai", 28);
			Player sam5 = new Player("Samurai", "Steve", 37);
			Player kni1 = new Player("Kelly", "Knight", 19);
			Player kni2 = new Player("Ken", "Knight", 35);
			Player kni3 = new Player("Kathy", "Knight", 40);
			Player kni4 = new Player("Knight", "Kevin", 29);
			
//			create player lists
			ArrayList<Player> team1 = new ArrayList<Player>();
			ArrayList<Player> team2 = new ArrayList<Player>();
			ArrayList<Player> team3 = new ArrayList<Player>();
			
//			add players to lists
			team1.add(nin1);
			team1.add(nin2);
			team2.add(sam1);
			team2.add(sam2);
			team2.add(sam3);
			team2.add(sam4);
			team2.add(sam5);
			team3.add(kni1);
			team3.add(kni2);
			team3.add(kni3);
			team3.add(kni4);
			
//			add lists to teams
			ninja.setPlayers(team1);
			samurai.setPlayers(team2);
			knight.setPlayers(team3);
			
//			add teams to list
			teams.add(ninja);
			teams.add(samurai);
			teams.add(knight);
		} else {
			for (Team team : sessTeams) {
				teams.add(team);
			}
		}
//		reset session teams to match new teams list
		session.setAttribute("teams", teams);
		
//		set list to attribute to send to JSP file
		request.setAttribute("teams", teams);
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/home.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
