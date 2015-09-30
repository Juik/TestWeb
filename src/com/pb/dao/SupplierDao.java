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

	// ��ҳ��ѯ
	public Page findSuppliersByPage(int currentPage, int pageSize)
			throws Exception;

	// ģ����ѯ
	public List<Supplier> findSuppliersByMohu(String... keyWords)
			throws Exception;

	// ģ���ͷ�ҳ��ѯ
	public Page findSuppliersByPageAndMohu(int currentPage, int pageSize,
			String... keyWords) throws Exception;

}
