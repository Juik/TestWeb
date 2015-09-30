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

	// ��ҳ��ѯ
	public Page findUsersByPage(int currentPage, int pageSize) throws Exception;

	// ģ����ѯ
	public List<User> findUsersByMohu(String... keyWords) throws Exception;

	// ģ���ͷ�ҳ��ѯ
	public Page findUsersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

	// �ж�ʱ����Ȩ�޵�½
	public boolean isAdminLogin(User user) throws Exception;

	public boolean isManagerLogin(User user) throws Exception;

}
