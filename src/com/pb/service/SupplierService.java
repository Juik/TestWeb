package com.pb.service;

import java.util.List;

import com.pb.entity.Supplier;
import com.pb.entity.User;
import com.pb.vo.Page;

public interface SupplierService {
	public boolean isLogin(User user);

	// 判断是什么用户登陆
	public boolean isAdminLogin(User user);

	public boolean isSManagerLogin(User user);

	public boolean addSupplier(Supplier supplier);

	public boolean deleteSupplier(Supplier supplier);

	public boolean updateSupplier(Supplier supplier);

	public Supplier findSupplierById(Integer id);

	public List<Supplier> findAllSuppliers();

	public Page findSuppliersByPage(int currentPage, int pageSize)
			throws Exception;

	public List<Supplier> findSuppliersByMohu(String... keyWords)
			throws Exception;

	public Page findSuppliersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

}
