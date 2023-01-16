package com.rays.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookiegetCtl")
public class CookiegetCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();
		Cookie[] c = req.getCookies();
		for (int i = 0; i <= c.length - 1; i++) {
			Cookie c1 = c[i];
			String name = c1.getName();
			String value = c1.getValue();
			out.println(name + " " + value);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ServletContext app = getServletContext();
		Integer count = (Integer) app.getAttribute("visitor");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		app.setAttribute("visitor", count);
		PrintWriter out = resp.getWriter();

	}
}
