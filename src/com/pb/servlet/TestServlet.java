package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private String encodingName;
	private String globalEncodingName;

	public TestServlet() {
		System.out.println("TestServlet.constructor()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TestServlet.init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("TestServlet.doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("TestServlet.doPost()");
	}

	@Override
	public void destroy() {
		System.out.println("TestServlet.destroy()");
	}

}
