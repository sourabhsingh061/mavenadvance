package com.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/VisitCount")
public class VisitCount extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext app = getServletContext();
		resp.setIntHeader("Refresh", 4);
		Integer count = (Integer) app.getAttribute("visitor");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		app.setAttribute("visitor", count);
		PrintWriter out = resp.getWriter();
		out.println("visitors count " + count);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
	}
}
