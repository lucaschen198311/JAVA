package com.codingdojo.hello.controllers;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GuessNumber
 */
@WebServlet("/GuessNumber")
public class GuessNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("answer") == null) {
			int min = 1;
			int max = 100;
			Random randomNum = new Random();
			int randnum = min + randomNum.nextInt(max);
			System.out.println("The random number is "+randnum);
			session.setAttribute("answer", randnum);
		}
		int guess = Integer.parseInt(request.getParameter("guess"));
		String message = "";
		String messages = "";
		if(guess < (int)session.getAttribute("answer")) {
			message = "Too Low!!!";
			messages = "red";
		}
		else if(guess > (int)session.getAttribute("answer")) {
			message = "Too High!!!";
			messages = "red";
		}
		else {
			message = guess + " was the number!";
			messages = "green";
			session.setAttribute("win", "show");
			session.setAttribute("play", "hide");
		}
		session.setAttribute("message", message);
		session.setAttribute("messages", messages);
		response.sendRedirect("/Counter");
		//System.out.println("inside"+request.getParameter("guess"));
	}

}
