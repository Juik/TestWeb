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

			// �������������ݴ��ݵ�ҵ�񲢵õ���ҳ+ģ������
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
		// �ļ��ϴ�����
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();

				ServletFileUpload upload = new ServletFileUpload(factory);

				// �õ����еı�������Ŀǰ��������FileItem
				List<FileItem> fileItems = upload.parseRequest(request);
				Iterator<FileItem> iter = fileItems.iterator();

				// ���δ���ÿ������
				while (iter.hasNext()) {
					FileItem item = (FileItem) iter.next();

					if (item.isFormField()) {
						// ���item�������ı���
						String name = item.getFieldName();
						String value = item.getString();
						System.out.print("������Ϊ:" + name + "����ֵΪ:" + value);
					} else {
						// ���item���ļ��ϴ�����

						// ����ļ�����·��
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
							/********************* ����ط������ˡ����� **********************/
							// ����ļ��������ϴ�
							if (fullFile.exists()) {
								String realPath = this.getServletContext()
										.getRealPath("/upload");

								File fileOnServer = new File(realPath, fullFile
										.getName());
								item.write(fileOnServer);

								System.out.println("�ļ�"
										+ fileOnServer.getName() + "�ϴ��ɹ�");
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

		// ȡ�÷������������ļ��������б�
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

		// ����ԭҳ��
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
