package com.pb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.entity.Bill;
import com.pb.service.impl.BillServiceImpl;

public class BillAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BillAddServlet() {
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

		String productName = request.getParameter("productName");
		String supplierName = request.getParameter("supplierName");
		String amount = request.getParameter("amount");
		String price = request.getParameter("price");
		String pay = request.getParameter("pay");
		String billtime = request.getParameter("billtime");
		String saleworker = request.getParameter("saleworker");
		Bill bill = new Bill();
		bill.setPrice(Float.parseFloat(price));
		bill.setBilltime(billtime);
		bill.setproductName(productName);
		bill.setsupplierName(supplierName);
		bill.setsaleworker(saleworker);
		bill.setPay(Float.parseFloat(pay));
		bill.setAmount(Integer.parseInt(amount));
		if (new BillServiceImpl().addBill(bill)) {
			response.sendRedirect("BillShowAllByPageAndMohuServlet");
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
