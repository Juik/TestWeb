package com.pb.util;

public class UploadUtil {
	/**
	 * �ϴ�·��
	 */
	private static String uploadPath;

	/**
	 * ȡ���ϴ�·��
	 * 
	 * @return
	 */
	public static String getUploadPath() {
		return uploadPath;
	}

	/**
	 * �����ϴ�·��
	 * 
	 * @param uploadPath
	 */
	public static void setUploadPath(String uploadPath) {
		UploadUtil.uploadPath = uploadPath + "upload/";
	}
}
