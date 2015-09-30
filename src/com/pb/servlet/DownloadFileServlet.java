package com.pb.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pb.util.UploadUtil;

/**
 * 用于文件下载处理的Servlet
 * 
 */
public class DownloadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 56890894234786L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		// 要下载的文件名
		String filename = request.getParameter("file");

		// 文件真实地址C:\apache-tomcat-6.0.37\webapps\TestFileUpload\xxx.xml
		String filePathname = UploadUtil.getUploadPath() + File.separator
				+ filename;
		String filePathName = new String(filePathname.getBytes("ISO-8859-1"),
				"UTF-8");
		// 设置内容格式
		// response.setContentType("text/x-msdownload");

		// 设置文件头信息
		response.setHeader("Content-Disposition", "attachment; filename="
				+ filename + "");

		OutputStream outputStream = response.getOutputStream();
		InputStream inputStream = new FileInputStream(filePathName);
		byte[] buffer = new byte[1024];
		int i = -1;
		while ((i = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, i);
		}
		outputStream.flush();
		outputStream.close();
		inputStream.close();
		outputStream = null;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		doPost(request, response);
	}
}
