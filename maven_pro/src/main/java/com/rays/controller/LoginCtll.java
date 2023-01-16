package com.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.mavenpro.UserRegistrationBean;
import com.rays.mavenpro.UserRegistrationModel;

@WebServlet("/Loginctll")
public class LoginCtll extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String email = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		
		//set cookie  and get cookie in Cookiegetctl
		/*Cookie c= new Cookie("e", email);
		Cookie c2 = new Cookie("p", pwd);
		c.setMaxAge(24*60*60);
		c2.setMaxAge(24*60*60);
		response.addCookie(c);
		response.addCookie(c2);*/

		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel model = new UserRegistrationModel();
		HttpSession session = request.getSession(true);
		
		
		
		

		try {
			bean = model.authenticate(email, pwd);

			if (email.equals("") && pwd.equals("")) {
				System.out.println("email pass");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				request.setAttribute("two", "Username and password is required");
				rd.forward(request, response);

			} else if (email.equals("")) {
				System.out.println("email ");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				request.setAttribute("email", "Username is required");
				rd.forward(request, response);
			} else if (pwd.equals("")) {
				System.out.println(" pass");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				request.setAttribute("pwd", "password is required");
				rd.forward(request, response);
			} else if (bean != null) {
				System.out.println("hello");
				session.setAttribute("user", bean);

				RequestDispatcher rd = request.getRequestDispatcher("WelcomeCtl");
				//request.setAttribute("success", bean);
				rd.forward(request, response);

			} else {
				System.out.println("rays,...............");
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");
				request.setAttribute("one", "Username and password is invalid");

				rd.forward(request, response);

			}
		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
