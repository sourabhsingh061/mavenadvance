package com.rays.mavenpro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserRegistrationCtl() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserRegistrationBean bean = new UserRegistrationBean();
		UserRegistrationModel model = new UserRegistrationModel();
		// PrintWriter out = response.getWriter();

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String cpwd = request.getParameter("cpwd");

		bean.setFname(fname);
		bean.setLname(lname);
		bean.setGender(gender);
		bean.setEmail(email);
		bean.setPwd(pwd);
		bean.setCpwd(cpwd);

		if (fname.equals("")) {
			System.out.println("hello1111111");
			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");
			request.setAttribute("fname", "Please Enter First Name");
			request.setAttribute("lname", "Please Enter Last Name");
			request.setAttribute("gender", "Please Enter gender");
			request.setAttribute("email", "Please Enter email");
			request.setAttribute("pwd", "Please Enter password");
			request.setAttribute("cpwd", "Please Enter confirm Password");

			rd.forward(request, response);
		} else if (bean != null) {
			try {
				System.out.println("hello222222222");

				model.add(bean);
				RequestDispatcher rd = request.getRequestDispatcher("LoginView.jsp");

				request.setAttribute("user", "User registerered successfully");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			System.out.println("hello33333333333");

			RequestDispatcher rd = request.getRequestDispatcher("UserRegistrationView.jsp");

			request.setAttribute("error", "Please Enter valid info");
			rd.forward(request, response);
		}
	}

}
