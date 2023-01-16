package com.rays.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.marksheet.MarksheetBean;
import com.rays.marksheet.MarksheetModel;
@WebServlet("/AddMarksheetCtl")
public class AddMarksheetCtl extends HttpServlet {
	
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	super.doGet(req, resp);
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String rollno = req.getParameter("rollno");
	String fname = req.getParameter("fname");
	String lname = req.getParameter("lname");
	int phy =Integer.parseInt(req.getParameter("phy"));
	int chem = Integer.parseInt(req.getParameter("chem"));
	int maths = Integer.parseInt(req.getParameter("maths"));

	
	MarksheetBean bean = new MarksheetBean();
	MarksheetModel model = new MarksheetModel();
	
	bean.setRollno(rollno); 
	bean.setFname(fname);
	bean.setLname(lname);
    bean.setPhy(phy);
    bean.setChem(chem);
    bean.setMaths(maths);
    
    
    
    if (rollno.equals("")) {
		System.out.println("hello1111111");
		RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");
		req.setAttribute("rollno", "please enter roll number");
		rd.forward(req, resp);
		
	} else if (fname.equals("")) {
		System.out.println("helllofname");
		RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");
		req.setAttribute("fname", "please enter first name");
				rd.forward(req, resp);
	}
	else if (lname.equals("")) {
		System.out.println("helllolname");
		RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");
		req.setAttribute("lname", "please enter last name");
				rd.forward(req, resp);
	}
    
    
    
    else if (bean != null) {
		try {
			System.out.println("hello222222222");

			model.add(bean);
			RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");

			req.setAttribute("user", "add marksheet successfully");
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();

		}
	} else {
		try {
			model.update(bean);
			RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");
			req.setAttribute("user", "update marksheet successfully");
			rd.forward(req, resp);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			/*
			 * System.out.println("hello33333333333");
			 * 
			 * RequestDispatcher rd = req.getRequestDispatcher("AddMarksheet.jsp");
			 * 
			 * req.setAttribute("error", "Please Enter valid info"); rd.forward(req, resp);
			 */	}
    
  
	
	}
}
