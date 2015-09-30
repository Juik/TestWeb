package com.pb.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//得到property的pagesize里面的数字
public class PropertyUtil {
	private Properties p = new Properties();

	public PropertyUtil() {
	}

	public PropertyUtil(String fileName) {
		try {
			InputStream is = PropertyUtil.class.getClassLoader()
					.getResourceAsStream(fileName);
			p.load(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return p.getProperty(key);
	}
}
