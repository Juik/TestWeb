package com.pb.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.pb.service.impl.UserServiceImpl;
import com.pb.util.UploadUtil;
import com.pb.vo.Page;

public class UploadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 56890894234786L;

	/**
	 * Constructor of the object.
	 */
	public UploadFileServlet() {
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
	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int pageSize = 3;
		String currentPageString = request.getParameter("currentPage");
		int currentPage = 0;
		if (currentPageString == null) {
			currentPage = 1;
		} else {
			currentPage = Integer.parseInt(currentPageString);
		}
		try {
			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			System.out.println("1." + userName + "2." + userPassword + "3.");

			String[] keyWords = new String[] {
					userName == null ? "" : userName,
					userPassword == null ? "" : userPassword };

			// 把上面三个数据传递到业务并得到分页+模糊数据
			Page page = new UserServiceImpl().findUsersByPageAndMohu(
					currentPage, pageSize, keyWords);
			page.setKeyWords(keyWords);
			request.setAttribute("name", "qbt");
			request.setAttribute("page", page);

			List<String> fileListInServer = new ArrayList<String>();

			String realPath = this.getServletContext().getRealPath("/upload");
			File dir = new File(realPath);
			String[] children = dir.list();
			if (children != null) {
				for (int i = 0; i < children.length; i++) {
					fileListInServer.add(children[i]);
				}
			}

			request.setAttribute("downloadList", fileListInServer);
			// request.getRequestDispatcher("usershowallbypage_and_mohu.jsp").forward(request,
			// response);
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*-----------------------------------------------------------*/
		// 文件上传部分
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);

				// 得到所有的表单域，它们目前都被当作FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();

				// 依次处理每个表单域
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// 如果item是正常的表单域
						String name = item.getFieldName();
						String value = item.getString();
						System.out.print("表单域名为:" + name + "表单域值为:" + value);
					} else {
						// 如果item是文件上传表单域

						// 获得文件名及路径
						String fileName = item.getName();
						String contentType = item.getContentType();
						long sizeInBytes = item.getSize();
						// String
						// fileName1=fileName.substring(fileName.lastIndexOf("\\")+1);
						System.out.println("fileName1-->" + fileName);
						System.out.println("contentType-->" + contentType);
						System.out.println("sizeInBytes-->" + sizeInBytes);
						if (fileName != null) {
							File fullFile = new File(item.getName());
							/********************* 这个地方出错了。。。 **********************/
							// 如果文件存在则上传
							if (fullFile.exists()) {
								String realPath = this.getServletContext()
										.getRealPath("/upload");

								File fileOnServer = new File(realPath, fullFile
										.getName());
								item.write(fileOnServer);

								System.out.println("文件"
										+ fileOnServer.getName() + "上传成功");
							} else {
								System.out.println("hey dude it's here");
							}

						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("the enctype must be multipart/form-data");
		}

		// 取得服务器中已有文件的下载列表
		List<String> fileListInServer = new ArrayList<String>();

		String realPath = this.getServletContext().getRealPath("/upload");
		File dir = new File(realPath);
		String[] children = dir.list();
		if (children != null) {
			for (int i = 0; i < children.length; i++) {
				fileListInServer.add(children[i]);
			}
		}

		request.setAttribute("downloadList", fileListInServer);

		// 跳回原页面
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/usershowallbypage_and_mohu.jsp");
		dispatcher.forward(request, response);
		return;
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
