package com.adsun.demo;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.webapp.WebAppContext;

public class ServletDemo extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3462685820343345080L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("11");
		WebAppContext context = new WebAppContext();
	}

}
