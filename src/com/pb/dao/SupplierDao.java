package com.pb.dao;

import java.util.List;

import com.pb.entity.Supplier;
import com.pb.vo.Page;

public interface SupplierDao {
	public int addSupplier(Supplier supplier) throws Exception;

	public int deleteSupplier(Supplier supplier) throws Exception;

	public int updateSupplier(Supplier supplier) throws Exception;

	public Supplier findSupplierById(int id) throws Exception;

	public List<Supplier> findAllSuppliers() throws Exception;

	// 分页查询
	public Page findSuppliersByPage(int currentPage, int pageSize)
			throws Exception;

	// 模糊查询
	public List<Supplier> findSuppliersByMohu(String... keyWords)
			throws Exception;

	// 模糊和分页查询
	public Page findSuppliersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

}
