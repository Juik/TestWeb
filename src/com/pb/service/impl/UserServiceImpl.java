package com.pb.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.pb.dao.UserDao;
import com.pb.dao.impl.UserDaoImpl;
import com.pb.entity.User;
import com.pb.service.UserService;
import com.pb.vo.Page;

public class UserServiceImpl implements UserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public boolean addUser(User user) {
		boolean flag = false;
		try {
			int rowAffects = userDao.addUser(user);
			if (rowAffects == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean deleteUser(User user) {
		boolean flag = false;
		try {
			int rowAffects = userDao.deleteUser(user);
			if (rowAffects == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = null;
		try {
			users = userDao.findAllUsers();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User findUserById(Integer id) {
		User user = null;
		try {
			user = userDao.findUserById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return user;
	}

	// 判断时什么类型登陆
	@Override
	public boolean isLogin(User user) {
		boolean flag = false;
		try {
			flag = userDao.isLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	@Override
	public boolean isAdminLogin(User user) {
		boolean flag = false;
		try {
			flag = userDao.isAdminLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean isManagerLogin(User user) {
		boolean flag = false;
		try {
			flag = userDao.isManagerLogin(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean updateUser(User user) {
		boolean flag = false;
		try {
			int rowAffects = userDao.updateUser(user);
			if (rowAffects == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public Page findUsersByPage(int currentPage, int pageSize) {
		Page page = null;

		try {
			page = userDao.findUsersByPage(currentPage, pageSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return page;
	}

	@Override
	public List<User> findUsersByMohu(String... keyWords) throws Exception {
		List<User> users = new ArrayList<User>();
		users = userDao.findUsersByMohu(keyWords);
		return users;
	}

	@Override
	public Page findUsersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception {
		Page page = null;
		page = userDao.findUsersByPageAndMohu(currentPage, pageSize, keyWords);
		if (page.getCurrentPageData() == null
				|| page.getCurrentPageData().size() == 0) {
			page.setCurrentPageData(null);
		}
		return page;
	}

}
