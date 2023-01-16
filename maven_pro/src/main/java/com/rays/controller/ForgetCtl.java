package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.mavenpro.UserRegistrationBean;
import com.rays.mavenpro.UserRegistrationModel;

@WebServlet("/ForgetCtl")
public class ForgetCtl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel model = new UserRegistrationModel();
		
		
		 try {	
			 bean = model.Forget(email);
      if (email.equals("")) {

	      RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
	      request.setAttribute("email", "Username is required");
	      rd.forward(request, response);
         }
			
			else if(bean != null) {
				RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
				request.setAttribute("send", bean.getPwd());
				rd.forward(request, response);
			}

		
		 else  {
			RequestDispatcher rd = request.getRequestDispatcher("ForgetView.jsp");
			request.setAttribute("use", "Username is invalid");
			rd.forward(request, response);
	    }
		 }
		 catch (Exception e) {
				e.printStackTrace();
			}

		
	}


	
}