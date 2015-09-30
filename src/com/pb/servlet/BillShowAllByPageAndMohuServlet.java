package com.pb.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.service.impl.BillServiceImpl;
import com.pb.service.impl.UserServiceImpl;
import com.pb.vo.Page;

public class BillShowAllByPageAndMohuServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BillShowAllByPageAndMohuServlet() {
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

		// request.setCharacterEncoding(CommonValue.globalEncoding_DEST);
		request.setCharacterEncoding("UTF-8");
		// 从属性文件中得到pageSize
		// int pageSize=Integer.parseInt(new
		// PropertyUtil("resource/pagesize.properties").getProperty("pageSize"));
		int pageSize = 10;
		// 得到当前页
		String currentPageString = request.getParameter("currentPage");
		int currentPage = 0;
		if (currentPageString == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageString);
		}
		// 获取页面中的模糊数据
		try {
			String productName = request.getParameter("productName");
			String supplierName = request.getParameter("supplierName");
			String[] keyWords = new String[] {
					productName == null ? "" : productName,
					supplierName == null ? "" : supplierName };
			// 把上面三个数据传递到业务并得到分页+模糊数据
			Page page = new BillServiceImpl().findBillsByPageAndMohu(
					currentPage, pageSize, keyWords);
			page.setKeyWords(keyWords);
			// 现在只能hardcode，request带过来的话会让用户名密码都有值。

			request.setAttribute("name", "aa");
			request.setAttribute("page", page);
			request.setAttribute("productName", productName);
			request.setAttribute("supplierName", supplierName);
			request.getRequestDispatcher("billshowallbypage_and_mohu.jsp")
					.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
