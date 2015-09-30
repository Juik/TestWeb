package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.UserService;
import com.pb.service.impl.UserServiceImpl;
import com.pb.util.PropertyUtil;
import com.pb.vo.Page;

public class UserShowAllByPageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserShowAllByPageServlet() {
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
		// 从属性文件中得到pageSize
		int pageSize = 3;
		// int pageSize=Integer.parseInt(new
		// PropertyUtil("resource/pagesize.properties").getProperty("pageSize"));
		// 得到当前页
		String currentPageString = request.getParameter("currentPage");
		int currentPage = 0;
		if (currentPageString == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageString);
		}
		UserService userService = new UserServiceImpl();
		Page page = null;
		try {
			page = userService.findUsersByPage(currentPage, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("page", page);
		request.getRequestDispatcher("usershowallbypage.jsp").forward(request,
				response);
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
