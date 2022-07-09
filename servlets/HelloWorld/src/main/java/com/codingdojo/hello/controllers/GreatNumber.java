package com.codingdojo.hello.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatNumber
 */
@WebServlet("/GreatNumber")
public class GreatNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if((Integer)session.getAttribute("answer") == null) {
			Random rand = new Random();
			Integer number = (Integer) rand.nextInt(100) + 1;
			session.setAttribute("answer", number);
		}
		// Let view handle the request
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/greatnumber.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String guess = request.getParameter("guess");
		String answer = (String) session.getAttribute("answer");
		Integer g = Integer.parseInt(guess);
		Integer a = Integer.parseInt(answer);
		if(g > a) {
			request.setAttribute("message", "number is too high!");
		}else if(g < a) {
			request.setAttribute("message", "number is too low!");
		}else {
			request.setAttribute("message", "number is just " + a);
			//reset answer for play again
			Random rand = new Random();
			Integer number = (Integer) rand.nextInt(100) + 1;
			session.setAttribute("answer", number);
			//render the view for correct answer and play again
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/greatnumbercorrect.jsp");
			view.forward(request, response);
		}
		//render the view for correct answer and play again
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/greatnumber.jsp");
		view.forward(request, response);
	}
}
