package com.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.marksheet.MarksheetBean;
import com.rays.marksheet.MarksheetModel;

@WebServlet("/GetMarksheetCtl.do")
public class GetMarksheetbyrollCtl extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		PrintWriter out = resp.getWriter();

		String rollno = req.getParameter("rollno");

		try {
			bean = model.getbyrollno(rollno);
			if (bean != null) {
				RequestDispatcher rd = req.getRequestDispatcher("GetMarksheet.jsp");
				req.setAttribute("send", bean);
				rd.forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		/*
		 * if (rollno.equals("")) { RequestDispatcher rd =
		 * req.getRequestDispatcher("GetMarksheet.jsp");
		 * req.setAttribute("use","Roll no is required" ); rd.forward(req, resp);
		 * 
		 * } else { RequestDispatcher rd = req.getRequestDispatcher("GetMarksheet.jsp");
		 * req.setAttribute("not","Please enter Valid Roll no" ); rd.forward(req, resp);
		 * }
		 */
		  
		  
		 

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
