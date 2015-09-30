package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.User;
import com.pb.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
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

		String username = request.getParameter("userName");
		String userpassword = request.getParameter("userPassword");
		System.out.println("username=" + username);
		System.out.println("userpassword=" + userpassword);
		User user = new User();
		user.setUserName(username);
		user.setUserPassword(userpassword);

		// if(new UserServiceImpl().isManagerLogin(user))
		// {
		// response.sendRedirect("UserShowAllByPageAndMohuServlet");
		// }
		// else
		if (new UserServiceImpl().isManagerLogin(user)) {
			request.getSession().setAttribute("name", username);
			response.sendRedirect("supplierandbill.jsp");
		} else if (new UserServiceImpl().isAdminLogin(user)) {
			// System.out.println("###!#$#"+username);
			// request.setAttribute("name", username);
			// request.setAttribute("userName", "");
			// request.setAttribute("userPassword", "");
			// request.getRequestDispatcher("UserShowAllByPageAndMohuServlet").forward(request,
			// response);
			response.sendRedirect("UserShowAllByPageAndMohuServlet");
		}

		// else if(new UserServiceImpl().isLogin(user)){
		// System.out.println("success");
		// }
		else {
			// response.sendRedirect("login.jsp");
			response.sendRedirect("fail.jsp");
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
