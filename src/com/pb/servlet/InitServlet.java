package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.pb.util.CommonValue;

public class InitServlet extends HttpServlet {
	public InitServlet() {
		System.out.println("InitServlet.constructor()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("InitServlet.init()");
		String encodingName = getInitParameter("encodingName");
		System.out.println("encodingName=" + encodingName);
		CommonValue.globalEncodingName = encodingName;
		// this.getServletContext().getInitParameter(encodingName);
	}

	@Override
	public void destroy() {
		System.out.println("InitServlet.destroy()");
	}
}
