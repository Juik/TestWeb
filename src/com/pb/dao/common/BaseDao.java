package com.pb.dao.common;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "qbt4juik");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

	public static void closeAll(ResultSet rs, PreparedStatement pstmt,
			Connection con) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int executeUpdate(String sql, Object... params)
			throws Exception {
		int rowAffects = 0;
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject((i + 1), params[i]);
			}
		}
		rowAffects = pstmt.executeUpdate();
		closeAll(null, pstmt, con);
		return rowAffects;
	}

	public static List executeQuery(Class clazz, String sql, Object... params)
			throws Exception {
		List list = new ArrayList();
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject((i + 1), params[i]);
			}
		}
		ResultSet rs = pstmt.executeQuery();
		// 获取表头的列头信息（元数据）
		ResultSetMetaData rsmd = rs.getMetaData();
		List<String> columnNames = new ArrayList<String>();
		for (int i = 0; i < rsmd.getColumnCount(); i++) {
			columnNames.add(rsmd.getColumnName(i + 1));
		}

		// 相当于行循环
		while (rs.next()) {
			Object obj = clazz.newInstance();
			// 循环列
			for (String columnName : columnNames) {
				// columnName=userName--->setUserName
				String setterName = "set"
						+ columnName.substring(0, 1).toUpperCase()
						+ columnName.substring(1, columnName.length()) + "()";
				Method[] methods = clazz.getDeclaredMethods();
				for (Method method : methods) {
					if (setterName.equals(method.getName())) {
						Object value = rs.getObject(columnName);
						method.invoke(obj, value);
					}
				}
			}
			list.add(obj);
		}
		closeAll(rs, pstmt, con);
		return list;

	}

}
