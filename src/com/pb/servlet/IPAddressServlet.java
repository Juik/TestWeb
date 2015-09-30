package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IPAddressServlet extends HttpServlet {
	private String ipRange;

	/**
	 * Constructor of the object.
	 */
	public IPAddressServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] ips = ipRange.split("-");
		int ip1 = Integer.parseInt(ips[0]
				.substring(ips[0].lastIndexOf(".") + 1));
		int ip2 = Integer.parseInt(ips[1]
				.substring(ips[1].lastIndexOf(".") + 1));

		String realIp = request.getRemoteAddr();
		System.out.println("realIp=" + realIp);
		int ip = Integer
				.parseInt(realIp.substring(realIp.lastIndexOf(".") + 1));
		if (ip >= ip1 && ip <= ip2) {
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}

	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		this.ipRange = this.getInitParameter("ipRange");

	}

}
