package com.pb.dao;

import java.util.List;

import com.pb.entity.User;
import com.pb.vo.Page;

//why we have to implement this interface?what if we directly create the insiede one?
public interface UserDao {
	public boolean isLogin(User user) throws Exception;

	public int addUser(User user) throws Exception;

	public int deleteUser(User user) throws Exception;

	public int updateUser(User user) throws Exception;

	public User findUserById(int id) throws Exception;

	public List<User> findAllUsers() throws Exception;

	// 分页查询
	public Page findUsersByPage(int currentPage, int pageSize) throws Exception;

	// 模糊查询
	public List<User> findUsersByMohu(String... keyWords) throws Exception;

	// 模糊和分页查询
	public Page findUsersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

	// 判断时哪种权限登陆
	public boolean isAdminLogin(User user) throws Exception;

	public boolean isManagerLogin(User user) throws Exception;

}
