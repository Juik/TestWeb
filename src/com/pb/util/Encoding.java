package com.pb.util;

import java.io.UnsupportedEncodingException;

public class Encoding {
	private static String globalEncoding_SRC = CommonValue.globalEncoding_SRC;
	private static String globalEncoding_DEST = CommonValue.globalEncoding_DEST;

	public static String encode(String srcString, String srcEncoding,
			String destEncoding) {
		String temp = null;
		try {
			temp = new String(srcString.getBytes(srcEncoding), destEncoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}

	public static String encode(String srcString, String destEncoding) {
		String temp = null;
		try {
			temp = new String(srcString.getBytes(globalEncoding_SRC),
					destEncoding);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}

	public static String encode(String srcString) {
		String temp = null;
		try {
			temp = new String(srcString.getBytes(globalEncoding_SRC),
					globalEncoding_DEST);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp;
	}
}
