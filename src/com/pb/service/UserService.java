package com.pb.service;

import java.util.List;

import com.pb.entity.User;
import com.pb.vo.Page;

public interface UserService {
	public boolean isLogin(User user);

	// �ж���ʲô�û���½
	public boolean isAdminLogin(User user);

	public boolean isManagerLogin(User user);

	public boolean addUser(User user);

	public boolean deleteUser(User user);

	public boolean updateUser(User user);

	public User findUserById(Integer id);

	public List<User> findAllUsers();

	public Page findUsersByPage(int currentPage, int pageSize) throws Exception;

	public List<User> findUsersByMohu(String... keyWords) throws Exception;

	public Page findUsersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

}
