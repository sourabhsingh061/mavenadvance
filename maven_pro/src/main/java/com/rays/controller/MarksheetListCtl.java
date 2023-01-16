package com.rays.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.marksheet.MarksheetBean;
import com.rays.marksheet.MarksheetModel;
import com.rays.mavenpro.UserRegistrationBean;
import com.rays.mavenpro.UserRegistrationModel;


@WebServlet("/MarksheetListCtl")
public class MarksheetListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		UserRegistrationBean bin = new UserRegistrationBean();
		// List list = new ArrayList();
		// String op = req.getParameter("operation");

		try {
			List list = model.GetMarksheetList();

			RequestDispatcher rd = req.getRequestDispatcher("MarksheetList.jsp");
			req.setAttribute("lis", list);
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		
		String op = req.getParameter("operation");
	bean.setFname(req.getParameter("fname"));
	bean.setRollno(req.getParameter("rollno"));
	
	 if(op.equals("search")){
			try {
				List list =	model.searchMarksheet(bean);
				RequestDispatcher rd = req.getRequestDispatcher("MarksheetList.jsp");
				req.setAttribute("lis",list);
				rd.forward(req, resp);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
				
		}
		
	 else if (op.equals("Add")) {
			RequestDispatcher rd1 = req.getRequestDispatcher("AddMarksheet.jsp");
			rd1.forward(req, resp);
		} else if (op.equals("delete")) {
			RequestDispatcher rd1 = req.getRequestDispatcher("AddMarksheet.jsp");
			rd1.forward(req, resp);
		}

	}
	}

