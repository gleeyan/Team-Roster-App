package com.codingdojo.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.codingdojo.web.models.Team;

/**
 * Servlet implementation class Teams
 */
@WebServlet("/Teams")
public class Teams extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teams() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		grab session data
		HttpSession session = request.getSession();
//		get new team name from parameters
		String name = (String)request.getParameter("name");
//		create new team
		Team team = new Team(name);
//		grab teams list from session
		ArrayList<Team> teams = (ArrayList<Team>)session.getAttribute("teams");
//		add new team to teams list
		teams.add(team);
//		update session teams list with new teams list
		session.setAttribute("teams", teams);
//		redirect to team dashboard
		response.sendRedirect("/TeamRoster/Home");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = (String)request.getParameter("name");
		if (name.length() < 2) {
			request.setAttribute("err","Team names must be at least 2 characters long..."); 
            RequestDispatcher view = request.getRequestDispatcher("teams.jsp");
            view.forward(request, response);
		} else {
			doGet(request, response);
		}
	}

}
