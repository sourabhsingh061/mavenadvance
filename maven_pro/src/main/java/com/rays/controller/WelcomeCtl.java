package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeCtl")
public class WelcomeCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		RequestDispatcher rd = request.getRequestDispatcher("WelcomeView.jsp");
		rd.forward(request, response);

		/*
		 * HttpSession session = request.getSession();
		 * 
		 * 
		 * //session.invalidate(); response.sendRedirect("LoginView.jsp");
		 */
	}

}
