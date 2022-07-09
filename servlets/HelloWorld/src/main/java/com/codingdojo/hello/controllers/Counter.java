package com.codingdojo.hello.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Counter
 */
@WebServlet("/Counter")
public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Counter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message = "";
		String win = "hide";
		String play = "show";
		HttpSession session = request.getSession();
		if(session.getAttribute("message") != null) {
			message = (String)session.getAttribute("message");
		}
		if(session.getAttribute("win") != null) {
			win = (String)session.getAttribute("win");
		}
		if(session.getAttribute("play") != null) {
			play = (String)session.getAttribute("play");
		}
		request.setAttribute("message", message);
		request.setAttribute("win", win);
		request.setAttribute("play", play);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/counter.jsp");
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
