package com.pb.util;

public class UploadUtil {
	/**
	 * 上传路径
	 */
	private static String uploadPath;

	/**
	 * 取得上传路径
	 * 
	 * @return
	 */
	public static String getUploadPath() {
		return uploadPath;
	}

	/**
	 * 设置上传路径
	 * 
	 * @param uploadPath
	 */
	public static void setUploadPath(String uploadPath) {
		UploadUtil.uploadPath = uploadPath + "upload/";
	}
}
