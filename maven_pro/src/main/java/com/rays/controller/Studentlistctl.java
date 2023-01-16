package com.rays.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.student.Studentbean;
import com.rays.student.Studentmodel;
@WebServlet (urlPatterns =  "/Studentlistctl")
public class Studentlistctl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		  Studentbean bean = new Studentbean(); 
		  Studentmodel model = new Studentmodel();
		  
		  
		try {
			List list = model.GetStudentList(); 
		  
		  
		  RequestDispatcher rd =req.getRequestDispatcher("StudentView.jsp");
		  req.setAttribute("lis", list);
		  rd.forward(req, resp);
		  
		  
		  } catch (Exception e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }	
			}
	
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
