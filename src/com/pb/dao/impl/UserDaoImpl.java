package com.pb.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pb.dao.UserDao;
import com.pb.dao.common.BaseDao;
import com.pb.entity.User;
import com.pb.vo.Page;

public class UserDaoImpl implements UserDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	@Override
	public int addUser(User user) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "insert into t_user (username,userpassword,authority) values (?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getAuthority());
		rowAffect = pstmt.executeUpdate();

		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	/*
	 * @Override public int addUser(User user) throws Exception { int rowAffects
	 * = 0; String sql =
	 * "insert into t_user (username,userpassword) values (?,?)"; rowAffects =
	 * BaseDao.executeUpdate(sql, new
	 * Object[]{user.getUserName(),user.getUserPassword()}); return rowAffects;
	 * }
	 */

	@Override
	public int deleteUser(User user) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "delete from t_user where id = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setLong(1, user.getId());
		rowAffect = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	@Override
	public List<User> findAllUsers() throws Exception {
		List<User> users = new ArrayList<User>();
		con = BaseDao.getConnection();
		String sql = "select id as idd,username as uname,userpassword as upwd,authority as at from t_user";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("idd"));
			user.setUserName(rs.getString("uname"));
			user.setUserPassword(rs.getString("upwd"));
			user.setAuthority(rs.getString("authority"));
			users.add(user);

		}
		BaseDao.closeAll(rs, pstmt, con);
		return users;
	}

	@Override
	public User findUserById(int id) throws Exception {
		System.out.println("enter userDaoImplt.finduserbyID");
		User user = null;
		con = BaseDao.getConnection();
		String sql = "select * from t_user where id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, id);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			user = new User();
			user.setId(id);
			user.setUserName(rs.getString("username"));
			user.setUserPassword(rs.getString("userpassword"));
			user.setAuthority(rs.getString("authority"));
		}
		BaseDao.closeAll(rs, pstmt, con);
		return user;
	}

	@Override
	public int updateUser(User user) throws Exception {
		int rowAffect = 0;
		con = BaseDao.getConnection();
		String sql = "update t_user set username =?,userpassword=?,authority=? where id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		pstmt.setString(3, user.getAuthority());
		pstmt.setLong(4, user.getId());
		rowAffect = pstmt.executeUpdate();
		BaseDao.closeAll(null, pstmt, con);
		return rowAffect;
	}

	private List<User> findUsersByPageImpl(int currentPage, int pageSize)
			throws Exception {
		List<User> users = new ArrayList<User>();
		con = BaseDao.getConnection();
		String sql = "select * from t_user limit ?,?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, (currentPage - 1) * pageSize);
		pstmt.setInt(2, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setUserPassword(rs.getString("userpassword"));
			user.setAuthority(rs.getString("authority"));
			users.add(user);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return users;
	}

	// 搜索总共多少id
	private int getCount() throws Exception {
		int count = 0;
		con = BaseDao.getConnection();
		String sql = "select count(id) as geshu from t_user";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs.next()) {
			count = rs.getInt("geshu");
		}
		BaseDao.closeAll(rs, pstmt, con);
		return count;
	}

	@Override
	public Page findUsersByPage(int currentPage, int pageSize) throws Exception {
		Page page = new Page();
		int count = this.getCount();
		// 如何总count数可以被pageSize整除，则取这个数，否则取这个数加一
		int totalPage = count % pageSize == 0 ? count / pageSize
				: ((count / pageSize) + 1);
		int previousPage = 0;
		if (currentPage == 1) {
			previousPage = 1;
		} else {
			previousPage = currentPage - 1;
		}
		int nextPage = 0;
		if (currentPage == totalPage) {
			nextPage = totalPage;
		} else {
			nextPage = currentPage + 1;
		}
		page.setCurrentPage(currentPage);
		page
				.setCurrentPageData(this.findUsersByPageImpl(currentPage,
						pageSize));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	@Override
	public List<User> findUsersByMohu(String... keyWords) throws Exception {
		List<User> users = new ArrayList<User>();
		con = BaseDao.getConnection();
		String sql = "select * from t_user where username like ? and userpassword like ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setUserPassword(rs.getString("userpassword"));
			users.add(user);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return users;
	}

	private int getCount(String... keyWords) {
		int count = 0;
		con = BaseDao.getConnection();
		try {
			String sql = "select count(id) as geshu from t_user where username like ? and userpassword like ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + keyWords[0] + "%");
			pstmt.setString(2, "%" + keyWords[1] + "%");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt("geshu");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BaseDao.closeAll(rs, pstmt, con);
		return count;
	}

	@Override
	public Page findUsersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception {
		Page page = new Page();
		int count = this.getCount(keyWords);
		int totalPage = count % pageSize == 0 ? count / pageSize
				: ((count / pageSize) + 1);
		int previousPage = 0;
		if (currentPage == 1) {
			previousPage = 1;
		} else {
			previousPage = currentPage - 1;
		}
		int nextPage = 0;
		if (currentPage == totalPage) {
			nextPage = totalPage;
		} else {
			nextPage = currentPage + 1;
		}
		page.setCurrentPage(currentPage);
		page.setCurrentPageData(this.findUsersByPageAndMohuImpl(currentPage,
				pageSize, keyWords));
		page.setNextPage(nextPage);
		page.setPageSize(pageSize);
		page.setPreviousPage(previousPage);
		page.setTotalCount(count);
		page.setTotalPage(totalPage);
		return page;
	}

	// 实现本页面的users的内容列表(under MohuAndPage query)
	private List<User> findUsersByPageAndMohuImpl(int currentPage,
			int pageSize, String... keyWords) throws Exception {
		List<User> users = new ArrayList<User>();
		con = BaseDao.getConnection();
		String sql = "select * from t_user where username like ? AND userpassword like ? limit ?,?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "%" + keyWords[0] + "%");
		pstmt.setString(2, "%" + keyWords[1] + "%");
		pstmt.setInt(3, (currentPage - 1) * pageSize);
		pstmt.setInt(4, pageSize);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("username"));
			user.setUserPassword(rs.getString("userpassword"));
			user.setAuthority(rs.getString("authority"));
			users.add(user);
		}
		BaseDao.closeAll(rs, pstmt, con);
		return users;
	}

	@Override
	public boolean isLogin(User user) throws Exception {
		boolean flag = false;
		con = BaseDao.getConnection();
		String sql = "select * from t_user where username = ? AND userpassword = ?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		// 什么时候往query里面传值什么时候直接（）就好？
		rs = pstmt.executeQuery();
		if (rs.next()) {
			flag = true;
		}
		BaseDao.closeAll(rs, pstmt, con);
		return flag;
	}

	@Override
	public boolean isAdminLogin(User user) throws Exception {
		boolean flag = false;
		con = BaseDao.getConnection();
		String sql = "select * from t_user where username = ? AND userpassword = ?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("authority").equals("admin"))
				flag = true;
		}
		BaseDao.closeAll(rs, pstmt, con);
		return flag;
	}

	@Override
	public boolean isManagerLogin(User user) throws Exception {
		boolean flag = false;
		con = BaseDao.getConnection();
		String sql = "select * from t_user where username = ? AND userpassword = ?;";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getUserPassword());
		rs = pstmt.executeQuery();
		while (rs.next()) {
			if (rs.getString("authority").equals("manager"))
				flag = true;
		}
		BaseDao.closeAll(rs, pstmt, con);
		return flag;
	}
}
